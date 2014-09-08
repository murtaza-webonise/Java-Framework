<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.employee.pojo.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<%
		Employee emp = new Employee();
	%>
	<%
		EmployeeDao dao = new EmployeeDao();
	%>
	<form method="GET" action='RequestHandler' name="frmEditUser">
		<input type="hidden" name="action" value="editEmp" />
		<%
			String uid = request.getParameter("empId");
			if (!((uid) == null)) {
				int id = Integer.parseInt(uid);
				emp = dao.getEmpById(id);
		%>
		<table>
			<tr>
				<td>User ID</td>
				<td><input type="text" name="empId" readonly="readonly"
					value="<%=emp.getId()%>"></td>
			</tr>
			<tr>
				<td> Name</td>
				<td><input type="text" name="name" value="<%=emp.getName()%>" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mbNo" value="<%=emp.getmobileNumber()%>"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" value="<%=emp.getAddress().getState()%>"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="city" value="<%=emp.getAddress().getCity()%>"/></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="text" name="pinCode" value="<%=emp.getAddress().getPinCode()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
		<%
			} else
				out.println("ID Not Found");
		%>
	</form>
</body>
</html>