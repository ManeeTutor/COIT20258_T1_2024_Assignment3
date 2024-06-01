/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

/**
 *
 * @author 61475
 */
public class AdminStaff extends Staff {

    private int adminStaffId;
    private String positionType;

    public AdminStaff(String positionType, String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        super(userType, userName, password, fullName, address, phone, email, location);
        this.positionType = positionType;
    }

    @Override
    public void register() {
        DatabaseUtils.adminRegister(this);
        System.out.println("AdminStaff data saved to LinkedList");
        System.out.println("User Type: " + getUserType());
        System.out.println("Username: " + getUserName());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Location: " + getLocation());
        System.out.println("PositionType: " + positionType);
    }

    public void registerRecruit() {
        // Method implementation
    }

    public void updateRecruitDetail() {
        // Method implementation
    }

    public void setInterviewer() {
        // Method implementation
    }

    public void setInterviewDate() {
        // Method implementation
    }

    // Getters and setters
    // toString() method
    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    
    
}
