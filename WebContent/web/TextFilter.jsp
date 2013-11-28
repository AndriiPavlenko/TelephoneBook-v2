<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<title>Text box filter</title>
<c:if test="${param['reset'] eq null}">
<c:set var="text" value="${TextAfterFilters}"/>
</c:if>
	<center>
		<form name="text" method="post" action="./TextFilter.jsp">
			<table>
				<tr>
					<td><b>Text box</b><br><textarea name="textBox" rows="20" cols="100">${text}</textarea></td>
					<td>Replacement<br><input name="target" type="text"> <font size="6">=></font> <input name="sub" type="text"> <br><br><input type="submit" value="Change" style="height: 50px; width: 70px;"></td>
				</tr>
				<tr>
					<td></td>
					<td><form name="reset" method="get" action="./TextFilter.jsp"><input name="reset" type="submit" value="reset"></form></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>