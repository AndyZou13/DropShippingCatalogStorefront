/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import com.myproject.lab2.Item;
import com.myproject.lab2.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class CART_CRUD {
    public static ArrayList<Item> read(String username){
        ArrayList<Item> cart = new ArrayList<Item>();
        
        try{
            Connection con = DBConnection.getCon();
            
            String q = "select * from DSC.CART WHERE USERNAME='" + username + "'";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(q);
            
            while(rs.next()){
                String upc = rs.getString("UPC");
                cart.add(PRODUCT_CRUD.read(upc));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return cart;
    }
    
    public static void create(String username, String upc){
        try{
            Connection con = DBConnection.getCon();
            
            String q = "INSERT INTO CART(USERNAME,UPC) VALUES('" + username + "', '" + upc + "');";
            Statement s = con.createStatement();
            s.executeUpdate(q);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void delete(String username, String upc){
        try{
            Connection con = DBConnection.getCon();
            
            String q = "delete from DSC.CART where USERNAME='" + username + "' and UPC='" + upc + "';";
            PreparedStatement preparedStmt = con.prepareStatement(q);
            preparedStmt.execute();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
