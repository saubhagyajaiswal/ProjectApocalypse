package com.apocalypse.survive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.apocalypse.survive")
public class SurviveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurviveApplication.class, args);
	}

}
