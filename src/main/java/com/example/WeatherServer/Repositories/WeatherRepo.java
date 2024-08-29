package com.example.WeatherServer.Repositories;

import com.example.WeatherServer.Models.WeatherDataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherDataClass, Long>{
    public List<WeatherDataClass> getByDate(Timestamp date);
}
