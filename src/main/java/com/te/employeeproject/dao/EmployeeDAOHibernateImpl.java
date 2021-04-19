package com.te.employeeproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.employeeproject.bean.Employeedb;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	

	@Override
	public Employeedb authenticate(int id, String pwd) {
		System.out.println(pwd);
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		
		try {
			factory= Persistence.createEntityManagerFactory("springdb");
			manager= factory.createEntityManager();
			
			Employeedb bean= manager.find(Employeedb.class, id);
			System.out.println(bean);
			if(bean!=null) {
				if(bean.getPwd().equalsIgnoreCase(pwd)) {
					System.out.println("Login successfull");
					return bean;
				}else {
					System.out.println("Wrong password");
					return null;
				}
			}else {
				System.out.println("User doesnot exist");
				return null;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public Employeedb getEmployee(int id) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		
		try {
			factory= Persistence.createEntityManagerFactory("springdb");
			manager= factory.createEntityManager();
			
			Employeedb bean= manager.find(Employeedb.class, id);
			return bean;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean deleteEmpData(int id) {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		EntityTransaction  transaction= null;
		
		try {
			factory= Persistence.createEntityManagerFactory("springdb");
			manager= factory.createEntityManager();
			transaction= manager.getTransaction();
			transaction.begin();
			
			Employeedb employeedb= manager.find(Employeedb.class, id);
			if(employeedb!=null) {
				manager.remove(employeedb);
				transaction.commit();
				return true;
			}else {
				return false;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Employeedb> getAllData() {
		EntityManagerFactory factory=null;
		EntityManager manager=null;
		
		try {
			factory= Persistence.createEntityManagerFactory("springdb");
			manager= factory.createEntityManager();
			String query="from Employeedb";
			Query query2= manager.createQuery(query);
			List<Employeedb>employeedbs=query2.getResultList();
			if(employeedbs!=null) {
				return employeedbs;
			}else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
}
