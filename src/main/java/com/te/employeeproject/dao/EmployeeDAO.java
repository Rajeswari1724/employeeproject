package com.te.employeeproject.dao;

import java.util.List;

import com.te.employeeproject.bean.Employeedb;



public interface EmployeeDAO {
	public Employeedb authenticate(int id, String pwd);
	public Employeedb getEmployee(int id) ;
	public boolean deleteEmpData( int id);
	public List<Employeedb> getAllData();
	
}
