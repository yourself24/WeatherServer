package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Services.VisualCrossingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather/VCdata")
public class VisualCrossingController {
    private final VisualCrossingService visualCrossingService;

    public VisualCrossingController(VisualCrossingService visualCrossingService) {
        this.visualCrossingService = visualCrossingService;
    }
    @GetMapping("/current/{latitude}/{longitude}")
    public VisualCrossing getCurrentData(@PathVariable double latitude, @PathVariable double longitude){
        //consume the latitude and longitude from the URL
        return visualCrossingService.getVisualCrossingData(latitude, longitude);

    }

}
