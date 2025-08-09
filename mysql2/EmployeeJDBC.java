import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "Raja@123";

        String insertQuery = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        Object[][] employees = {
                {101, "Jenny", 25, 10000},
                {102, "Jacky", 30, 20000},
                {103, "Joe", 20, 40000},
                {104, "John", 40, 80000},
                {105, "Shameer", 25, 90000}
        };

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            for (Object[] emp : employees) {
                pstmt.setInt(1, (int) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setInt(3, (int) emp[2]);
                pstmt.setInt(4, (int) emp[3]);
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
    }
}
