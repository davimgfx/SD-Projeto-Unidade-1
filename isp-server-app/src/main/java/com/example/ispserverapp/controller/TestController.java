package com.example.ispserverapp.controller;

import com.example.ispserverapp.client.GetValidacaoApp;
import com.example.ispserverapp.client.GetProfileApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    GetValidacaoApp getValidacaoApp;

    @Autowired
    GetProfileApp getProfileApp;

    @PostMapping("/validate")
    public String callValidationApp(@RequestBody Map<String, String> requestBody) {
        try {
            return getValidacaoApp.callValidationApp(requestBody);
        } catch (Exception e) {
            // Log the exception for further investigation
            e.printStackTrace();
            // Return a meaningful error message to the client
            return "Erro ao chamar o serviço de validação: " + e.getMessage();
        }
    }

    @PostMapping("/profile")
    public String callProfileApp(@RequestBody Map<String, String> requestBody) {
        try {
            return getProfileApp.callProfileApp(requestBody);
        } catch (Exception e) {
            // Log the exception for further investigation
            e.printStackTrace();
            // Return a meaningful error message to the client
            return "Erro ao chamar o serviço de perfil: " + e.getMessage();
        }
    }
}
