package com.dave.model.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dave.model.ESGCustomer;

/**
 * ESGCustomerRepository.java
 * 
 * Uses inbuilt JPARepository to allow easy connection to DB layer.
 *
 * 19 Aug 2024
 * Version 1.0.0 - Initial version
 * Author - Dave James
 * 
 */
public interface ESGCustomerRepository extends JpaRepository<ESGCustomer, String> {

}
