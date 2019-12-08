package com.epam.hack.app.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DateHelper {

	public LocalDate getLastDateOfMonth(LocalDate localDate) {
		return localDate.withDayOfMonth(localDate.lengthOfMonth());
	}
}
