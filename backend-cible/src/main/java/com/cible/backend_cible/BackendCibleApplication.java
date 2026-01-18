package com.cible.backend_cible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cible.backend_cible.db")
@EntityScan(basePackages = "com.cible.backend_cible.model.task")
public class BackendCibleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCibleApplication.class, args);
	}

}
