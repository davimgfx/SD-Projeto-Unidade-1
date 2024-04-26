package com.example.ispserverapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "profile-app", url = "http://localhost:8181")
public interface GetProfileApp {

  @PostMapping("/perfil")
   String callProfileApp(@RequestBody Map<String, String> requestBody);
}
