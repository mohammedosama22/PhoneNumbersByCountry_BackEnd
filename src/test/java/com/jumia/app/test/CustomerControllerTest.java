package com.jumia.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumia.app.controller.CustomerController;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerController customerController;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void whenRetrievingCustomer_thenInfoReturnedSuccessfully() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.fromUriString("/v1/getAll/").buildAndExpand();

		mockMvc.perform(get(uriComponents.toUriString()).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(result -> {

			Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		});

	}

	@Test
	void whenRetrievingCustomerByCountryAndState_thenInfoReturnedSuccessfully() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.fromUriString("/v1/getAll/?countrys=Morocco&state=valid")
				.buildAndExpand();

		mockMvc.perform(get(uriComponents.toUriString()).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(result -> {

			Assertions.assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

		});

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}