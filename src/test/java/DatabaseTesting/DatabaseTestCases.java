package DatabaseTesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class DatabaseTestCases {
    // Constant for Database URL
    private static String databaseUrl = "jdbc:mysql://localhost:3306/karachi";
    // Constant for Database Username
    private static String databaseUsername = "root";
    // Constant for Database Password
    private static String databasePassword = "shergil1652";

    // Connection object declaration and initialization.
    private Connection connection = null;
    // Statement object declaration.
    private Statement statement = null;

    @Before
    public void setUp() throws Exception {
        try {
            // Make the database connection and Load MySQL Java Database Connectivity Driver.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            // Create a connection with the Database -> Databse url, Databse username, Database password.
            // Connection URL Syntax: "jdbc:<db_type>://ip_address:port_number/db_name"
            Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword); //MySQL_Password
            System.out.println("Connected to MySQL Database");
            // Use Statement object to send the SQL statement to the Database.
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() throws SQLException {
        try {
            // Execute the SQL query and store the result in ResultSet variable.
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student;"); // table name
            // while loop to iterate through all database records and print the results.
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                System.out.println(firstname + "\t\t" + lastname + "\t\t" + email);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create() {
        try {
            // the insert query
            String query = "INSERT INTO student (firstname, lastname, email) VALUES ('Ricky', 'Martin', 'ricky@gmail.com');";
            // execute the query
            statement.execute(query);
            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try {
            // the delete query
            String query = "DELETE FROM student WHERE firstname = 'Super'";
            // execute the query
            statement.execute(query);
            System.out.println("Record deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try {
            // the update query
            String query = "UPDATE student SET lastname = 'Tudor' WHERE firstname = 'William';";
            // execute the query
            statement.execute(query);
            System.out.println("Record updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws SQLException {
        // Close statement.
        statement.close();
        // Close connection.
        if (connection != null) {
            connection.close();
        }
    }
}
