package com.example.WeatherServer.Repositories;

import com.example.WeatherServer.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public User findUserByEmail(String email);
}
