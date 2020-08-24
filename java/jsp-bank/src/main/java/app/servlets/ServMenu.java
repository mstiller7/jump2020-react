package app.servlets;

import app.entities.Account;
import app.entities.Deposit;
import app.entities.Withdrawal;
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
		//		log(user.getName());
		req.setAttribute("name", user.getName());
		req.setAttribute("balance", user.getBalance());
		req.setAttribute("transactions", user.getTransactions());
		
		req.getRequestDispatcher("/views/menu.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		Model instance = Model.getInstance();
		String button = req.getParameter("button");
		
		switch (button) {
			case "signout" -> {
				instance.setUser(null);
				resp.sendRedirect("/");
			}
			case "transaction" -> {
				String operation = req.getParameter("transaction");
				int amount = Integer.parseInt(req.getParameter("amount"));
				Account user = instance.getUser();
				switch (operation) {
					case "deposit" -> {
						user.recordTransaction(new Deposit(user, amount));
						doGet(req, resp);
					}
					case "withdraw" -> {
						user.recordTransaction(new Withdrawal(user, amount));
						doGet(req, resp);
					}
					default -> log("Unknown operation!");
				}
			}
			default -> log("Unknown button press!");
		}
		
	}
	
}
