package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Static Method
    public static Connection getConnection() {

        Connection con = null;

        try {
            // JDBC Driver Loading
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database Connection
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/librarydb","root","root"); 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}