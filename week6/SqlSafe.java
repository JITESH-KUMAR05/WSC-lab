import java.sql.*;
import java.util.*;

public class SqlSafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username");
        String user = sc.nextLine();
        System.out.println("Password");
        String pass = sc.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            // safe query using PreparedStatement
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}