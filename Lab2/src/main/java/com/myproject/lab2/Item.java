/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.lab2;

/**
 *
 * @author student
 */
public class Item {
    String itemName;
    String UPC;
    String location;
    double price;
    int quantity;
    boolean available;
    
    public Item (String itemName, String UPC, String location, double price, int quantity, boolean available) {
        this.itemName = itemName;
        this.UPC = UPC;
        this.location = location;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    
    public String getUPC(){
        return UPC;
    }
    
    public void setUPC(String UPC){
        this.UPC = UPC;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public int getQuantity(){
        return this.quantity; 
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public boolean isAvailable(){
        return available;
    }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
    
    
    
    
}
