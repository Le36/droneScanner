package com.example.dronescanner.storage;

import com.example.dronescanner.parser.DataParser;
import com.example.dronescanner.parser.pilot.Pilot;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.RestTemplate;

public class PilotDataGetter {

    private final DataParser dataParser = new DataParser();

    public Pilot GetPilotData(String id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject("https://assignments.reaktor.com/birdnest/pilots/" + id, String.class);
            return dataParser.parsePilot(response);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
