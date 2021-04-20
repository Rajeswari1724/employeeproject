package com.te.employeeproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employeeproject.bean.Employeedb;
import com.te.employeeproject.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO dao;
	@Override
	public Employeedb authenticate(int id, String pwd) {
		// TODO Auto-generated method stub
		return dao.authenticate(id, pwd);
	}

	@Override
	public Employeedb getEmployee(int id) {
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmpData(int id) {
		
		return dao.deleteEmpData(id);
	}

	@Override
	public List<Employeedb> getAllData() {
		// TODO Auto-generated method stub
		return dao.getAllData();
	}

	@Override
	public boolean addEmp(Employeedb employeedb) {
		// TODO Auto-generated method stub
		return dao.addEmp(employeedb);
	}

	@Override
	public boolean updateEmp(Employeedb employeedb) {
		// TODO Auto-generated method stub
		return dao.updateEmp(employeedb);
	}

}
