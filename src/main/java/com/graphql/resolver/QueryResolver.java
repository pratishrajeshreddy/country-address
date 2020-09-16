package com.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.dao.AddressRepository;
import com.graphql.exception.AddressNotFoundException;
import com.graphql.model.Address;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
	private AddressRepository addressRepository;

	public Iterable<Address> findAllAddress() {
		return addressRepository.findAll();
	}

	public Address findAddressByCountry(String country) {
		Address address = addressRepository.findByCountryCode(country).orElse(null);
		if (address == null) {
			throw new AddressNotFoundException("We were unable to find the address with given country code",
					"countryCode");
		}
		return address;
	}
}