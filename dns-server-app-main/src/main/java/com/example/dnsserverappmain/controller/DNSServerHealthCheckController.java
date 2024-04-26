package com.example.dnsserverappmain.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
public class DNSServerHealthCheckController {
    
    @GetMapping("/health")
    public String healthy() {
        return "Sou o DNS Server e estou online: " + LocalDateTime.now();
    }
}
