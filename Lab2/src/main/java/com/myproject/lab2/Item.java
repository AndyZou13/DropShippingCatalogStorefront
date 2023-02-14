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
    public Item (String itemName, String UPC, String location, double price, int quantity, boolean available) {
        this.itemName = itemName;
        this.UPC = UPC;
        this.location = location;
        this.price = price;
        this.quantity = quantity;
    }
}
