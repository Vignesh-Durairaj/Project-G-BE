package com.epam.hack.app.util;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.epam.hack.model.ErrorResponse;
import com.epam.hack.model.TransactionHistory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonHelper {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private JsonHelper() {}
	private ObjectMapper mapper = new ObjectMapper();
	
	public String readJsonFromFile() {
		try {
			TransactionHistory history = unMarshallFromFile(new File("C:\\Users\\Vignesh\\Desktop\\FinTech Hackathon 2019\\transactionData.json"), TransactionHistory.class);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(history);
		} catch (IOException e) {
			logger.error("Exception while reading JSON data from file", e);
			return getErrorRespose(e.getMessage());
		}
	}
	
	public <T extends Object> T unMarshallFromFile(File jsonFile, Class<T> clazz) throws IOException {
		try {
			return mapper.readValue(jsonFile, clazz);
		} catch (IOException e) {
			logger.error("Exception while unmarshalling JSON data from file", e);
			throw e;
		}
	}
	
	public <T extends Object> T unMarshall(String json, Class<T> clazz) throws JsonProcessingException{
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			logger.error("Exception while unmarshalling input data", e);
			throw e;
		}
	}
	
	public <T extends Object> String marshall(T t) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
		} catch (JsonProcessingException e) {
			logger.error("Exception while marshalling object", e);
			return getErrorRespose(e.getMessage());
		}
	}
	
	public <T extends Object> List<T> unMarshallListFromFile(File jsonFile) throws IOException{
		try {
			return mapper.readValue(jsonFile, new TypeReference<List<T>>() {});
		} catch (IOException e) {
			logger.error("Exception while unmarshalling list from file", e);
			throw e;
		}
	}
	
	public <T extends Object> List<T> unMarshallList(String json) throws JsonProcessingException{
		try {
			return mapper.readValue(json, new TypeReference<List<T>>() {});
		} catch (JsonProcessingException e) {
			logger.error("Exception while unmarshall a list object", e);
			throw e;
		}
	}

	public String getErrorRespose(String message) {
		ErrorResponse response = new ErrorResponse(message);
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		} catch (JsonProcessingException e) {
			logger.error("Exception while getting a error response", e);
			return "{\"message\": \"Comething is really really wrong\"}";
		}
	}
	
	public String getJsonFromFile(File file) {
		StringBuilder builder = new StringBuilder();
		try (Stream<String> stream = Files.lines(file.toPath())) {
			stream.forEach(builder::append);
		} catch (IOException e) {
			logger.error("Exception while reading a JSON file", e);
		}
		
		return builder.toString();
	}
}

