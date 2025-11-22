package org.example.sql;

import org.example.classes.Task;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class TasksDAO {
    private String DBURL = "jdbc:mysql://localhost:3306/practice";
    private String username = "root";
    private String password = "Online@123";

    private static final String insertTask = "INSERT INTO tasks (id, name, priority, status, user_Id) VALUES (?,?,?,?,?)";
    private static final String deleteTask = "DELETE FROM tasks WHERE id = ?";
    private static final String readTask = "SELECT * FROM tasks WHERE id = ?";

    public void addTask(Task task) {
        try (Connection conn = DriverManager.getConnection(DBURL, username, password); PreparedStatement pstmt = conn.prepareStatement(insertTask)) {
            pstmt.setInt(1, task.getTaskId());
            pstmt.setString(2, task.getName());
            pstmt.setString(3, task.getPriority());
            pstmt.setString(4, task.getStatus());
//            pstmt.setInt(5, task.getUserId().getId());
            pstmt.setInt(5, 1);

            pstmt.execute();
            System.out.println("Created Task" + task.getName() + "successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't create" + task.getName());

        }
    }

    public void deleteTask(int taskId) {
        try (Connection conn = DriverManager.getConnection(DBURL, username, password); PreparedStatement pstmt = conn.prepareStatement(deleteTask)) {
            pstmt.setInt(1, taskId);

            pstmt.execute();
            System.out.println("Task deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't delete task");
        }
    }

    public Task readTask(int taskId) {
        Task task = new Task();
        try (Connection conn = DriverManager.getConnection(DBURL, username, password); PreparedStatement pstmt = conn.prepareStatement(readTask)) {

            pstmt.setInt(1, taskId);
            ResultSet rs = pstmt.executeQuery();

            task.setTaskId(rs.getInt("id"));
            task.setName(rs.getString("name"));
            task.setPriority(rs.getString("priority"));
            task.setStatus(rs.getString("status"));

            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            return task;
        }
    }
}