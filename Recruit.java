/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import com.cqu.aise.server.User;
import java.util.Date;

/**
 *
 * @author 61475
 */
public class Recruit extends User {

    private int recruitId;
    private Date interviewDate;
    private String qualification;
    private String department;
    private String interviewer;

    public Recruit(String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        super(userType, userName, password, fullName, address, phone, email, location);
    }

    public String getInterviewer() {
        // Method implementation
        return interviewer; // Dummy return
    }

    public void recruitRegister() {
        super.userRegister(); 
        System.out.println("Recruit registered");
    }

}
