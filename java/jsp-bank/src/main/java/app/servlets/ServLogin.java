package app.servlets;

import app.entities.Account;
import app.entities.Deposit;
import app.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class ServLogin extends HttpServlet {
	
	//	Defines what view should be returned for the user when accessing the page.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/login.jsp").forward(req, resp);
	}
	
	//	Defines what should occur when a POST request is made.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Model instance = Model.getInstance();
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		for (Account account : instance.getAccounts()) {
			if (account.getName().equals(name) && account.getPassword().equals(pw)) {
				instance.setUser(account);
//				req.getRequestDispatcher("views/menu.jsp").forward(req, resp);
				resp.sendRedirect("/menu");
			}
		}
		//	TODO display error on invalid account attempt.
		
	}
	
}
