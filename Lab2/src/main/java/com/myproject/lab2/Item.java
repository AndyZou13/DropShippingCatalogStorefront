/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.lab2;

import java.util.ArrayList;

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
    String tags;
    
    public Item (String itemName, String UPC, String location, double price, int quantity, String tags, boolean available) {
        this.itemName = itemName;
        this.UPC = UPC;
        this.location = location;
        this.price = price;
        this.quantity = quantity;
        this.tags = tags;
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
    
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Item)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        Item c = (Item) o;
         
        // Compare the data members and return accordingly
        return UPC.equals(c.UPC);
    }
}
