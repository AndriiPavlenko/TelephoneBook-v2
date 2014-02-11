package com.woolfer.telephonebook.contact;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactModification extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String actionCh = request.getParameter("Change");
		String actionDel = request.getParameter("Delete");
		
		if(actionCh != null) {
			RequestDispatcher view = request.getRequestDispatcher("ChangeRec.jsp");
			view.forward(request, response);
		} else if (actionDel != null) {
			RequestDispatcher view = request.getRequestDispatcher("isDelete.jsp");
			view.forward(request, response);
		}
		
	}
}
