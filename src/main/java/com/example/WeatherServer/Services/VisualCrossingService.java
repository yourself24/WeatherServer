package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherProviders.VisualCrossing;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class VisualCrossingService {
    private final RestTemplate restTemplate = new RestTemplate();


    public VisualCrossing getVisualCrossingData(double lat, double lon) {
        String keyAPI = "KCG89E6H2L9LZ26J4GXXL5GSB";
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter vcFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String formattedTime = currentTime.format(vcFormatter);
        String url2 = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"+lat+","+lon+"/"+formattedTime+"?units=metric&key=" + keyAPI;
        System.out.println(url2);
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Dej,RO/2024-07-04T21:20:00?units=metric&key=" + keyAPI;
        JsonNode jsonNode = restTemplate.getForObject(url2, JsonNode.class);
        return parseVisualCrossingResp(jsonNode);
    }

    private VisualCrossing parseVisualCrossingResp(JsonNode node){
        VisualCrossing visualCrossing = new VisualCrossing();
        visualCrossing.setAddress(node.get("resolvedAddress").asText());
        visualCrossing.setDescription(node.path("resolvedAddress").asText());

        JsonNode currDay = node.path("days").get(0);
        visualCrossing.setTemperature(currDay.path("temp").asDouble());
        visualCrossing.setFeelsLike(currDay.path("feelslike").asDouble());
        visualCrossing.setPrecip(currDay.path("precip").asDouble());
        visualCrossing.setHumidity(currDay.path("humidity").asInt());
        visualCrossing.setPressure(currDay.path("pressure").asDouble());

        return visualCrossing;

    }
}
