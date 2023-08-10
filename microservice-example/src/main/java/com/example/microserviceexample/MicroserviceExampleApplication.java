package com.example.microserviceexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MicroserviceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExampleApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			//verify password etc
			System.out.println("Testing cmd line runner");
		};
	}
}
