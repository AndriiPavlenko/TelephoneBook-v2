package com.woolfer.telephonebook;
import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.woolfer.telephonebook.db.DBOperation;


public class ContactAddition extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String PhoneNumber = request.getParameter("PhoneNumber");
		
		try {
			DBOperation.addToDB(FirstName, LastName, PhoneNumber);
			out.println("<center><br> Contact: " + FirstName + " " + LastName + ": " + PhoneNumber + "<br> SUCCESSFULLY added!<br>");
			out.println("<input type=\"button\" value=\"Close\" onclick=\"self.close()\">");
		} catch (SQLException e) {
			out.println("ERROR <br>");
			out.println(e);
		}
		
		
	}
}
