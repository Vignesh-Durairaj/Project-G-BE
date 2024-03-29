package com.epam.hack.ProjectG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"${controllers}"})
public class ProjectGApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectGApplication.class, args);
	}
}
