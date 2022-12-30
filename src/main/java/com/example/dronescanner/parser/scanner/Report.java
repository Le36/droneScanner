package com.example.dronescanner.parser.scanner;

import lombok.Data;

@Data
public class Report {
    private DeviceInformation deviceInformation;
    private Capture capture;
}