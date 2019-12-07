package com.epam.hack.ProjectG;

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
	
	@RequestMapping("/transaction/history")
	public String getTransactionDetails() {
		return JsonUtils.readJsonFromFile();
	}

}
