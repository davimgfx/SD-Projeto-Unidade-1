package com.example.aplicacaobperfilapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AplicacaoBPerfilAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoBPerfilAppApplication.class, args);
	}

}
