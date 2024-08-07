package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherProviders.WeatherMap;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherMapService {
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherMap getWeatherMapData(double latitude, double longitude){
        String APIKey = "4017fbd4ce5be8d9f707a026659cbd15";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="
                +latitude
                +"&lon="
                +longitude
                +"&units=metric&appid="
                + APIKey;
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);
        return parseWeatherMapResp(jsonNode);

    }
    private WeatherMap parseWeatherMapResp(JsonNode node){
        WeatherMap weatherMap = new WeatherMap();
        weatherMap.setDescription(node.path("weather").get(0).path("description").asText());
        weatherMap.setTemperature(node.path("main").path("temp").asDouble());
        weatherMap.setFeelsLike(node.path("main").path("feels_like").asDouble());
        weatherMap.setAddress(node.path("name").asText());
        weatherMap.setHumidity(node.path("main").path("humidity").asInt());
        weatherMap.setPressure(node.path("main").path("pressure").asDouble());
        weatherMap.setPrecip(0.0);
        return weatherMap;

    }

}
