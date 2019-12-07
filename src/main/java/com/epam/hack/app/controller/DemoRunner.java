package com.epam.hack.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hack.app.util.JsonHelper;

@RestController
@RequestMapping("/demo")
public class DemoRunner {
	
	@Autowired private JsonHelper jsonHelper;
	
	@GetMapping("/readFile")
	public String getTransactionDetails() {
		return jsonHelper.readJsonFromFile();
	}
}
