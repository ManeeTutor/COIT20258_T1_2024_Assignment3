/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

/**
 *
 * @author 61475
 */
public class ManageStaff extends Staff {

    private int manageStaffId;
    private String managementLevel;

    public ManageStaff(String managementLevel, String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        super(userType, userName, password, fullName, address, phone, email, location);
        this.managementLevel = managementLevel;
    }

    @Override
    public void register() {
        DatabaseUtils.manageRegister(this);
        System.out.println("ManagementStaff data saved to LinkedList");
        System.out.println("User Type: " + getUserType());
        System.out.println("Username: " + getUserName());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Location: " + getLocation());
        System.out.println("ManagementLevel: " + managementLevel);
    }

    public void assignDepartment(Recruit recruit, String department) {
        // Method implementation
    }

    public void getAvailableInterviewers() {
        // Method implementation
    }

    // Getters and setters
    // toString() method
    public String getManagementLevel() {
        return managementLevel;
    }

    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel;
    }
    
    
}
