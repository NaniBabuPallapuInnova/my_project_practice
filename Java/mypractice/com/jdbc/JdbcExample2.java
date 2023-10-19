package mypractice.com.jdbc;

import java.sql.*;

public class JdbcExample2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            //step 1 : register the drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/practice";
            String username = "root";
            String password = "root";
            // step2 : Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION HAS BEEN ESTABLISHED");
/*          // step3: create prepared statement for insert query
           PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?)");
            preparedStatement.setInt(1,7);
            preparedStatement.setString(2,"09-10-2024");
            preparedStatement.setString(3,"Sunscreen");
            preparedStatement.setDouble(4,550.40);

            //step4. execute the query
            int value = preparedStatement.executeUpdate();
*/
//           step 3: create a statement for select query
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product where id = ?");
            preparedStatement.setInt(1,7);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+"  "+resultSet.getDouble(4));
            }
            connection.close();
        } catch (Exception ex){
            System.out.println("Exception Occurred "+ex);
        }

    }
}
