package com.carcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

@SpringBootApplication
public class CarcontrolApplication {

public static void main(String[] args) {
		SpringApplication.run(CarcontrolApplication.class, args);
	}

}
