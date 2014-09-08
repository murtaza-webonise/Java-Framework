<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add New User</title>
    </head>
    <body>
        <form method="GET" action='RequestHandler' name="frmAddUser">
            <input type="hidden" name="action" value="insert" />
            <p>
                <b>Add New Record</b>
            </p>
            <table>
                <tr>
                    <td>Employee ID</td>
                    <td><input type="text" name="empId" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Mobile Number</td>
                    <td><input type="text" name="mbNo" /></td>
                </tr>
                <tr>
                    <td>State</td>
                    <td><input type="text" name="state" /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><input type="text" name="city" /></td>
                </tr>
               
                 <tr>
                    <td>Pincode</td>
                    <td><input type="text" name="pinCode" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
        <p>
            <a href="RequestHandler?action=listEmp">View-All-Records</a>
        </p>
        <p>
            <a href="requestHandler?action=delete">Delete</a>
        </p>
    </body>
</html>