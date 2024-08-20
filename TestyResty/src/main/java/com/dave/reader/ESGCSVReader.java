package com.dave.reader;

import java.util.HashSet;
import java.util.Set;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.dave.model.Address;
import com.dave.model.ESGCustomer;


/**
 * ESGCSVReader
 * 
 * Specific ESG Customer implementation of CSVReader.
 * Suggests trusted input of: 
 * Customer Ref
 * Customer Name
 * Address Line 1
 * Address Line 2
 * Town
 * County
 * Country
 * Postcode
 * 
 * Version 1.0.0 - Initial version
 * Author - Dave James
 */
public class ESGCSVReader implements CSVReader<ESGCustomer> {

	// Initialise number of fields to check, overridable in properties
	private int numberOfFields = 8;


	@Override
	public Set<ESGCustomer> parseCSV(String filename) {
		
		Set<ESGCustomer> customers = getCSVRecords(filename);
		
		return customers;
	}
	
	
	private Set<ESGCustomer> getCSVRecords(String filename) {
		
		Set<ESGCustomer> esgCustomers = new HashSet<>();
		
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(filename));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
	        ) {
	            for (CSVRecord csvRecord : csvParser) {
	            	
	            	ESGCustomer customer = getCustomerFromCSVRecord(csvRecord);
	            	 if (customer != null) {
	            		 esgCustomers.add(customer);
	            	 } else {
	            		 // Log error with record.
	            		 // Would use Log4J or similar in the real world.
	            		 System.out.println("Error with customer record: " + csvRecord);
	            	 }
	            }
		
				} catch (IOException e) {
					e.printStackTrace();
				}
		return esgCustomers;
	}


	/**
	 * @param csvRecord
	 * @return ESGCustomer
	 */
	private ESGCustomer getCustomerFromCSVRecord(CSVRecord csvRecord) {
		
		ESGCustomer customer = null;
		
		// Check we've got the right amount of data, then build a customer record
		// If  not, return null customer
		if (csvRecord != null && csvRecord.size() == numberOfFields) {
			String ref = csvRecord.get(0);
			String name = csvRecord.get(1);
			
			Address address = new Address(csvRecord.get(2), csvRecord.get(3), csvRecord.get(4), 
					csvRecord.get(5), csvRecord.get(6), csvRecord.get(7));
			
			customer = new ESGCustomer(ref, name, address);
		}
		
		
		return customer;
	}


	public int getNumberOfFields() {
		return numberOfFields;
	}


	public void setNumberOfFields(int numberOfFields) {
		this.numberOfFields = numberOfFields;
	}
	
}
