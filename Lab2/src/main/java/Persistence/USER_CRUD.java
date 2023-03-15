/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import com.myproject.lab2.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author student
 */
public class USER_CRUD {
    
    public static UserInfo read(String username, String password){
        UserInfo bean = null;
        try{
            Connection con = DBConnection.getCon();
            String q = "select * from PERSON WHERE USERNAME='" + username + "'";
            
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String fname = rs.getString("FIRSTNAME");
                String lname = rs.getString("LASTNAME");
                String pass = rs.getString("PASSWORD");
                
                if(pass.equals(password)){
                    bean = new UserInfo(username, password, fname, lname);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return bean;
    }
}
