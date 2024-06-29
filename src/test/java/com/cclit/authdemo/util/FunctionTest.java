package com.cclit.authdemo.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;

public class FunctionTest {

	@Test
	public void timeCheckTest() {
		
		String timeString = "2024-06-06";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		try {
			date = formatter.parse(timeString);
		} catch (ParseException e) {
			System.out.println("Time transform failed!");
			e.printStackTrace();
		}
		
		assertNotNull(date);
		
	}
	
	@Test
	public void WrongTimeCheckTest() {
		
		String timeString = "2024-13-31";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		try {
			date = formatter.parse(timeString);
		} catch (ParseException e) {
			System.out.println("Time transform failed!");
			e.printStackTrace();
		}
		
		assertNotNull(date); // still works, the function will automate add the extra time
		
	}
	
	
	@Test
	public void WrongTimeCheckWithLocalDate() {
		
		String timeString = "2024-06-31";
		Boolean flag = true;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			LocalDate date = LocalDate.parse(timeString, formatter);
			System.out.println("Parsed date: " + date.toString()); // System transform the time to 2024-06-30...
		} catch (DateTimeParseException e) {
			flag = false;
		}
		
		assertFalse(flag); 
		
	}
	

}
