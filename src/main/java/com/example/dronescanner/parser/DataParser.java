package com.example.dronescanner.parser;

import com.example.dronescanner.parser.pilot.Pilot;
import com.example.dronescanner.parser.scanner.Report;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;

@Data
public class DataParser {

    private final ObjectMapper mapperXml = new XmlMapper();
    private final ObjectMapper mapperJson = new ObjectMapper();

    public Report parseReport(String xml) throws JsonProcessingException {
        return mapperXml.readValue(xml, Report.class);
    }

    public Pilot parsePilot(String json) throws JsonProcessingException {
        return mapperJson.readValue(json, Pilot.class);
    }
}
