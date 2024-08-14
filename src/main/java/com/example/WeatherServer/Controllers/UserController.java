package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.LoginUser;
import com.example.WeatherServer.Models.UpdatedUser;
import com.example.WeatherServer.Models.User;
import com.example.WeatherServer.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;

    public UserController(AuthenticationManager authenticationManager, UserService userService, SecurityContextRepository securityContextRepository) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.securityContextRepository = securityContextRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
    return userService.getAllUsers();
    }
    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable  Long id){
        return userService.getUserById(id);
    }
    @GetMapping("/getEmail/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginUser loginUser, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> res = new HashMap<>();
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            SecurityContext context = SecurityContextHolder.getContext();
            securityContextRepository.saveContext(context, request, response);

            res.put("message", "Login successful!");
            res.put("sessionId", request.getSession().getId());
            return ResponseEntity.ok(res);
        } catch (BadCredentialsException e) {
            res.put("message", "Login failed: Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
        } catch (Exception e) {
            res.put("message", "Login failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    @PostMapping("/update/{id}")
    public User updateUser(@RequestBody UpdatedUser user, @PathVariable Long id){
        User updatingUser = userService.getUserById(id).orElse(null);
        if(updatingUser == null){
            return null;
        }
        updatingUser.setEmail(user.getEmail());
        updatingUser.setName(user.getName());
        updatingUser.setLocation(user.getLocation());
        updatingUser.setRole(user.getRole());
        userService.updateUser(updatingUser);

        return updatingUser;
    }

    @PostMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "Logout successful!";
    }
}


