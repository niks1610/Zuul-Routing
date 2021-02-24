package com.craterzone.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PostClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostClientApplication.class, args);
	}

}
