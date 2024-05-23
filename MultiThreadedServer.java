/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cqu.aise.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 61475
 */
public class MultiThreadedServer {

    private ServerSocket serverSocket;

    public MultiThreadedServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket);

                // Handle client in a new thread
                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Your code for handling client requests
                // For example, handling registration and login
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        try {
            // Check and create database if it doesn't exist
            DatabaseUtils.checkAndCreateDatabase();
            // Create AdminStaff table if it doesn't exist
            DatabaseUtils.createAdminStaffTable();

            // Start the server
            MultiThreadedServer server = new MultiThreadedServer(port);
            System.out.println("Server started on port " + port);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
