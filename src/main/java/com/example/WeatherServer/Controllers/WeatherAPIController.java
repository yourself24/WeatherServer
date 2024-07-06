package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.WeatherAPI;
import com.example.WeatherServer.Models.WeatherProviders.WeatherBit;
import com.example.WeatherServer.Services.WeatherAPIService;
import com.example.WeatherServer.Services.WeatherBitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/WeatherAPIData")
public class WeatherAPIController {
    private final WeatherAPIService weatherAPIService;

    public WeatherAPIController(WeatherAPIService weatherAPIService) {
        this.weatherAPIService= weatherAPIService;
    }
    @GetMapping("/current")
    public WeatherAPI getCurrentData(){
        return weatherAPIService.getWeatherAPIData();
    }

}
