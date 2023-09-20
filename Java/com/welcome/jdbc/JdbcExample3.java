package com.welcome.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            //step Register the drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/practice";
            String username = "root";
            String password = "root";

            // step2 : Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION HAS BEEN ESTABLISHED");

            //step3 : Create the callable statement
            CallableStatement callableStatement = connection.prepareCall("{call sample(?,?,?,?)}");
            callableStatement.setInt(1, 8);
            callableStatement.setString(2, "09-10-2024");
            callableStatement.setString(3,"Face Serum");
            callableStatement.setDouble(4,700.56);
            int value=  callableStatement.executeUpdate();
            if (value==1) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
