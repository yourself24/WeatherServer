package com.example.WeatherServer.Controllers;


import com.example.WeatherServer.Models.WeatherProviders.WeatherMap;
import com.example.WeatherServer.Services.WeatherMapService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather/WMData")
public class WeatherMapController {
    private final WeatherMapService weatherMapService;

    public WeatherMapController(WeatherMapService weatherMapService) {
        this.weatherMapService = weatherMapService;
    }
    @GetMapping("/current/{latitude}/{longitude}")
    public WeatherMap getCurrentData(@PathVariable double latitude, @PathVariable double longitude){
        return weatherMapService.getWeatherMapData(latitude, longitude);
    }
}
