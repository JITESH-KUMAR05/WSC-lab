import java.sql.*;
import java.util.Scanner;

public class SqlVul {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("UserName: ");
        String user = sc.nextLine();
        System.out.println("Password: ");
        String pass = sc.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        Statement stmt = con.createStatement();
        // vulnerable query
        String query = 
    }
}