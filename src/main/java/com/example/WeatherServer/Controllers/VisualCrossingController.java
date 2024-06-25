package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Services.VisualCrossingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/VCdata")
public class VisualCrossingController {
    private final VisualCrossingService visualCrossingService;

    public VisualCrossingController(VisualCrossingService visualCrossingService) {
        this.visualCrossingService = visualCrossingService;
    }
    @GetMapping("/current")
    public VisualCrossing getCurrentData(){
        return visualCrossingService.getVisualCrossingData();
    }

}
