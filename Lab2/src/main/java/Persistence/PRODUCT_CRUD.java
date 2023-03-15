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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class PRODUCT_CRUD {
    
    public static ArrayList<Item> readAll(){
        ArrayList<Item> items = new ArrayList<Item>();
        try{
            Connection con = DBConnection.getCon();
            
            String q = "SELECT * FROM DSC.PRODUCT LIMIT 100";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(q);

            while(rs.next()){
                items.add(new Item(
                        rs.getString("PRODUCTNAME"),
                        rs.getString("UPC"),
                        rs.getString("LOCATION"),
                        rs.getDouble("PRICE"),
                        rs.getInt("QUANTITY"),
                        rs.getString("TAGS"),
                        true
                ));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return items;
    }
    
    public static Item read(String upc){
        Item bean = null;
        try{
            Connection con = DBConnection.getCon();
            
            String q = "SELECT * FROM DSC.PRODUCT WHERE UPC=" + upc + "";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(q);
            
            if(rs.next()){
                bean = new Item(
                        rs.getString("PRODUCTNAME"),
                        rs.getString("UPC"),
                        rs.getString("LOCATION"),
                        rs.getDouble("PRICE"),
                        rs.getInt("QUANTITY"),
                        rs.getString("TAGS"),
                        true
                );
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return bean;
    }
    
    public static void update(Item item){
        try{
            Connection con = DBConnection.getCon();
            
            // 1. it doesn't exist -> add
            // 2. it already exists -> update
            
            String q = "SELECT * FROM DSC.PRODUCT WHERE UPC=" + item.getUPC() + "";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(q);
            
            if(rs.next()){
                // it already exists -> update
                
                q = "UPDATE" + item.getUPC() + "";
                state = con.createStatement();
                rs = state.executeQuery(q);
                
            }else{
                // it doesn't exist -> add
                //create();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void create(){
        
    }
}
