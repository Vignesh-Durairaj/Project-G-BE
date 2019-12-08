package com.epam.hack.app.util;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.epam.hack.model.ErrorResponse;
import com.epam.hack.model.TransactionHistory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonHelper {
	
	private JsonHelper() {}
	private ObjectMapper mapper = new ObjectMapper();
	
	public String readJsonFromFile() {
		try {
			TransactionHistory history = unMarshallFromFile(new File("C:\\Users\\Vignesh\\Desktop\\FinTech Hackathon 2019\\transactionData.json"), TransactionHistory.class);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(history);
		} catch (IOException e) {
			e.printStackTrace();
			return getErrorRespose(e.getMessage());
		}
	}
	
	public <T extends Object> T unMarshallFromFile(File jsonFile, Class<T> clazz) throws IOException {
		try {
			return (T) mapper.readValue(jsonFile, clazz);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public <T extends Object> T unMarshall(String json, Class<T> clazz) throws JsonProcessingException{
		try {
			return (T) mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public <T extends Object> String marshall(T t) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return getErrorRespose(e.getMessage());
		}
	}
	
	public <T extends Object> List<T> unMarshallListFromFile(File jsonFile, Class<T> clazz) throws IOException{
		try {
			return mapper.readValue(jsonFile, new TypeReference<List<T>>() {});
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public <T extends Object> List<T> unMarshallList(String json, Class<T> clazz) throws JsonProcessingException{
		try {
			return mapper.readValue(json, new TypeReference<List<T>>() {});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public String getErrorRespose(String message) {
		ErrorResponse response = new ErrorResponse(message);
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "{\"message\": \"Comething is really really wrong\"}";
		}
	}
	
	public String getJsonFromFile(File file) throws IOException{
		StringBuilder builder = new StringBuilder();
		
		try (Stream<String> stream = Files.lines(file.toPath())) {
			stream
				.forEach(line -> builder.append(line));
		} catch (IOException e) {
			throw e;
		}
		
		return builder.toString();
	}
}
