package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Models.WeatherProviders.WeatherBit;
import com.example.WeatherServer.Services.VisualCrossingService;
import com.example.WeatherServer.Services.WeatherBitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/WeatherBitData")
public class WeatherBitController {
    private final WeatherBitService weatherBitService;

    public WeatherBitController(WeatherBitService weatherBitService) {
        this.weatherBitService = weatherBitService;
    }
    @GetMapping("/current")
    public WeatherBit getCurrentData(){
        return weatherBitService.getWeatherBitData();
    }

}
