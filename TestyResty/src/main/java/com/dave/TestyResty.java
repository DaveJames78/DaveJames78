package com.dave;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.dave.coordinator.TestyRestyCoordinator;
import com.dave.model.ESGCustomer;
import com.dave.model.db.ESGCustomerRepository;
import com.dave.reader.CSVReader;
import com.dave.reader.ESGCSVReader;
import com.dave.rest.CustomerController;

import jakarta.annotation.Resource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TestyResty {

	public static void main(String[] args) {
		SpringApplication.run(TestyResty.class, args);
	}

	@Autowired
	CustomerController controller;
	
	@Bean
	public TestyRestyCoordinator testyRestyCoordinator() {
		TestyRestyCoordinator testyRestyCoordinator = new TestyRestyCoordinator();
		testyRestyCoordinator.setCsvReader(esgcsvReader());
		testyRestyCoordinator.setController(controller);
		return testyRestyCoordinator;
	}
	
	@Bean
	public CSVReader<ESGCustomer> esgcsvReader() {
		ESGCSVReader esgcsvReader = new ESGCSVReader();
		
		return esgcsvReader;
	}
	
	@Resource
	public ESGCustomerRepository esgCustomerRepository;
}
