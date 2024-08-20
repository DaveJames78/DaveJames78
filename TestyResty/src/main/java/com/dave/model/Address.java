package com.dave.model;

import java.util.Objects;

/**
 * Standard Address
 * 
 * Version 1.0.0 - Initial version
 * Author - Dave James
 */
public class Address {
	
	/**
	 * @param addressLine1
	 * @param addressLine2
	 * @param town
	 * @param county
	 * @param country
	 * @param postCode
	 */
	public Address(String addressLine1, String addressLine2, String town, String county, String country,
			String postCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.county = county;
		this.country = country;
		this.postCode = postCode;
	}
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String county;
	private String country;
	private String postCode;
	
	
	
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(addressLine1, addressLine2, country, county, postCode, town);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressLine1, other.addressLine1) && Objects.equals(addressLine2, other.addressLine2)
				&& Objects.equals(country, other.country) && Objects.equals(county, other.county)
				&& Objects.equals(postCode, other.postCode) && Objects.equals(town, other.town);
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", town=" + town
				+ ", county=" + county + ", country=" + country + ", postCode=" + postCode + "]";
	}

}
