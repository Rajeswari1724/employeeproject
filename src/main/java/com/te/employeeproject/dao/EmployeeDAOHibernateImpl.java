package com.te.employeeproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.employeeproject.bean.Employeedb;
import com.te.employeeproject.controlleradvice.EmployeeException;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@PersistenceUnit
	 private EntityManagerFactory factory;

	@Override
	public Employeedb authenticate(int id, String pwd) {
		System.out.println(pwd);
		EntityManager manager = null;

		try {
			// factory= Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();

			Employeedb bean = manager.find(Employeedb.class, id);
			System.out.println(bean);
			if (bean != null) {
				if (bean.getPwd().equalsIgnoreCase(pwd)) {
					System.out.println("Login successfull");
					return bean;
				} else {
					System.out.println("Wrong password");
					return null;
				}
			} else {
				throw new EmployeeException("User Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeException("User Not Found");
		}

	}

	@Override
	public Employeedb getEmployee(int id) {
		// EntityManagerFactory factory=null;
		EntityManager manager = null;

		try {
			// factory= Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();

			Employeedb bean = manager.find(Employeedb.class, id);
			return bean;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean deleteEmpData(int id) {
		// EntityManagerFactory factory=null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			// factory= Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			Employeedb employeedb = manager.find(Employeedb.class, id);
			if (employeedb != null) {
				manager.remove(employeedb);
				transaction.commit();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employeedb> getAllData() {
		// EntityManagerFactory factory=null;
		EntityManager manager = null;

		try {
			// factory= Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();
			String query = "from Employeedb";
			Query query2 = manager.createQuery(query);
			List<Employeedb> employeedbs = query2.getResultList();
			if (employeedbs != null) {
				return employeedbs;
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean addEmp(Employeedb employeedb) {
		// EntityManagerFactory factory=null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		boolean isadded = false;

		try {
			// factory= Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			if (employeedb!=null) {
				manager.persist(employeedb);
				transaction.commit();
				isadded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			isadded = false;
		}
		return isadded;

	}

	@Override
	public boolean updateEmp(Employeedb employeedb) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Employeedb bean = manager.find(Employeedb.class, employeedb.getId());
			if (employeedb.getName() != null && employeedb.getName() != "") {
				bean.setName(employeedb.getName());
			}
			if (employeedb.getBirthdate() != null) {
				bean.setBirthdate(employeedb.getBirthdate());
			}
			if (employeedb.getPwd() != null && employeedb.getPwd() != "") {
				bean.setPwd(employeedb.getPwd());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
