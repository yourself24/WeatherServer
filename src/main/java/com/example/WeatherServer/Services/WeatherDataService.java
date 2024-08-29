package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherDataClass;
import com.example.WeatherServer.Repositories.WeatherRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class WeatherDataService {
    private final WeatherRepo weatherRepo;


    public WeatherDataService(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }
    public List<WeatherDataClass> getAllWeatherData(){
        return weatherRepo.findAll();
    }
    public List<WeatherDataClass> getWeatherDataByDate(Timestamp date){
        return weatherRepo.getByDate(date);
    }
    public WeatherDataClass createWeatherData(WeatherDataClass weatherData){
        return weatherRepo.save(weatherData);
    }
}
