package com.jumia.app.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jumia.app.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired(required = false)
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerDto> getAll(String countryStartWith) {
		String query = "";

		if (countryStartWith.equalsIgnoreCase(""))
			query = "SELECT * FROM CUSTOMER f ";
		else
			query = "SELECT * FROM CUSTOMER f  WHERE  f.PHONE LIKE '%" + countryStartWith + "%' ";

		List<CustomerDto> customerDtoList = jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {
			CustomerDto dto = new CustomerDto();
			dto.setId(rs.getInt("ID"));
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
			return dto;
		});
		return customerDtoList;
	}
}
