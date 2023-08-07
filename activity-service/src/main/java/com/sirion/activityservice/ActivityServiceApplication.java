package com.sirion.activityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ActivityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityServiceApplication.class, args);
	}
}
