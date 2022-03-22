package com.jumia.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.app.dto.CustomerDto;
import com.jumia.app.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/v1")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/getAll/")
	public ResponseEntity<List<CustomerDto>> getAll(
			@RequestParam(required = false, defaultValue = "", value = "country") String country,
			@RequestParam(required = false, defaultValue = "", value = "state") String state) {
		try {
			List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();

			if (country.equalsIgnoreCase("")) {
				customerDtoList = customerService.getAll();
				log.info("Get All Customer Data Successfully ...");
			} else {
				customerDtoList = customerService.getAllByCountryAndState(country, state);
			}
			return new ResponseEntity<List<CustomerDto>>(customerDtoList, HttpStatus.OK);

		} catch (Exception e) {
			log.info("Error While Get Customer Data ..." + e);
			return new ResponseEntity<List<CustomerDto>>(HttpStatus.NOT_FOUND);
		}

	}

}
