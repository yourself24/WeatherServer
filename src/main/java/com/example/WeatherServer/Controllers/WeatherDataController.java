package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherDataBody;
import com.example.WeatherServer.Models.WeatherDataClass;
import com.example.WeatherServer.Services.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/weather/allData")
public class WeatherDataController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataController.class);
    private final WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {

        this.weatherDataService = weatherDataService;
    }

    @GetMapping("/get")
    public List<WeatherDataClass> getAllData(){
        weatherDataService.getAllWeatherData().forEach(weatherDataClass -> {
            System.out.println(weatherDataClass.toString());

        });
        return weatherDataService.getAllWeatherData();
    }
    @GetMapping("getDate/{date}")
    public List<WeatherDataClass> getDataByDate(@PathVariable LocalDateTime date){

        return weatherDataService.getWeatherDataByDate(date);
    }
    @GetMapping("getID/{id}")
    public List<WeatherDataClass> getDataById(@PathVariable Long id){

        return weatherDataService.getWeatherDataByUser(id);
    }
    @PostMapping("/add")
    public WeatherDataClass addData(@RequestBody WeatherDataClass weatherData){
        logger.debug("Received JSON: " + weatherData);
        System.out.println("Received JSON: " + weatherData);
        return weatherDataService.createWeatherData(weatherData);
    }
    @PostMapping("/addFake")
    public WeatherDataClass addFake(@RequestBody LocalDateTime time){
        WeatherDataClass weatherData = new WeatherDataClass(

                "FakeProvider", "FakeAddress", 0.0, 0.0, 0.0, 0, 0.0, 5L,time);
        return weatherDataService.createWeatherData(weatherData);
    }
}
