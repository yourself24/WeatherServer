package com.example.WeatherServer.Services;

import com.example.WeatherServer.Models.WeatherProviders.WeatherBit;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class MapBoxService {
    private final RestTemplate restTemplate = new RestTemplate();
    public String getLocation(double longitude, double latitude) {
        String url = "https://api.mapbox.com/search/geocode/v6/reverse?longitude="
                +longitude
                +"&latitude="
                +latitude
                +"&access_token=pk.eyJ1IjoieW91cnNlbGYyNCIsImEiOiJjbHp3cTJoNjQwZnU2Mm1zaXJpMnNtNTNqIn0.JHC1lxO8mDOzigbd4OXcVQ";

        System.out.println(url);
        JsonNode jsonNode = restTemplate.getForObject(url, JsonNode.class);

        return parseMapBox(jsonNode);
    }

    private String parseMapBox(JsonNode node) {

        JsonNode dataNode = node.path("features").get(0).path("properties").path("full_address");
        System.out.println(dataNode.asText());
        return dataNode.asText();
    }

}
