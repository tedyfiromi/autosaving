package com.santander.goal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.santander.goal"})
public class GoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalApplication.class, args);
	}

}
