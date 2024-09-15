package com.suvankar.ChallengeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan(basePackages = "com.suvankar.ChallengeApp")
public class ChallengeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAppApplication.class, args);
	}

}
