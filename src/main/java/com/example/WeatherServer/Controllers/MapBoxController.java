package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.TomorrowIo;
import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Services.MapBoxService;
import com.example.WeatherServer.Services.TomorrowIoService;
import com.example.WeatherServer.Services.VisualCrossingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather /LocationData")
public class MapBoxController {
    private final MapBoxService mapBoxService;


    public MapBoxController(MapBoxService mapBoxService) {
        this.mapBoxService = mapBoxService;
    }

    @GetMapping("/current/{longitude}/{latitude}")
    public String getCurrentLocation(@PathVariable double longitude, @PathVariable double latitude){
        return"\"" + mapBoxService.getLocation(longitude, latitude)+ "\"";
    }

}
