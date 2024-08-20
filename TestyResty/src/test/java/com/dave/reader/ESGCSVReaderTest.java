package com.dave.reader;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dave.model.ESGCustomer;

/**
 * ESGCSVReaderTest.java
 *
 * 20 Aug 2024
 * Version 1.0.0 - Initial version
 * Author - davej
 * 
 */
public class ESGCSVReaderTest {

	
	ESGCSVReader reader;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		reader = new ESGCSVReader();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.dave.reader.ESGCSVReader#parseCSV(java.lang.String)}.
	 */
	@Test
	public void testParseCSV() {
		Set<ESGCustomer> customers = null;
		customers = reader.parseCSV("src/test/resources/test.csv");
		
		assertTrue(!customers.isEmpty());
		assertTrue(customers.size() == 1);
		
		
	}

	/**
	 * Test method for {@link com.dave.reader.ESGCSVReader#getNumberOfFields()}.
	 */
	@Test
	public void testGetNumberOfFields() {
		assertTrue(reader.getNumberOfFields() == 8);
	}

	/**
	 * Test method for {@link com.dave.reader.ESGCSVReader#setNumberOfFields(int)}.
	 */
	@Test
	public void testSetNumberOfFields() {
		reader.setNumberOfFields(4);
		assertTrue(reader.getNumberOfFields() == 4);
	}

}
