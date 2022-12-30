package com.example.dronescanner.parser.scanner;

import lombok.Data;

@Data
public class Drone {
    private String serialNumber;
    private String model;
    private String manufacturer;
    private String mac;
    private String ipv4;
    private String ipv6;
    private String firmware;
    private double positionY;
    private double positionX;
    private double altitude;
}