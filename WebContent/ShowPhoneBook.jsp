<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Telephone book v.2.0</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
<jsp:useBean id="PhoneBook" class="com.woolfer.telephonebook.ListPhoneBook">
	
</jsp:useBean>
</head>
<body>
	<center>
		<h1>Telephone book v.2.0</h1>
		<input type="submit" value="Add new contact"
			onclick="window.open('web/AddContact.html','_blank','width=350,height=250')"
			id="submit"> <br> <br>

		<c:if test="${param['SortedByFirstName'] != null}">
			<jsp:setProperty name="PhoneBook" property="sortByName" value="true" />
		</c:if>
		<c:if test="${param['SortedByLastName'] != null}">
			<jsp:setProperty name="PhoneBook" property="sortByLastName"
				value="true" />
		</c:if>
		<c:if test="${param['SortedByPhoneNumber'] != null}">
			<jsp:setProperty name="PhoneBook" property="sortByPhoneNumber"
				value="true" />
		</c:if>

		<c:choose>
			<c:when test="${PhoneBook.listOfPhoneBook ne null}">
				<table>
					<tr>
						<form name="sorted" method=POST action="./">
							<th></th>
							<th><input name="SortedByFirstName" type="submit"
								value="First Name"></th>
							<th><input name="SortedByLastName" type="submit"
								value="Last Name"></th>
							<th><input name="SortedByPhoneNumber" type="submit"
								value="Phone number"></th>
							<th></th>
						</form>
					</tr>

					<c:forEach items="${PhoneBook.listOfPhoneBook}" var="contact" varStatus="contactCount">

						<tr>
							<form name="sentToChange" method=POST action="./DoContact">
								<th><input name="id" type="hidden" value="${contact.id}">${contactCount.count}</th>
								<th>${contact.firstName}</th>
								<th>${contact.lastName}</th>
								<th>${contact.phoneNumber}</th>
								<th><input name="Change" type="submit" value="Change"></th>
								<th><input name="Delete" type="submit" value="Delete"
									id="submit"></th>
						</tr>
						</form>
					</c:forEach>
				</table>
			</c:when>
			<c:when test="${PhoneBook.listOfPhoneBook eq null}">
				<br>
				<br>
				<b> Telephone book is empty!</b>
			</c:when>
		</c:choose>
		<br><br>
		<form name="refresh" method="get" action="./">
		<input name="Refresh" type="submit" value="Refresh"/>
		</form>
</body>
</html>