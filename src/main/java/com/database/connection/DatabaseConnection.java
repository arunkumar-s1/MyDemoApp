package com.database.connection;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection getConnection() 
        throws SQLException, ClassNotFoundException 
    { 
        Connection con= null;
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
        return con; 
    } 
} 
