/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import com.cqu.aise.server.Recruit;
import com.cqu.aise.server.Staff;

/**
 *
 * @author 61475
 */
public class ManageStaff extends Staff {

    private int manageStaffId;
    private String managementLevel;

    public ManageStaff(String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        super(userType, userName, password, fullName, address, phone, email, location);
    }

    public void manageRegister() {
        super.userRegister(); 

        System.out.println("Recruit registered");
    }

    public void assignDepartment(Recruit recruit, String department) {
        // Method implementation
    }

    public void getAvailableInterviewers() {
        // Method implementation
    }

    // Getters and setters
    // toString() method
}
