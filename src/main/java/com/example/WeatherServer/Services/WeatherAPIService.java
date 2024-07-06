package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherProviders.WeatherAPI;
import com.example.WeatherServer.Models.WeatherProviders.WeatherBit;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherAPIService {
    private final RestTemplate restTemplate = new RestTemplate();


    public WeatherAPI getWeatherAPIData() {
        String keyAPI = "e21afa5f14fe44d58c9183936240407";
        String url = "http://api.weatherapi.com/v1/current.json?aqi=yes&q=Dej&key="+
                keyAPI;
        System.out.println(url);
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);

        return parseWeatherAPIResp(jsonNode);
    }

    private WeatherAPI parseWeatherAPIResp(JsonNode node) {
        WeatherAPI weatherAPI = new WeatherAPI();
        weatherAPI.setAddress(node.path("location").path("name").asText()
                + ", " + node.path("location").path("region").asText()
                +"," + node.path("location").path("country").asText() );
        weatherAPI.setDescription(node.path("current").path("condition").path("text").asText());
        weatherAPI.setTemperature(node.path("current").path("temp_c").asDouble());
        weatherAPI.setFeelsLike(node.path("current").path("feelslike_c").asDouble());
        weatherAPI.setPrecip(node.path("current").path("precip_mm").asDouble());
        weatherAPI.setHumidity(node.path("current").path("humidity").asInt());
        weatherAPI.setPressure(node.path("current").path("pressure_mb").asDouble());
        return weatherAPI;
    }


}
