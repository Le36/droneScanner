package com.example.dronescanner;

import com.example.dronescanner.parser.DataParser;
import com.example.dronescanner.storage.ViolationBank;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Data
public class ScannerMain {

    private final List<String> violations = new ArrayList<>();
    private DataParser dataParser = new DataParser();
    private ViolationBank violationBank;
    private NoDroneZone noDroneZone;

    public ScannerMain() {
        this.violationBank = new ViolationBank(dataParser);
        this.noDroneZone = new NoDroneZone(violationBank);
    }

    @SneakyThrows
    public void handle(String xml) {
        dataParser.parseXml(xml);

        noDroneZone.checkIfIllegalArea(dataParser.getReport().getCapture().getDrone());

        violationBank.removeExpiredViolations();

        violations.add(violationBank.getBank().toString());
    }
}
