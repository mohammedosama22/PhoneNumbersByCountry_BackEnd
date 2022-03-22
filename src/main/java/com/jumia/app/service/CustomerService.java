package com.jumia.app.service;

import java.util.List;

import com.jumia.app.dto.CustomerDto;

public interface CustomerService {

	public List<CustomerDto> getAll();

	public List<CustomerDto> getAllByCountryAndState(String country, String state);

}
