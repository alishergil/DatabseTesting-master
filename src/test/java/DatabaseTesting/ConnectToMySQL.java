package DatabaseTesting;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class ConnectToMySQL {
    @Test
    public void testDatabase() throws ClassNotFoundException, SQLException {
        // Load MySQL Java Database Connectivity Driver.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded");
        // Create a connection with the Database -> Database url, Database username, Database password.
        // Connection URL Syntax: "jdbc:<db_type>://ip_address:port_number/db_name, dbUserName, dbPassword"
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karachi", "root", "shergil1652"); //MySQL_Password
        System.out.println("Connected to MySQL Database");
        // Create object of Statement to send the SQL query to the Database.
        Statement statement = connection.createStatement();

        // Execute the SQL query and store the result in ResultSet variable.
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student;"); // table name
        // while loop to iterate through each database records and print the results.
        while (resultSet.next()) {
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            System.out.println(firstname + "\t\t" + lastname + "\t\t" + email);
        }

        // the mysql insert statement
        String query = "INSERT INTO student (firstname, lastname, email) VALUES ('Super', 'Hero', 'hero@gmail.com');";
        // create the mysql insert prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // execute the prepared statement
        preparedStatement.execute();

        // Close statement.
        statement.close();
        // Close connection.
        connection.close();
    }
}
