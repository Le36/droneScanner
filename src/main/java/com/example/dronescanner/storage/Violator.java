package com.example.dronescanner.storage;

import com.example.dronescanner.parser.pilot.Pilot;
import lombok.Data;

@Data
public class Violator {

    private Pilot pilot;
    private double distance;
    private long time;

    public Violator(Pilot pilot, double distance) {
        this.pilot = pilot;
        this.distance = distance;
    }
}
