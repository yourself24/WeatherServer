package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.TomorrowIo;
import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Services.TomorrowIoService;
import com.example.WeatherServer.Services.VisualCrossingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather/TIOData")
public class TomorrowIoController {
    private final TomorrowIoService tomorrowIoService;

    public TomorrowIoController(TomorrowIoService tomorrowIoService) {
        this.tomorrowIoService = tomorrowIoService;
    }
    @GetMapping("/current")
    public TomorrowIo getCurrentData(){
        return tomorrowIoService.getTomorrowIoData();
    }

}
