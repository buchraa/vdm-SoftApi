package com.virementdemasse.virementSoftApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class VirementSoftApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirementSoftApiApplication.class, args);
	}

}
