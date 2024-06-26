package com.example.eurekaserverappmain.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class ApplicationDiscoveryController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/health")
    public String healthy() {

        return "Sou o Eureka Server e estou online!" + LocalDateTime.now();
    }
}
