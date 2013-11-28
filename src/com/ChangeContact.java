package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeContact extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String actionDelete = request.getParameter("Delete");
		String actionChange = request.getParameter("Change");
		String id = request.getParameter("id");
		response.setHeader("Refresh", "3; URL=.");
		out.println("<center>");

		if (actionDelete != null) {
			try {
				if (ChangeDB.delRow(id)) {
					out.println("Contact was SUCCESSFULLY deleted.");
				} else {
					out.println("Contact is NOT deleted..");
				}
			} catch (SQLException e) {
				out.println("ERROR <br>");
				out.println(e);
			}
		}
		if (actionChange != null) {
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String PhoneNumber = request.getParameter("PhoneNumber");
			if (ChangeDB.changeRow(id, FirstName, LastName, PhoneNumber)) {
				out.println("Contact was SUCCESSFULLY changed.");
			} else {
				out.println("Contact is NOT changed..");
			}
		}
		out.println("<br>You will redirect to root URL after 3 sec.");
	}
}
