package com.example.WeatherServer.Controllers;


import com.example.WeatherServer.Models.WeatherProviders.WeatherBit;
import com.example.WeatherServer.Services.WeatherBitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather/WeatherBitData")
public class WeatherBitController {
    private final WeatherBitService weatherBitService;

    public WeatherBitController(WeatherBitService weatherBitService) {
        this.weatherBitService = weatherBitService;
    }
    @GetMapping("/current/{latitude}/{longitude}")
    public WeatherBit getCurrentData(@PathVariable double latitude, @PathVariable double longitude){
        return weatherBitService.getWeatherBitData(latitude, longitude);
    }

}
