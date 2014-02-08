<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>
<center>
<form name="FormDelete" method="POST" action="./DeleteContact">
<b> Are you sure to delete this contact ? </b>
<br><br>

<%@ page import="com.woolfer.telephonebook.contact.*"%>
<%@ page import="com.woolfer.telephonebook.db.*"%>
<%
	String id = request.getParameter("id");
	Contact contactID = DBOperation.getRow(id);
	if (contactID != null) {
%>
	<input name="id" type="hidden" value="<%= contactID.getId()%>">
    <%= contactID.getFirstName() %><br>
	<%= contactID.getLastName() %><br>
	<%= contactID.getPhoneNumber() %><br>
<table>
    <th><input name="Delete" type="submit" value="YES" id="submit"></th>
</form>
<th><form action="."><input type="submit" value="Cansel"></form></th>
</table>
<%		
	} else {
%> <b>Contact is Not available!</b>
    <form action="."><input type="submit" value="Back"></form>
<%		
	}
%>
</body>
</html>