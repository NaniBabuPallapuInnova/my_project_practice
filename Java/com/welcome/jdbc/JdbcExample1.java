package com.welcome.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample1 {
    public static void main(String[] args) {

        try {
            //1. Register the drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. Establish the connection.
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
            //3. Creating the statement
            Statement statement = connection.createStatement();

            // writing the quires to execute
            int rowsResult =  statement.executeUpdate("insert into product values(6,'09-10-2023','Pants',5000)"); // Insert the data
            int rowResult =  statement.executeUpdate("update product set product_name='Shirt',product_price=1500 where id=1"); // Update the data
            int result=statement.executeUpdate("delete from product where id=5");

            //4. Execute the queries.
            ResultSet resultSet = statement.executeQuery("select * from product");

            int values[] = statement.executeBatch();

            System.out.println("ID" +" "+"Expiry Date"+" "+"Product Name"+" "+"Price");
            // Printing the table data
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
            }
            //5. close the connection.
            connection.close();

        } catch (Exception ex){
            System.out.println("Exception happened "+ex);
        }


    }
}
