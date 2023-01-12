package com.jat.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegitsryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegitsryApplication.class, args);
	}

}
