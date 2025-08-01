package com.montlychallenges.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		System.out.println("Starting Monthly Challenges Application...");
		
		SpringApplication.run(ChallengeApplication.class, args);
	}

}
