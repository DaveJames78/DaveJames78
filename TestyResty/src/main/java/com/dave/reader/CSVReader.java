package com.dave.reader;

import java.util.Set;

import com.dave.model.BaseCustomer;

/**
 * CSVReader
 * 
 * Interface for a CSVReader that can read a CSV file and parse each record into a customer.
 * 
 * Version 1.0.0 - Initial version
 * Author - davidj
 */
 
public interface CSVReader<T extends BaseCustomer> {
	
	// Read and parse the CSV based on input filename and return a BaseCustomer
	Set<T> parseCSV(String filename);

}
