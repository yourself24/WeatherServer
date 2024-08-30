package com.example.WeatherServer.Repositories;

import com.example.WeatherServer.Models.WeatherDataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherDataClass, Long>{
    public List<WeatherDataClass> getByDate(LocalDateTime date);
    public List<WeatherDataClass> getByUserid(Long userId);
}
