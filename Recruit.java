/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;
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

    public Recruit(String qualification, String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        super(userType, userName, password, fullName, address, phone, email, location);
        this.qualification = qualification;
    }

    @Override
    public void register() {
        DatabaseUtils.recruitRegister(this);
        System.out.println("Revruit data saved to LinkedList");
        System.out.println("User Type: " + getUserType());
        System.out.println("Username: " + getUserName());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Location: " + getLocation());
        System.out.println("Qualification: " + qualification);
    }

    public String getInterviewer() {
        // Method implementation
        return interviewer; // Dummy return
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
}
