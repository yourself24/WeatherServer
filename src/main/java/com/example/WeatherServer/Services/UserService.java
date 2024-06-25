package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.User;
import com.example.WeatherServer.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

    public User createUser(User user){
        return userRepo.save(user);
    }


}

