/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 61475
 */
public class DatabaseUtils {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "M78gxd0406028";
    private static final String DATABASE_NAME = "AISRDB";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME, USERNAME, PASSWORD);
    }

    private static Connection getInitialConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkAndCreateDatabase() {
        String checkDbExistsQuery = "SHOW DATABASES LIKE '" + DATABASE_NAME + "'";
        String createDatabaseQuery = "CREATE DATABASE " + DATABASE_NAME;

        try (Connection conn = getInitialConnection(); // Connect to the mysql database
                 Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(checkDbExistsQuery)) {

            if (!rs.next()) { // If the database does not exist
                stmt.executeUpdate(createDatabaseQuery);
                System.out.println("Database created successfully.");
            } else {
                System.out.println("Database already exists.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createAdminStaffTable() {
        String tableName = "adminStaff";
        String checkTableExistsSQL = "SHOW TABLES LIKE '" + tableName + "'";

        try (Connection conn = getConnection(); // connect to the new database
                 Statement stmt = conn.createStatement()) {

            // Check if the table exists
            try (ResultSet rs = stmt.executeQuery(checkTableExistsSQL)) {
                if (rs.next()) {
                    System.out.println(tableName + " table already exists.");
                    return; // Table already exists
                }
            }

            // The table does not exist, create it
            String createTableSQL = "CREATE TABLE `" + tableName + "` ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "userName VARCHAR(50) NOT NULL, "
                    + "password VARCHAR(50) NOT NULL, "
                    + "fullName VARCHAR(100) NOT NULL, "
                    + "address VARCHAR(200), "
                    + "phone VARCHAR(20), "
                    + "email VARCHAR(50), "
                    + "positionType VARCHAR(50), "
                    + "location VARCHAR(50)"
                    + ")";

            stmt.execute(createTableSQL);
            System.out.println(tableName + " table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void adminRegister(AdminStaff adminStaff) {
        String sql = "INSERT INTO adminStaff (userName, password, fullName, address, phone, email, positionType, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, adminStaff.getUserName());
            pstmt.setString(2, adminStaff.getPassword());
            pstmt.setString(3, adminStaff.getFullName());
            pstmt.setString(4, adminStaff.getAddress());
            pstmt.setString(5, adminStaff.getPhone());
            pstmt.setString(6, adminStaff.getEmail());
            pstmt.setString(7, adminStaff.getPositionType()); // Use display name for position type
            pstmt.setString(8, adminStaff.getLocation());

            pstmt.executeUpdate();
            System.out.println("Admin staff registered successfully.");

        } catch (SQLException e) {
            System.err.println("Error registering admin staff: " + e.getMessage());
        }
    }
}
