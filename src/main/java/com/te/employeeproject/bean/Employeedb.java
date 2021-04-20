package com.te.employeeproject.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employeedb implements Serializable {
	@Id
	private Integer id;
	@Column
	private String name;
	@Column(name = "dob")
	private Date birthdate;
	@Column(name = "password")
	private String pwd;

}
