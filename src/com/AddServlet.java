package com;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;


public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String PhoneNumber = request.getParameter("PhoneNumber");
		
		try {
			ChangeDB.addToDB(FirstName, LastName, PhoneNumber);
			out.println("<center><br> Contact: " + FirstName + " " + LastName + ": " + PhoneNumber + "<br> SUCCESSFULLY added!<br>");
			out.println("<input type=\"button\" value=\"Close\" onclick=\"self.close()\">");
		} catch (SQLException e) {
			out.println("ERROR <br>");
			out.println(e);
		}
		
		
	}
}
