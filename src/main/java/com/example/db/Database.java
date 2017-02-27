package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConnection() throws Exception {


        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1:3306/shortner","root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

            return null;
        }

        return connection;
//        String connectionURL = "jdbc:mysql://localhost:3306/shortner";
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(connectionURL, "root", "root");
//        return connection;
    }

}
