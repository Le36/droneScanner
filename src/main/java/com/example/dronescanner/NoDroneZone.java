package com.example.dronescanner;

import com.example.dronescanner.parser.pilot.Pilot;
import com.example.dronescanner.parser.scanner.Drone;
import com.example.dronescanner.storage.PilotDataGetter;
import com.example.dronescanner.storage.ViolationBank;

import java.lang.Math;
import java.util.List;

public class NoDroneZone {

    private final ViolationBank violationBank;
    private final PilotDataGetter pilotDataGetter = new PilotDataGetter();

    public NoDroneZone(ViolationBank violationBank) {
        this.violationBank = violationBank;
    }

    public void checkIfIllegalArea(List<Drone> drones) {
        for (Drone x : drones) {
            this.calculateIfInside(x);
        }
    }

    private void calculateIfInside(Drone drone) {
        // position of the drone
        double x1 = drone.getPositionX();
        double y1 = drone.getPositionY();

        // position of the center
        double x2 = 250000.0;
        double y2 = 250000.0;

        double radius = 100000.0;

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (distance <= radius) {
            Pilot pilot = pilotDataGetter.GetPilotData(drone.getSerialNumber());
            if (pilot == null) return; // 404 etc.
            violationBank.insert(pilot);
            System.out.println("added to bank+   " + drone);
        }
    }
}