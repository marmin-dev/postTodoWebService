package com.mypost.todopost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodopostApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodopostApplication.class, args);
	}

}
