package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherProviders.TomorrowIo;
import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class TomorrowIoService {
    private final RestTemplate restTemplate = new RestTemplate();


    public TomorrowIo getTomorrowIoData(String city) {
        String keyAPI = "zA0XJjbIktU6PkAfrAdlKzcRisj8pLAf";
        String url = "https://api.tomorrow.io/v4/weather/realtime?location="+ city+ "&apikey="
                + keyAPI;
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);
        return parseTomorrowResp(jsonNode);
    }

    private TomorrowIo parseTomorrowResp(JsonNode node){
        TomorrowIo tomorrowIo = new TomorrowIo();
       tomorrowIo.setAddress(node.path("location").path("name").asText());
        tomorrowIo.setTemperature(node.path("data").path("values").path("temperature").asDouble());
        tomorrowIo.setFeelsLike(node.path("data").path("values").path("temperatureApparent").asDouble());
        tomorrowIo.setPrecip(node.path("data").path("values").path("precipitationProbability").asDouble());
        tomorrowIo.setHumidity(node.path("data").path("values").path("humidity").asInt());
        tomorrowIo.setPressure(node.path("data").path("values").path("pressureSurfaceLevel").asDouble());

        return tomorrowIo;

    }
}
