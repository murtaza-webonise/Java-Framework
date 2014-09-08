package com.session.manager;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.employee.pojo.Employee;

public class ReturnSession extends HttpServlet {
	SessionFactory sessionFactory;
	ServiceRegistry serviceRegistry;
	Configuration configuration;
	private Session session = null;
	private Transaction tx;
	static final Long TIME_INTERVAL = 1l;
	HttpServletRequest request;
	HttpServletResponse response;
	private List<Employee> employees;
	Employee employee;

	public ReturnSession() {
		configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}

	public void save(Object obj1) {
		try {

			session = sessionFactory.openSession();

			System.out.println("Inserting Record");
			tx = session.beginTransaction();
			Serializable save = session.save(obj1);
			tx.commit();
			System.out.println("Done" + save);

		} catch (HibernateException e) {
			e.getMessage();

		} finally {
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

		}
	}

	public void delete(int id) {
		try {

			session = sessionFactory.openSession();
			System.out.println("Deleting Record");
			tx = session.beginTransaction();
			Employee add = (Employee) session.get(Employee.class, id);

			session.delete(add);

			tx.commit();

		} catch (HibernateException e) {
			e.getMessage();

		} finally {
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

		}
	}

	

	public Employee getById(int id) {
		try {

			session = sessionFactory.openSession();
			System.out.println("retrieving Record");
			employee = (Employee) session.get(Employee.class, id);

		} catch (HibernateException e) {
			e.getMessage();

		} finally {
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

		}
		return employee;

	}
	
	public void update(Employee emp) {
		try {

			session = sessionFactory.openSession();
			System.out.println("retrieving Record");
			tx = session.beginTransaction();
			employee = (Employee) session.get(Employee.class, emp.getId());
			employee.setName(emp.getName());
			employee.setmobileNumber(emp.getmobileNumber());
			employee.setAddress(emp.getAddress());
			session.update(employee);
			tx.commit();

		} catch (HibernateException e) {
			e.getMessage();

		} finally {
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

		}
		

	}

	public List<Employee> listUser() {
		try {

			session = sessionFactory.openSession();
			System.out.println("Retrieving List");
			tx = session.beginTransaction();
			employees = session.createQuery("FROM Employee").list();

			tx.commit();

		} catch (HibernateException e) {
			e.getMessage();

		} finally {
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

		}
		return employees;
	}

}
