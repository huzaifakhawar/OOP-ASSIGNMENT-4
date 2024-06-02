package timetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/bahria_university";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Huzaifa123$%"; 

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addTeacher(String name) throws SQLException {
        String query = "INSERT INTO Teachers (name) VALUES (?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void addRoom(int number, int capacity) throws SQLException {
        String query = "INSERT INTO Rooms (number, capacity) VALUES (?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, number);
            stmt.setInt(2, capacity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void addSection(String name) throws SQLException {
        String query = "INSERT INTO Sections (name) VALUES (?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
