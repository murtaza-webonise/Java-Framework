<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.employee.pojo.*"%>
<%@ page import="com.address.pojo.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User</title>
</head>
<body>
	<%
		//UserBean user = new UserBean();
		EmployeeDao dao = new EmployeeDao();
		List<Employee> empList = dao.listEmp();
		//Iterator<UserBean> itr = userList.iterator();
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th> Name</th>
			<th>Mobile Number</th>
			<th>State</th>
			<th>City</th>
			<th>Pincode</th>
			<th>Operation1</th>
			<th>Operation2</th>
		</tr>
		<tr>
			<%
				/*while(itr.hasNext())
				 {
				 System.out.println(user.getId());*/
				for (Employee emp : empList) {
			%>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getmobileNumber()%></td>
			<td><%=emp.getAddress().getState()%></td>
			<td><%=emp.getAddress().getCity()%></td>
			<td><%=emp.getAddress().getPinCode()%></td>
			
			<td><a
				href="edit.jsp?action=edit&empId=<%=emp.getId()%>">Update</a></td>
			<td><a href="RequestHandler?action=delete&empId=<%=emp.getId()%>">Delete</a></td>

		</tr>
		<%
			}
			//}
		%>
	</table>
	<p>
		<a href="Employee.jsp">Add User</a>
	</p>
</body>
</html>