package com.example.dronescanner.parser.scanner;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Capture {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Drone> drone;
    private Date snapshotTimestamp;
}