package com.welcome.practice;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import java.io.*;
import java.net.Socket;
public class Check {


        public static void main(String[] args) {
            // Define the XML request
            String requestXML = "<request><data>Hello, Server!</data></request>";
            // Define the server's IP address and port
            String serverAddress = "127.0.0.1"; // Replace with your server's IP address
            int serverPort = 8080; // Replace with the server's port

            try (Socket socket = new Socket(serverAddress, serverPort);
                 OutputStream out = socket.getOutputStream()) {
                // Convert the XML request string to bytes and send it to the server
                out.write(requestXML.getBytes());

                // Ensure the data is sent
                out.flush();

                System.out.println("XML request sent to the server.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
