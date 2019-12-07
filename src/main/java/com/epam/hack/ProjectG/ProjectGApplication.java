package com.epam.hack.ProjectG;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hack.util.JsonUtils;

@SpringBootApplication
@RestController
public class ProjectGApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(name = "fn") String firstName, @RequestParam(name = "ln", required = false) String lastName) {
		return String.format("hello %s%s !", lastName != null ? (lastName + ", ") : "", firstName);
	}
	
	@RequestMapping("/transaction/history")
	public String getTransactionDetails() {
		try {
			return JsonUtils.readJsonFromFile();
		} catch (IOException e) {
			e.printStackTrace();
			return JsonUtils.returnErrorResponse(e.getMessage());
		}
	}

}
