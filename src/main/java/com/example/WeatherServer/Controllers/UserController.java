package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.User;
import com.example.WeatherServer.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
    return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable  Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

}
