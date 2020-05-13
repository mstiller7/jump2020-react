/*
 * Matthew Stiller © 2020
 * - mstiller@ggc.edu
 */

package quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Hello extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text / html");
		
		PrintWriter out = response.getWriter();
		
		out.println(" < html > ");
		out.println(" < body > ");
		
		out.println(" < h1 > < b > Servlet123 </b ></h1 > ");
		
		out.println(" < / body > ");
		
		out.println(" < / html > ");
		
		out.close();
		
	}
	
}