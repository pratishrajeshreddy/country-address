package com.graphql.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 822522339927733419L;

	@Id
	private String countryCode;

	private String addressLine1;
	private String addressLine2;
	private String street;
	private String city;
	private String state;
	private String country;	
	private String zipCode;

	public Address() {

	}

	public Address(String addressLine1, String addressLine2, String street, String city, String state,
			String country, String countryCode, String zipCode) {

		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.countryCode = countryCode;
		this.zipCode = zipCode;
	}

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", street="
				+ street + ", city=" + city + ", state=" + state + ", country=" + country + ", countryCode="
				+ countryCode + ", zipCode=" + zipCode + "]";
	}

}
