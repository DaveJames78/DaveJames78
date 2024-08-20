package com.dave.model;

import java.util.Objects;

/**
 * Standard Base Customer
 * 
 * Version 1.0.0 - Initial version
 * Author - davej
 */
public abstract class BaseCustomer {
	
	private String name;
	
	/**
	 * @param name
	 * @param address
	 */
	public BaseCustomer(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	private Address address;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseCustomer other = (BaseCustomer) obj;
		return Objects.equals(address, other.address) && Objects.equals(name, other.name);
	}
	


}
