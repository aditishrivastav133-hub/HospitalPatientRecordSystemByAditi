import java.sql.*;
import java.util.Scanner;

public class Login {

    Scanner sc = new Scanner(System.in);

    public boolean login() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                return true;
            } else {
                System.out.println("Invalid Username or Password!");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}