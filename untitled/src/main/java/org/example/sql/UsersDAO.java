package org.example.sql;

import org.example.classes.Task;
import org.example.classes.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UsersDAO {
    private String DBURL = "jdbc:mysql://localhost:3306/practice";
    private String username = "root";
    private String password = "Online@123";

    private static final String insertUser = "INSERT INTO users (user_id, name, email) VALUES (?,?,?)";
    private static final String deleteUser = "DELETE FROM users WHERE user_id = ?";
    private static final String readUser = "SELECT * FROM users WHERE user_id = ?";

    public void addUser(User user) {
        try (Connection conn = DriverManager.getConnection(DBURL, username, password); PreparedStatement pstmt = conn.prepareStatement(insertUser)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());

            pstmt.execute();
            System.out.println("Created user" + user.getName() + "successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't create" + user.getName());
        }
    }

    public void deleteUser(int userId) {
        try (Connection conn = DriverManager.getConnection(DBURL, username, password); PreparedStatement pstmt = conn.prepareStatement(deleteUser)) {
            pstmt.setInt(1, userId);

            pstmt.execute();
            System.out.println("Task deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't delete task");
        }
    }

    public User readUser(int userId) {
        User user = new User();
        try (Connection conn = DriverManager.getConnection(DBURL, username, password); PreparedStatement pstmt = conn.prepareStatement(readUser)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return user;
        }
    }
}
