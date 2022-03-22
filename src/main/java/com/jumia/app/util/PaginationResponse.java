package com.jumia.app.util;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@Data
@ToString
public class PaginationResponse<T> {

	private T entitiesResponse;

	private long totalRecords;

	private long totalPages;

	private long currentPage;

	private long recordsPerPage;

	public void createResponse(Page<?> page) {
		this.setTotalRecords(page.getTotalElements());
		this.setTotalPages(page.getTotalPages());
		this.setRecordsPerPage(page.getSize());
	}


}