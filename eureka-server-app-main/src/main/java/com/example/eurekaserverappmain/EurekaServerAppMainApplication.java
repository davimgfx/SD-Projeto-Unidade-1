package com.example.eurekaserverappmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerAppMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerAppMainApplication.class, args);
	}

}
