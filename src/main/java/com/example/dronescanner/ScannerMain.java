package com.example.dronescanner;

import com.example.dronescanner.parser.DataParser;
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

    public ScannerMain() {
        this.violationBank = new ViolationBank(dataParser);
        this.noDroneZone = new NoDroneZone(violationBank);
    }

    @SneakyThrows
    public void handle(String xml) {
        noDroneZone.checkIfIllegalArea(dataParser.parseReport(xml).getCapture().getDrone());

        violationBank.removeExpiredViolations();

        ObjectMapper mapper = new ObjectMapper();

        json = mapper.writeValueAsString(violationBank.getBank());
    }
}
