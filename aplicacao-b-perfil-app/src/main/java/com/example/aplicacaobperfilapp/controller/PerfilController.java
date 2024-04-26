package com.example.aplicacaobperfilapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PerfilController {

    private Map<String, String> perfis = new HashMap<>();

    public PerfilController() {
        perfis.put("sampio@gmail.com", "Aluno");
        perfis.put("exemplo@hotmail.com", "Professor");
        perfis.put("usuario123@yahoo.com", "Funcionário");
        perfis.put("jose@email.com", "Aluno");
        perfis.put("ronaldo@ucsal.edu.br", "Professor");
    }

      @PostMapping("/perfil")
        public String obterPerfil(@RequestBody Map<String, String> requestBody) {
        try {
            String email = requestBody.get("email");
            String perfil = perfis.getOrDefault(email, "Usuário não tem perfil");
            return "Perfil do usuário: " + perfil;
        } catch (Exception e) {
            // Log the exception for further investigation
            e.printStackTrace();
            // Return a meaningful error message to the client
            return "Erro ao obter o perfil do usuário: " + e.getMessage();
        }
    }
}
