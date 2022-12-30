package com.example.dronescanner.storage;


import com.example.dronescanner.parser.DataParser;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ViolationBank {
    private Map<Long, Object> bank;
    private final long maxAge;
    private DataParser dataParser;

    public ViolationBank(DataParser dataParser) {
        this.dataParser = dataParser;
        this.bank = new LinkedHashMap<>();
        this.maxAge = 10 * 60 * 1000; // 10 min
    }

    public void insert(Object obj) {
        long timestamp = System.currentTimeMillis();
        bank.putIfAbsent(timestamp, obj);
    }

    public void removeExpiredViolations() {
        long currentTime = System.currentTimeMillis();
        bank.entrySet().removeIf(entry -> (currentTime - entry.getKey()) > maxAge);
    }
}