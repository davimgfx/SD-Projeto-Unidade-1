package com.example.dfs_aplicacao_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableFeignClients
@SpringBootApplication
public class DfsAplicacaoBApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfsAplicacaoBApplication.class, args);
	}

}
