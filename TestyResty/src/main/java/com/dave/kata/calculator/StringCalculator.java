package com.dave.kata.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringCalculator.java
 *
 * 20 Aug 2024
 * Version 1.0.0 - Initial version
 * Author - davej
 * 
 */
public class StringCalculator {
	
	public int add(String numbers) {
		
		List<String> numberList = null;
		
		String delimiters = ",|\n";
		String numberString = numbers;
		
		if(numbers.startsWith("//")) {
			int delimiterEndIndex = numbers.indexOf("\n");
            String delimiterStrings = numbers.substring(2, delimiterEndIndex);
            
            if (delimiterStrings.startsWith("[") && delimiterStrings.endsWith("]")) {
                Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterStrings);
                StringBuilder delimiterPattern = new StringBuilder();
                while (matcher.find()) {
                    String customDelimiter = matcher.group(1);
                    delimiterPattern.append(Pattern.quote(customDelimiter)).append("|");
                }
                // Remove the last "|"
                delimiters = delimiterPattern.substring(0, delimiterPattern.length() - 1);
            } else {
                // Single character delimiter without brackets
                delimiters = Pattern.quote(delimiterStrings);
            }
            numberString = numbers.substring(delimiterEndIndex + 1);
		}
		
		if(!numbers.isBlank()) {
			numberList = Arrays.asList(numberString.split(delimiters));
		}
		
		int total = 0;
		
		if(numberList != null && !numberList.isEmpty()){
			
			List<String> invalidNumbers = new ArrayList<>();
			boolean invalidNumbersEncountered = false;
			for(String number : numberList) {
				if(number.startsWith("-")) {
					invalidNumbers.add(number);
					invalidNumbersEncountered = true;
				} 
				total = total + Integer.parseInt(number);					
				
			}
			if(invalidNumbersEncountered) {
				throw new NumberFormatException("Negative numbers not allowed: " + invalidNumbers);
			} 
			
		}
		
		return total;
		
		
	}

}
