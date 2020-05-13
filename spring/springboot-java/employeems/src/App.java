import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class App {

    static Properties properties;
    static Connection db;
    static Scanner stdin;

    static {

        try {

            properties = new Properties();
            properties.load(new FileInputStream("config.properties"));

            db = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));

            stdin = new Scanner(System.in);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Employee e;

        System.out.println("[COLLABERA EMPLOYEE MANAGEMENT SYSTEM]");

        do {

            System.out.println("Choose:");
            System.out.println("1. CREATE");
            System.out.println("2. UPDATE");
            System.out.println("3. DELETE");
            System.out.println("4. SEARCH");
            System.out.println("5. EXIT");

            switch (Integer.parseInt(stdin.nextLine())) {

                case 1:
                    createEmployee();
                    break;

                case 2:
                    System.out.println("Enter the employee's ID to be updated:");
                    e = searchEmployee(Integer.parseInt(stdin.nextLine()));
                    if (e != null) {
                        System.out.println("Employee found: " + e.toString());
                        System.out.println("Proceeding to update.");
                        updateEmployee(e);
                    } else {
                        System.out.println("Employee does not exist.");
                    }

                    break;

                case 3:
                    System.out.println("DELETING - Enter the employee's ID:");
                    e = searchEmployee(Integer.parseInt(stdin.nextLine()));
                    if (e != null) {
                        System.out.println("Employee found: " + e.toString());
                        System.out.println("Deleting...");
                        deleteEmployee(e);
                    } else {
                        System.out.println("Employee does not exist.");
                    }
                    break;

                case 4:
                    System.out.println("Enter the employee ID to search for:");
                    e = searchEmployee(Integer.parseInt(stdin.nextLine()));
                    if (e != null) {
                        System.out.println("Employee found: " + e.toString());
                    } else {
                        System.out.println("Employee does not exist.");
                    }
                    break;

                case 5:
                    System.out.println("Thanks for using EMS!");
                    stdin.close();
                    return;

                default:
                    break;

            }

        } while (true);

    }

    static boolean createEmployee() {

        Employee e = new Employee();

        System.out.println("Employee ID:");
        e.setId(Integer.parseInt(stdin.nextLine()));

        return updateEmployee(e);

    }

    static boolean insertEmployee(Employee e) {

        try {

            PreparedStatement ps = App.db.prepareStatement(properties.getProperty("emp_insert"));

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setInt(3, e.getAge());
            ps.setString(4, e.getEmail());

            ps.execute();

            System.out.println("Inserted '" + e.getName() + "' successfully.\n");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    static boolean updateEmployee(Employee e) {

        System.out.println("Employee Name:" + e.getName());
        e.setName(stdin.nextLine());

        System.out.println("Employee Age:");
        e.setAge(Integer.parseInt(stdin.nextLine()));

        System.out.println("Employee Email:");
        e.setEmail(stdin.nextLine());

        try {

            PreparedStatement ps = App.db.prepareStatement(properties.getProperty("emp_update"));
            ps.setInt(4, e.getId());
            ps.setString(1, e.getName());
            ps.setInt(2, e.getAge());
            ps.setString(3, e.getEmail());

            ps.execute();

            System.out.println("Updated '" + e.getName() + "' successfully.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    static Employee searchEmployee(int id) {

        try {

            PreparedStatement ps = App.db.prepareStatement(properties.getProperty("emp_search"));
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // set the cursor to the first row entry
            rs.first();

            Employee e = new Employee();
            e.setId(rs.getInt("emp_id"));
            e.setName(rs.getString("emp_name"));
            e.setAge(rs.getInt("emp_age"));
            e.setEmail(rs.getString("emp_email_id"));

            return e;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    static boolean deleteEmployee(Employee e) {

        try {

            PreparedStatement ps = App.db.prepareStatement("delete from empdb.employee where ? = ?");
            ps.setInt(1, e.getId());

            ps.execute();

            System.out.println("Deleted '" + e.getName() + "' successfully.\n");
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

}