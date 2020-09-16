package com.graphql.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.graphql.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

	Optional<Address> findByCountryCode(String countryCode);
}
