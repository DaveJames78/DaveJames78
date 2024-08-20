package com.dave.coordinator;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dave.model.Address;
import com.dave.model.ESGCustomer;
import com.dave.reader.CSVReader;
import com.dave.rest.CustomerController;

@RunWith(MockitoJUnitRunner.class)
public class TestyRestyCoordinatorTest {
	
	@Mock private CSVReader<ESGCustomer> csvReader;
	@Mock private CustomerController controller;
	
	@InjectMocks
	private TestyRestyCoordinator testyRestyCoordinator;
	
	// Testdata setup
	Set<ESGCustomer> customers = new HashSet<>();
	private String customerRef = "ref";
	private String name = "name";
	private String address1 = "address";
	private String address2 = "address";
	private String town = "town";
	private String county = "county";
	private String country = "country";
	private String postCode = "postCode";

	@Before
    public void setup() throws Exception {
		System.out.println("Before");
		testyRestyCoordinator = new TestyRestyCoordinator();
		testyRestyCoordinator.setCsvReader(csvReader);
		testyRestyCoordinator.setController(controller);
		
		addCustomer(4);
		
    }
	
	

	@Test
	public void testPerformReadAndPersist() {
		System.out.println("Testing PerformReadAndPersist");
		testyRestyCoordinator.performReadAndPersist("filename");
		verify(csvReader, atLeastOnce()).parseCSV("filename");
		
	}
	
	@Test
	public void testControllerIsCalled() {
		when(csvReader.parseCSV("filename")).thenReturn(customers);
		testyRestyCoordinator.performReadAndPersist("filename");
		verify(controller, times(4)).newCustomer(any());
		assertTrue(customers.size() == 4);
		
	}
	
	
	@Test
	public void testControllerIsNotCalled() {
//		when(csvReader.parseCSV("filename")).thenReturn(null);
//		verify(controller, atLeastOnce()).newCustomer(any(ESGCustomer.class));
	}
	
	/**
	 * @param numberOfCustomers
	 */
	private void addCustomer(int numberOfCustomers) {
		System.out.println("Adding " + numberOfCustomers + " customers to dataset");
		for(int i = 0; i < numberOfCustomers; i++)
		{
			Address address = new Address(address1 + i, address2 + i , town + i, county + i, country + i, postCode + i);
			ESGCustomer customer = new ESGCustomer(customerRef + i, name + i, address);
			customers.add(customer);
		} 
		
	}
	
	
}
