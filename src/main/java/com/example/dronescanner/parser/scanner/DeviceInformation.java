package com.example.dronescanner.parser.scanner;

import lombok.Data;

import java.util.Date;

@Data
public class DeviceInformation {
    private String deviceId;
    private int listenRange;
    private Date deviceStarted;
    private long uptimeSeconds;
    private int updateIntervalMs;
}