package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories("com.example.repositories")
@EntityScan
public class OMDBAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(OMDBAPIApplication.class, args);
	}

}
