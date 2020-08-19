package app.servlets;

import app.entities.Account;
import app.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class ServSignup extends HttpServlet {
	
	//	Defines what view should be returned for the user when accessing the page.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/signup.jsp").forward(req, resp);
	}
	
	//	Defines what should occur when a POST request is made.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Model.getInstance().add(new Account(req.getParameter("name"), req.getParameter("pw")));
		req.getRequestDispatcher("views/menu.jsp").forward(req, resp);
	}
	
}
