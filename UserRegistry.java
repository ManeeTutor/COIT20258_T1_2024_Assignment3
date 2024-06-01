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
public class UserRegistry {
    private static LinkedList<User> users = new LinkedList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static LinkedList<User> getUsers() {
        return users;
    }
}
