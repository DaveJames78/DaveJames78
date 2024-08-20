package com.dave.coordinator;

import java.util.Set;

import com.dave.model.ESGCustomer;
import com.dave.reader.CSVReader;
import com.dave.rest.CustomerController;


/**
 * TestyRestyCoordinator
 * 
 * Manages interactions with readers and persistence layers.
 * 
 * Version 1.0.0 - Initial version
 * Author - davidj
 */
public class TestyRestyCoordinator {
	
	private CSVReader<ESGCustomer> csvReader;
	
	private CustomerController controller;

	public void performReadAndPersist(String filename) {
		
		Set<ESGCustomer> customers = csvReader.parseCSV(filename);
		
		// If we've got customers from the input file, process them.
		if (customers != null && !customers.isEmpty()) {
			for(ESGCustomer customer : customers) {
				controller.newCustomer(customer);
			}
		}
		
	}
	
	
	public CSVReader<ESGCustomer> getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader<ESGCustomer> csvReader) {
		this.csvReader = csvReader;
	}





	public CustomerController getController() {
		return controller;
	}





	public void setController(CustomerController controller) {
		this.controller = controller;
	}
	
	
	

	
	
}
