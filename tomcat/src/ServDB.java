import java.io.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;
// Servlet packages
import javax.servlet.*;
import javax.servlet.http.*;

public class ServDB extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet JDBC</title></head>");
        out.println("<body>");
        out.println("<h1>Servlet JDBC</h1>");
        out.println("</body></html>");
        // connecting to database
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/empdb", "root", "admin");
            stmt = con.createStatement();
            rs = stmt.executeQuery("use empdb; SELECT * FROM students;");
            out.println("The Students are:");
            out.print("<br>");
            // 	displaying records
            while (rs.next()) {
                out.print(rs.getObject(3).toString());
                out.print("\t\t\t\t\t");
                out.print(rs.getObject(1).toString());
                out.print("\t\t\t\t\t");
                out.print(rs.getObject(2).toString());
                out.print("<br>");
            }
        } catch (SQLException e) {
            throw new ServletException("Servlet Could not display records.", e);
        } catch (ClassNotFoundException e) {
            throw new ServletException("JDBC Driver not found.", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException ignored) {
            }
        }
        out.close();
    }
}