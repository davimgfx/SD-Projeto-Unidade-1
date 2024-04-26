package com.example.ispserverapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "validacao-app", url = "http://localhost:8182")
public interface GetValidacaoApp {

   @PostMapping("/validate")
   String callValidationApp(@RequestBody Map<String, String> requestBody);
}
