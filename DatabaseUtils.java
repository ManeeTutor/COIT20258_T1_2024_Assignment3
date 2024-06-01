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

    private static int currentUserId; // Add this line to store current user ID

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

    public static void setCurrentUserId(int userId) {
        currentUserId = userId; // Method to set current user ID
    }

    public static int getCurrentUserId() {
        return currentUserId; // Method to get current user ID
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
                    + "location VARCHAR(50),"
                    + "userType VARCHAR(50)"
                    + ")";

            stmt.execute(createTableSQL);
            System.out.println(tableName + " table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void adminRegister(AdminStaff adminStaff) {
        String sql = "INSERT INTO adminStaff (userName, password, fullName, address, phone, email, positionType, location, userType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, adminStaff.getUserName());
            pstmt.setString(2, adminStaff.getPassword());
            pstmt.setString(3, adminStaff.getFullName());
            pstmt.setString(4, adminStaff.getAddress());
            pstmt.setString(5, adminStaff.getPhone());
            pstmt.setString(6, adminStaff.getEmail());
            pstmt.setString(7, adminStaff.getPositionType()); // Use display name for position type
            pstmt.setString(8, adminStaff.getLocation());
            pstmt.setString(9, adminStaff.getUserType());

            pstmt.executeUpdate();
            System.out.println("Admin staff registered successfully.");

        } catch (SQLException e) {
            System.err.println("Error registering admin staff: " + e.getMessage());
        }
    }

    public static void createManageStaffTable() {
        String tableName = "manageStaff";
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
                    + "managementLevel VARCHAR(50),"
                    + "location VARCHAR(50),"
                    + "userType VARCHAR(50)"
                    + ")";

            stmt.execute(createTableSQL);
            System.out.println(tableName + " table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void manageRegister(ManageStaff manageStaff) {
        String sql = "INSERT INTO manageStaff (userName, password, fullName, address, phone, email, managementLevel, location, userType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, manageStaff.getUserName());
            pstmt.setString(2, manageStaff.getPassword());
            pstmt.setString(3, manageStaff.getFullName());
            pstmt.setString(4, manageStaff.getAddress());
            pstmt.setString(5, manageStaff.getPhone());
            pstmt.setString(6, manageStaff.getEmail());
            pstmt.setString(7, manageStaff.getManagementLevel());
            pstmt.setString(8, manageStaff.getLocation());
            pstmt.setString(9, manageStaff.getUserType());

            pstmt.executeUpdate();
            System.out.println("Management staff registered successfully.");

        } catch (SQLException e) {
            System.err.println("Error registering management staff: " + e.getMessage());
        }
    }

    public static void createRecruitTable() {
        String tableName = "recruits";
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
                    + "qualification VARCHAR(50),"
                    + "location VARCHAR(50),"
                    + "userType VARCHAR(50)"
                    + ")";

            stmt.execute(createTableSQL);
            System.out.println(tableName + " table created successfully.");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void recruitRegister(Recruit recruit) {
        String sql = "INSERT INTO recruits (userName, password, fullName, address, phone, email, qualification, location, userType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, recruit.getUserName());
            pstmt.setString(2, recruit.getPassword());
            pstmt.setString(3, recruit.getFullName());
            pstmt.setString(4, recruit.getAddress());
            pstmt.setString(5, recruit.getPhone());
            pstmt.setString(6, recruit.getEmail());
            pstmt.setString(7, recruit.getQualification());
            pstmt.setString(8, recruit.getLocation());
            pstmt.setString(9, recruit.getUserType());

            pstmt.executeUpdate();
            System.out.println("Recruit registered successfully.");

        } catch (SQLException e) {
            System.err.println("Error registering recruit: " + e.getMessage());
        }
    }

    public static User getCurrentUser(String username, String userType) {
        String tableName = null;
        switch (userType) {
            case Constants.UserType.ADMINSTAFF:
                tableName = "adminStaff";
                break;
            case Constants.UserType.MANAGEMENTSTAFF:
                tableName = "manageStaff";
                break;
            case Constants.UserType.RECRUIT:
                tableName = "recruits";
                break;
            default:
                System.out.println("Invalid user type: " + userType);
                return null;
        }

        String sql = "SELECT * FROM " + tableName + " WHERE userName = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    switch (userType) {
                        case Constants.UserType.ADMINSTAFF:
                            return new AdminStaff(rs.getString("positionType"), userType, rs.getString("userName"), rs.getString("password"), rs.getString("fullName"), rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("location"));
                        case Constants.UserType.MANAGEMENTSTAFF:
                            return new ManageStaff(rs.getString("managementLevel"), userType, rs.getString("userName"), rs.getString("password"), rs.getString("fullName"), rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("location"));
                        case Constants.UserType.RECRUIT:
                            return new Recruit(rs.getString("qualification"), userType, rs.getString("userName"), rs.getString("password"), rs.getString("fullName"), rs.getString("address"), rs.getString("phone"), rs.getString("email"), rs.getString("location"));
                        default:
                            return null;
                    }
                } else {
                    System.out.println("User not found with username: " + username);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user: " + e.getMessage());
            return null;
        }
    }

    public static void updateUser(User user) {
        String sql = "";
        if (user instanceof AdminStaff) {
            sql = "UPDATE adminStaff SET password = ?, fullName = ?, address = ?, phone = ?, email = ?, location = ?, positionType = ? WHERE userName = ?";
        } else if (user instanceof ManageStaff) {
            sql = "UPDATE manageStaff SET password = ?, fullName = ?, address = ?, phone = ?, email = ?, location = ?, managementLevel = ? WHERE userName = ?";
        } else if (user instanceof Recruit) {
            sql = "UPDATE recruits SET password = ?, fullName = ?, address = ?, phone = ?, email = ?, location = ?, qualification = ? WHERE userName = ?";
        }

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getFullName());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getLocation());

            if (user instanceof AdminStaff) {
                pstmt.setString(7, ((AdminStaff) user).getPositionType());
            } else if (user instanceof ManageStaff) {
                pstmt.setString(7, ((ManageStaff) user).getManagementLevel());
            } else if (user instanceof Recruit) {
                pstmt.setString(7, ((Recruit) user).getQualification());
            }

            pstmt.setString(8, user.getUserName());

            pstmt.executeUpdate();
            
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("User information updated successfully.");
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
