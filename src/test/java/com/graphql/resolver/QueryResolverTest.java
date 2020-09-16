package com.graphql.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.graphql.dao.AddressRepository;
import com.graphql.model.Address;

public class QueryResolverTest {

	@InjectMocks
	QueryResolver queryResolver;

	@Mock
	private AddressRepository addressRepository;

	private Address address1;

	private Address address2;

	private List<Address> addressList;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		address1 = new Address("960 North El Camino", "Suite A", "Park Avenue", "Encinitas", "California",
				"United States", "USA", "92024");
		address2 = new Address("2852 San Marcos", "Sports Arena", "Grand Avenue", "San Marcos", "California",
				"United States", "USA", "92069");
		addressList = new ArrayList<Address>();
		addressList.add(address1);
		System.out.println("Added to the list" + address1);
		addressList.add(address2);
		System.out.println("Added to the list" + address2);
	}

	@Test
	public void getAllAddressTest() throws ParseException {

		when(addressRepository.findAll()).thenReturn(addressList);
		List<Address> response = StreamSupport.stream(queryResolver.findAllAddress().spliterator(), false)
				.collect(Collectors.toList());
		assertEquals(2, response.size());
		verify(addressRepository, times(1)).findAll();

	}

	@Test
	public void getAllAddressByCountryTest() throws ParseException {
		when(addressRepository.findByCountryCode(ArgumentMatchers.anyString())).thenReturn(Optional.of(address1));
		Address response = queryResolver.findAddressByCountry("USA");
		assertNotNull(response);
		verify(addressRepository, times(1)).findByCountryCode(ArgumentMatchers.anyString());

	}

}
