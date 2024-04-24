package com.example.aplicacaoavalidacaoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AplicacaoAValidacaoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoAValidacaoAppApplication.class, args);
	}

}
