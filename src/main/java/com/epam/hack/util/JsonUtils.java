package com.epam.hack.util;

import java.io.File;
import java.io.IOException;

import com.epam.hack.model.ErrorResponse;
import com.epam.hack.model.TransactionHistory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private JsonUtils() {}
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String readJsonFromFile() throws JsonParseException, JsonMappingException, IOException{
		TransactionHistory history = mapper.readValue(new File("C:\\Users\\Vignesh\\Desktop\\FinTech Hackathon 2019\\transactionData.json"), TransactionHistory.class);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(history);
	}
	
	public static String returnErrorResponse(String message) {
		ErrorResponse response = new ErrorResponse(message);
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
