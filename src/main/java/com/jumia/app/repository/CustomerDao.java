package com.jumia.app.repository;

import java.util.List;

import com.jumia.app.dto.CustomerDto;

public interface CustomerDao {

	List<CustomerDto> getAll(String countryStartWith);

}
