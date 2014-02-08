<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form name="Form1" method="POST"
			action="./ChangeContact">
			
			<%@ page import="com.woolfer.telephonebook.contact.*"%>
			<%@ page import="com.woolfer.telephonebook.db.*"%>
			<%
				String id = request.getParameter("id");
					Contact contactID = DBOperation.getRow(id);
					if (contactID != null) {
			%>
			<input name="id" type="hidden" value="<%= contactID.getId()%>">
			<table>
				<tr>
					<th><B>First name</B></th>
					<th><input name="FirstName" type="text"
						value="<%=contactID.getFirstName()%>" pattern="[A-Za-z]{3,}" required> </inmput></th>
				</tr>
				<tr>
					<th><B>Last name</B></th>
					<th><input name="LastName" type="text"
						value="<%=contactID.getLastName()%>"> </inmput></th>
				</tr>
				<tr>
					<th><B>Phone number</B></th>
					<th><input name="PhoneNumber" type="number" maxlength="10"
						value="<%=contactID.getPhoneNumber()%>" required> </inmput></th>
				</tr>
			</table>
			<table>
				<th><input name="Change" type="submit" value="Change"></th>
				</form>
				<th><form action="."><input type="submit" value="Cansel"></form></th>
			</table>
			<%
				} else {
			%>
			<b>Contact is Not available!</b>
			<%
				}
			%>
</body>
</html>