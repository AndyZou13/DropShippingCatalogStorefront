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
public class UserInfo {
    private ArrayList<Item> cart = new ArrayList<>();
    private boolean isAdmin = false;
    private String user;
    private String pass;
    public UserInfo (String uname, String pword) {
        user = uname;
        pass = pword;
    }
    public void addItem(Item item) {
        cart.add(item);
    }
    public ArrayList<Item> getCart() {
        return cart;
    }
    public boolean getAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean ad) {
        isAdmin = ad;
    }
}
