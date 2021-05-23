package com.example.disertatie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@SpringBootApplication(exclude = {Dat/aSourceAutoConfiguration.class, MongoAutoConfiguration.class })
@SpringBootApplication()
public class DisertatieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisertatieApplication.class, args);
	}

}
