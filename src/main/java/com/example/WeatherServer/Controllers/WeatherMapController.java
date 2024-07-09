package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Models.WeatherProviders.WeatherMap;
import com.example.WeatherServer.Services.VisualCrossingService;
import com.example.WeatherServer.Services.WeatherMapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather/WMData")
public class WeatherMapController {
    private final WeatherMapService weatherMapService;

    public WeatherMapController(WeatherMapService weatherMapService) {
        this.weatherMapService = weatherMapService;
    }
    @GetMapping("/current")
    public WeatherMap getCurrentData(){
        return weatherMapService.getWeatherMapData();
    }
}
