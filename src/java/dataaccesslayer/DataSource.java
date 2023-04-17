/*
Student Name: Olamide Owolabi   
Student Number: 040982007
Course & Section #: 22S_CST8288_011
Declaration:
This is my own original work and is free from Plagiarism.
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The datasource for creating connection with database
 * @author Olamide Owolabi
 */
public class DataSource {
    
    /**
     * Empty Constructor
     */
    public DataSource(){}
    
    private String Url ="jdbc:mysql://localhost:3306/tutoring?serverTimezone=UTC&useSSL=false";
    private Connection conn = null;
    private String UserD;
    
    private String Mess;
    /**
     * To create connection to database
     * @param User the username
     * @param Pwd the password
     * @return return connection
     */
    public Connection createConnection(String User, String Pwd)
    {
        try{
            if(conn != null && UserD.equals(User))
            {
                System.out.println("Cannot create new connection, one exists already");
            }
            else{
                conn = DriverManager.getConnection(Url,User,Pwd);
            }
            
            Mess = "Connection Correct";
        } catch(SQLException ex)
        {
            ex.printStackTrace();
            Mess = "Connection Error: " + ex;
        }
        
        return conn;
    }
    
    /**
     * get message from connection, usually error
     * @return YOU MESSED UP
     */
    public String GetMessage()
    {
        return Mess;
    }
}
