package com.example.dronescanner;

import com.example.dronescanner.parser.DataParser;
import com.example.dronescanner.parser.scanner.Report;
import com.example.dronescanner.storage.ViolationBank;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;


@Data
public class ScannerMain {

    private String json;
    private DataParser dataParser = new DataParser();
    private ViolationBank violationBank;
    private NoDroneZone noDroneZone;
    private Report report;

    public ScannerMain() {
        this.violationBank = new ViolationBank(dataParser);
        this.noDroneZone = new NoDroneZone(violationBank);
    }

    @SneakyThrows
    public void handle(String xml) {
        report = dataParser.parseReport(xml);
        noDroneZone.checkIfIllegalArea(report.getCapture().getDrone());

        violationBank.removeExpiredViolations();

        ObjectMapper mapper = new ObjectMapper();

        json = mapper.writeValueAsString(violationBank.getBank());
    }
}
