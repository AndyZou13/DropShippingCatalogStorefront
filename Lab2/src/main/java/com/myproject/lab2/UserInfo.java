/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.lab2;

import Persistence.CART_CRUD;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class UserInfo {
    private ArrayList<Item> cart = null;
    private boolean isAdmin = false;
    
    private String username;
    private String password;
    private String fname, lname;
    
    public UserInfo (String username, String password) {
        this.username = password;
        this.password = password;
    }
    
    public UserInfo(String username, String password, String fname, String lname){
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }
    
    public void addItem(Item item) {
        cart.add(item);
    }
    
    public ArrayList<Item> getCart() {
        if(cart == null){
            System.out.println("Retrieving Cart");
            cart = CART_CRUD.read(this.username);
        }
        
        return this.cart;
    }
    
    public void setCart(ArrayList<Item> cart){
        this.cart = cart;
    }
    
    public boolean getAdmin() {
        return isAdmin;
    }
    
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public String getFname(){
        return this.fname;
    }
    
    public String getUsername(){
        return this.username;
    }
}
