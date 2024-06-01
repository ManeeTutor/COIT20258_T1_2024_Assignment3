/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import java.util.LinkedList;

/**
 *
 * @author 61475
 */
public abstract class User {

    protected static LinkedList<User> userList = new LinkedList<>();

    private String userType;
    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String location;
    

    public User(String userType, String userName, String password, String fullName, String address, String phone, String email, String location) {
        this.userType = userType;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.location = location;

        userList.add(this);
    }

    public abstract void register();

    public void viewUserDetail() {
        // Method implementation
    }

    public void updateUserDatail() {
        // Method implementation
    }

    public boolean login(String userName, String password) {
        // Method implementation
        return true; // Dummy return
    }

    public void logout() {
        // Method implementation
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static LinkedList<User> getUserList() {
        return userList;
    }

    public static void setUserList(LinkedList<User> userList) {
        User.userList = userList;
    }

}
