/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import com.cqu.aise.server.User;

/**
 *
 * @author 61475
 */
public class Staff extends User {

    public Staff(String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        super(userType, userName, password, fullName, address, phone, email, location);
    }

    public void viewRecruitDetail() {
        // Method implementation
    }

    // Getters and setters
    // toString() method
}
