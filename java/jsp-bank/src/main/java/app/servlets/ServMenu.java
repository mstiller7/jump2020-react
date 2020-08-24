package app.servlets;

import app.entities.Account;
import app.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/menu")
public class ServMenu extends HttpServlet {
	
	//	Defines what view should be returned for the user when accessing the page.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Account user = Model.getInstance().getUser();
		log(user.getName());
		req.setAttribute("name", user.getName());
		req.setAttribute("balance", user.getBalance());
		
		req.getRequestDispatcher("/views/menu.jsp").forward(req, resp);
		
	}
	
}
