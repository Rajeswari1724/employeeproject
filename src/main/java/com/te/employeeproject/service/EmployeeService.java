package com.te.employeeproject.service;

import java.util.List;

import com.te.employeeproject.bean.Employeedb;

public interface EmployeeService {
	public Employeedb authenticate(int id, String pwd);
	public Employeedb getEmployee(int id) ;
	public boolean deleteEmpData( int id);
	public List<Employeedb> getAllData();
	public boolean addEmp(Employeedb employeedb);
	public boolean updateEmp(Employeedb employeedb);

}
