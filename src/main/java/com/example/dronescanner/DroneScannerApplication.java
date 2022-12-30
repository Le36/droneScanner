package com.example.dronescanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableScheduling
@Controller
public class DroneScannerApplication {

    private final ScannerMain scannerMain = new ScannerMain();

    public static void main(String[] args) {
        SpringApplication.run(DroneScannerApplication.class, args);
    }

    @Scheduled(fixedRate = 2000)
    public void listen() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://assignments.reaktor.com/birdnest/drones", String.class);
        scannerMain.handle(response);
    }

    @GetMapping("/violations")
    @ResponseBody
    public String getResponses() {
        return scannerMain.getJson();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}