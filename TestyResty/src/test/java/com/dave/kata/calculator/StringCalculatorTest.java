package com.dave.kata.calculator;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	StringCalculator calc = new StringCalculator();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEmptyString() {
		int result = calc.add("");
		assertTrue(result == 0);
		
	}
	
	@Test
	public void testOneInteger() {
		int result = calc.add("3");
		assertTrue(result == 3);
		
	}
	@Test
	public void testTwoIntegers() {
		int result = calc.add("3,7");
		assertTrue(result == 10);
		
	}
	@Test
	public void testNewLine() {
		int result = calc.add("1\n2,3");
		assertTrue(result == 6);
		
	}
	@Test
	public void testLotsOfIntegers() {
		int result = calc.add("1\n2,3,7,9,5");
		assertTrue(result == 27);
		
	}
	@Test(expected = NumberFormatException.class)
	public void testNegativeNumbers() {
		int result = calc.add("-1,2");
		assertTrue(result == 27);
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void testMultipleNegativeNumbers() {
		int result = calc.add("-1,-2,3");
		assertTrue(result == 27);
		
	}
	
	
	@Test
	public void testMultipleDelims() {
		int result = calc.add("//;\n1;2");
		assertTrue(result == 3);
		
	}
	
	
	// Didn't get far enough to correct the code for "|" as a delimiter.
	@Test
	public void testMultipleDelims2() {
		int result = calc.add("//[|][%]\\n1|2%3");
		assertTrue(result == 6);
		
	}
	
	

}
