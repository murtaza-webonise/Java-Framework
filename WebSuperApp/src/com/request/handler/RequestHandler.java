package com.request.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.pojo.Address;
import com.address.pojo.AddressDao;
import com.employee.pojo.Employee;
import com.employee.pojo.EmployeeDao;
import com.session.manager.ReturnSession;
import com.webo.wizard.config.*;

@SuppressWarnings("serial")
public class RequestHandler extends HttpServlet {
	private static String INSERT = "/user.jsp";
	private static String Edit = "/edit.jsp";
	private static String UserRecord = "/employee.jsp";
	private static String singleUser = "/singleUser.jsp";
	private static String show = "/showsingleUser.jsp";
	private EmployeeDao em = new EmployeeDao();
	private AddressDao addm;

	public ReturnSession rs;

	public RequestHandler() {
		super();

		PropertyParser pp = new PropertyParser();

		pp.parser("/home/webonise/workspace/WebSuperApp/src/properties.json");
		rs = new ReturnSession();

		// System.out.println("HI");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String redirect = "";
		String uId = request.getParameter("empId");
		String action = request.getParameter("action");
		System.out.println("");
		System.out.println(action);
		if (action.equalsIgnoreCase("insert")) {
			int eid = Integer.parseInt(uId);
			Employee emp = (Employee) BeanFactory.retrFromMap("employee");
			Address add = (Address) BeanFactory.retrFromMap("address");

			add.setState(request.getParameter("state"));
			add.setCity(request.getParameter("city"));

			add.setPinCode(request.getParameter("pinCode"));

			emp.setId(eid);
			emp.setName(request.getParameter("name"));
			emp.setmobileNumber(Long.parseLong((request.getParameter("mbNo"))));
			emp.setAddress(add);
			em.addEmp(emp);

			response.sendRedirect("listEmp.jsp");
			/*
			 * System.out.println(add.getState() + " " + add.getCity() + " " +
			 * add.getPinCode());
			 * 
			 * System.out.println(emp.getId() + " " + emp.getName() + " " +
			 * emp.getmobileNumber());
			 */

		}
		//System.out.println(action);
		if (action.equalsIgnoreCase("listEmp")) {
			response.sendRedirect("listEmp.jsp");

		}
		if (action.equalsIgnoreCase("edit")) {
			response.sendRedirect("editEmp.jsp");

		}
		if (action.equalsIgnoreCase("editEmp")) {
			Employee emp = (Employee) BeanFactory.retrFromMap("employee");
			Address add = (Address) BeanFactory.retrFromMap("address");
			add.setState(request.getParameter("state"));
			add.setCity(request.getParameter("city"));

			add.setPinCode(request.getParameter("pinCode"));

			emp.setId(Integer.parseInt(request.getParameter("empId")));
			emp.setName(request.getParameter("name"));
			emp.setmobileNumber(Long.parseLong((request.getParameter("mbNo"))));
			emp.setAddress(add);
			em.updateEmp(emp);
			System.out.println("Record updated Successfully");
			response.sendRedirect("listEmp.jsp");

		}
		if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("empId");
			int uid = Integer.parseInt(userId);
			em.removeEmp(uid);

			response.sendRedirect("listEmp.jsp");

		}
		/*
		 * if (action.equalsIgnoreCase("delete")) { em.removeEmp(1); redirect =
		 * UserRecord;
		 * 
		 * System.out.println("Record Added Successfully"); RequestDispatcher rd
		 * = request.getRequestDispatcher(redirect); PrintWriter out =
		 * response.getWriter();
		 * out.println("<font color=red>Data is stored.</font>");
		 * rd.include(request, response);
		 * 
		 * }
		 */

	}

}
