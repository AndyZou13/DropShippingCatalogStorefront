/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class DBConnection {
    
    private static Connection con = null;
    
    public static Connection getCon(){
        if(con != null) 
            return con;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSC", "root", "student");
            System.out.println("Connection established.");
        }catch(Exception e){
            System.out.println(e);
        }
        
        return con;
    }
}
