package com.jumia.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.app.dto.CustomerDto;
import com.jumia.app.repository.CustomerDao;
import com.jumia.app.service.CustomerService;
import com.jumia.app.service.RegexService;
import com.jumia.app.util.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private RegexService regexService;

	@Override
	public List<CustomerDto> getAll() {
		return customerDao.getAll("");
	}

	@Override
	public List<CustomerDto> getAllByCountryAndState(String country, String state) {

		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		String regex = regexService.getRegex(country);
		String countryStartWith = regex.substring(1, 5);
		log.info("Country is " + country + " & Regex is " + regex);

		List<CustomerDto> listDataBeforeValidate = customerDao.getAll(countryStartWith);

		for (CustomerDto customerDto : listDataBeforeValidate) {
			if (state.equalsIgnoreCase(CommonConstants.VALID)) {
				if (customerDto.getPhone().matches(regex))
					customerDtoList.add(customerDto);
			} else {
				if (!customerDto.getPhone().matches(regex))
					customerDtoList.add(customerDto);
			}
			log.info("Get All " + state + " Customer Data from " + country + " Country  Successfully...");
		}
		return customerDtoList;

	}

}
