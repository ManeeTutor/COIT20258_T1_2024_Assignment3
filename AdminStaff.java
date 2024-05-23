/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import com.cqu.aise.server.DatabaseUtils;
import com.cqu.aise.server.Staff;

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


    public void adminRegister() {
        super.userRegister(); //
        DatabaseUtils.adminRegister(this);
        System.out.println("Recruit registered");
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

}
