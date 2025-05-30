package com.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaLeakageDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaLeakageDetectionApplication.class, args);
	}

}
