package com.example.aplicacaoavalidacaoapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ValidationController {
    private List<String> emailList = new ArrayList<>();

    public ValidationController() {
        emailList.add("sampio@gmail.com");
        emailList.add("exemplo@hotmail.com");
        emailList.add("usuario123@yahoo.com");
        emailList.add("jose@email.com");
        emailList.add("ronaldo@ucsal.edu.br");
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        if (emailList.contains(email)) {
            return "E-mail válido: " + email;
        } else {
            return "E-mail não encontrado na lista";
        }
    }
}

