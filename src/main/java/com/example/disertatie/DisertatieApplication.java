package com.example.disertatie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DisertatieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisertatieApplication.class, args);
	}

}
