package com.employee.pojo;

import java.util.List;

import javax.servlet.http.HttpServlet;

import com.session.manager.ReturnSession;

@SuppressWarnings("serial")
public class EmployeeDao extends HttpServlet {
	List<Employee> employees;
	ReturnSession rs = new ReturnSession();

	public void addEmp(Employee emp) {

		rs.save(emp);

	}

	public void updateEmp(Employee emp) {
		System.out.println("retrieving Record");

		rs.update(emp);

	}

	public void removeEmp(int id) {
		System.out.println("deleting Record");

		rs.delete(id);

	}

	public Employee getEmpById(int id) {

		return rs.getById(id);

	}

	public List<Employee> listEmp() {

		employees = rs.listUser();

		return employees;

	}

}
