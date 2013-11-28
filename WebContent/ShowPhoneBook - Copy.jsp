<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Telephone book v.2.0</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>
<center>
<h1>Telephone book v.2.0</h1>
	<input type="submit" value="Add new contact" onclick="window.open('web/AddContact.html','_blank','width=350,height=250')" id="submit">
<br><br>

	<%@ page import="java.util.List" %>
	<%@ page import="com.*" %>
	<%@ page import="java.util.Collections" %>
	<%! boolean reverseSortByName = false; %>
	<%! boolean reverseSortByLastName = false; %>
	<%! boolean reverseSortByPhoneNumber = false; %>
	
	<%
	List<Contact> listPhoneBook = ChangeDB.getPhoneBook();
	%>
 
	<c:if test="${param['SortedByFirstName'] != null}" >
		<%
		if(reverseSortByName) {
			Collections.sort(listPhoneBook, new SortedByFirstName());
			reverseSortByName = false;
		} else {
			Collections.sort(listPhoneBook, Collections.reverseOrder(new SortedByFirstName()));
			reverseSortByName = true;
		}
		%>
	</c:if>
	<c:if test="${param['SortedByLastName'] != null}" >
			<% if(reverseSortByLastName){
				Collections.sort(listPhoneBook, new SortedByLastName());
				reverseSortByLastName = false;
			} else {
				Collections.sort(listPhoneBook, Collections.reverseOrder(new SortedByLastName()));
				reverseSortByLastName = true;
			}
			%>
	</c:if>
	<c:if test="${param['SortedByPhoneNumber'] != null}" >
	 <% 
		if(reverseSortByPhoneNumber){
			Collections.sort(listPhoneBook, new SortedByPhoneNumber());
			reverseSortByPhoneNumber = false;
		} else {
			Collections.sort(listPhoneBook, Collections.reverseOrder(new SortedByPhoneNumber()));
			reverseSortByPhoneNumber = true;
		}
	 %>
</c:if>
<% 
	if (listPhoneBook != null) {
	int counter = 1;
%>
<table>
    <tr>
    <form name="sorted" method=POST action="./">
    	<th> </th> 
		<th><input name="SortedByFirstName" type="submit" value="First Name"></th>
		<th><input name="SortedByLastName" type="submit" value="Last Name"></th>
		<th><input name="SortedByPhoneNumber" type="submit" value="Phone number"></th>
        <th><input name="Refresh" type="submit" value="Refresh"></th>
	</form>
	</tr>

    <%
		for(Contact i : listPhoneBook) {
	%>
	<tr>
    <form name="sentToChange" method=POST action="./DoContact">
	<input name="id" type="hidden" value="<%= i.getId()%>">
	<th><%= counter++ %></th> 
	<th><%= i.getFirstName() %></th> 
	<th><%= i.getLastName() %></th> 
	<th><%= i.getPhoneNumber() %></th>
	<th><input name="Change" type="submit" value="Change"></th>
	<th><input name="Delete" type="submit" value="Delete" id="submit"></th>
	</tr>
	</form>
	<%}
%>
	</table>

<%
	} else {
	%>
		<br><br>
		<b> Telephone book is empty!
	<%}
	%>

</body>
</html>