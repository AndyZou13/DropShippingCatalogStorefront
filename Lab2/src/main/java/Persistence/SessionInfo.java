/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import com.myproject.lab2.Item;
import com.myproject.lab2.UserInfo;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class SessionInfo {
    public static UserInfo userInfo;
    public static ArrayList<Item> items;
    
    public static void reset(){
        userInfo = null;
        items = null;
    }
}
