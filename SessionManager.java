/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

/**
 *
 * @author 61475
 */
public class SessionManager {
 private static String currentUserName;
    private static String currentUserType;

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public static void setCurrentUserName(String currentUserName) {
        SessionManager.currentUserName = currentUserName;
    }

    public static String getCurrentUserType() {
        return currentUserType;
    }

    public static void setCurrentUserType(String currentUserType) {
        SessionManager.currentUserType = currentUserType;
    }
}
