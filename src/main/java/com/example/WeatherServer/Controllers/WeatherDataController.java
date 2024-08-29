package com.example.WeatherServer.Controllers;

import com.example.WeatherServer.Models.WeatherDataBody;
import com.example.WeatherServer.Models.WeatherDataClass;
import com.example.WeatherServer.Services.WeatherDataService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/weather/alData")
public class WeatherDataController {

    private final WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping("/get")
    public List<WeatherDataClass> getAllData(){
        return weatherDataService.getAllWeatherData();
    }
    @GetMapping("getDate/{date}")
    public List<WeatherDataClass> getDataByDate(@PathVariable OffsetDateTime date){
        Timestamp date1 = Timestamp.valueOf(date.toLocalDateTime());
        return weatherDataService.getWeatherDataByDate(date1);
    }
    @PostMapping("/add")
    public WeatherDataClass addData(@RequestBody WeatherDataBody weatherData){
        WeatherDataClass savedData = new WeatherDataClass(weatherData.getProvider(), weatherData.getAddress(),
                weatherData.getTemperature(),
                weatherData.getFeels(), weatherData.getPrecipitation(), weatherData.getHumidity(),
                weatherData.getPressure(),
                weatherData.getUserid(), weatherData.getDate());

        return weatherDataService.createWeatherData(savedData);
    }
}
