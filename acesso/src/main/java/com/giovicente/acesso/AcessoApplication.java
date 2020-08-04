package com.giovicente.acesso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AcessoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcessoApplication.class, args);
	}

}
