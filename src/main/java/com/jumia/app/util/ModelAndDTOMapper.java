package com.jumia.app.util;

import com.jumia.app.dto.CustomerDto;
import com.jumia.app.entity.CustomerEntity;

public class ModelAndDTOMapper {

	public static CustomerDto toDto(CustomerEntity entity) {
		CustomerDto dto = new CustomerDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		return dto;
	}

}
