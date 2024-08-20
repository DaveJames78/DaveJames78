package com.dave.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * ESG Customer including customer ref
 * 
 * Version 1.0.0 - Initial version
 * Author - davidj
 */
@Entity
public class ESGCustomer extends BaseCustomer {

	@Id
	private String customerRef;

	
	/**
	 * @param customerRef
	 * @param name
	 * @param address
	 */
	public ESGCustomer(String customerRef, String name, Address address) {
		super(name, address);
		this.customerRef = customerRef;
	}

	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(customerRef);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ESGCustomer other = (ESGCustomer) obj;
		return Objects.equals(customerRef, other.customerRef);
	}

	@Override
	public String toString() {
		return "ESGCustomer [getCustomerRef()=" + getCustomerRef() + ", hashCode()=" + hashCode() + ", getName()="
				+ getName() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", toString()="
				 + "]";
	}
	
	
}
