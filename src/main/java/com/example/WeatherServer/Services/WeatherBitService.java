package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.example.WeatherServer.Models.WeatherProviders.WeatherBit;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherBitService {
    private final RestTemplate restTemplate = new RestTemplate();


    public WeatherBit getWeatherBitData() {
        String keyAPI = "03c48fa4dd74495a997f76ecd3f91e476";
        String url = "https://api.weatherbit.io/v2.0/current?lat=47.14&lon=23.87&key=03c48fa4dd74495a997f76ecd3f91e47";

        System.out.println(url);
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);

        return parseWeatherBitResp(jsonNode);
    }

    private WeatherBit parseWeatherBitResp(JsonNode node) {
        WeatherBit weatherBit = new WeatherBit();
        JsonNode dataNode = node.path("data").get(0);
        weatherBit.setAddress(dataNode.path("city_name").asText());
        weatherBit.setDescription(dataNode.path("weather").path("description").asText());
        weatherBit.setTemperature(dataNode.path("temp").asDouble());
        weatherBit.setFeelsLike(dataNode.path("app_temp").asDouble());
        weatherBit.setPrecip(dataNode.path("precip").asDouble());
        // weatherBit.setHumidity(dataNode.path("rh").asInt()); // Assuming 'rh' is for humidity
        weatherBit.setPressure(dataNode.path("pres").asDouble());
        return weatherBit;
    }


}