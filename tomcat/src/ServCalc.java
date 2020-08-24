import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServCalc")
public class ServCalc extends HttpServlet {
  protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>Calculator Servlet</title></head>");
    out.println("<body>");
    out.println("</body></html>");

    int first = Integer.parseInt(request.getParameter("first"));
    int second = Integer.parseInt(request.getParameter("second"));
    String operator = request.getParameter("operator");

    out.println("The operation completed: ");

    switch (operator) {
      case "+":
        out.println(first + second);
        break;
      case "-":
        out.println(first - second);
        break;
      case "*":
        out.println(first * second);
        break;
      case "/":
        out.println(first / second);
        break;
      default:
        out.println("Something went wrong.");
        break;
    }

    out.close();

  }
}
