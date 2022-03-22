package com.jumia.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CUSTOMER")
@Data
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = " ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PHONE")
	private String phone;

}
