package com.example.dronescanner.storage;


import com.example.dronescanner.parser.DataParser;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ViolationBank {
    private Map<String, Violator> bank;
    private final long maxAge;
    private DataParser dataParser;

    public ViolationBank(DataParser dataParser) {
        this.dataParser = dataParser;
        this.bank = new HashMap<>();
        this.maxAge = 10 * 60 * 1000; // 10 min
    }

    public void insert(Violator violator) {
        long timestamp = System.currentTimeMillis();
        violator.setTime(timestamp);
        bank.put(violator.getPilot().getPilotId(), violator);
    }

    public void removeExpiredViolations() {
        long currentTime = System.currentTimeMillis();
        bank.entrySet().removeIf(entry -> (currentTime - entry.getValue().getTime()) > maxAge);
    }
}