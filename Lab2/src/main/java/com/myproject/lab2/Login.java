/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author student
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        File file = new File("/home/student/Documents/Lab2/src/main/webapp/resources/logins.txt");
        Scanner sc = new Scanner(file);
        
        boolean match = false;
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().toLowerCase().split(" ");
            
            if(temp[0].equals(username) && temp[1].equals(password)){
                match = true;
                break;
            }
        }
        
        if (match) {
            // look up user info based on username and password
            UserInfo userInfo = getUserInfo(username, password);
            
            request.getSession().setAttribute("username", username);
            request.setAttribute("cart", userInfo.getCart());
            
            // load items from storage
            ArrayList<Item> items = retrieveItems();
            request.setAttribute("items", items);
            
            RequestDispatcher rd= request.getRequestDispatcher("searchPage.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd= request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
    }
    
    private ArrayList<Item> retrieveItems() throws FileNotFoundException{
        File file = new File("/home/student/Documents/Lab2/src/main/webapp/resources/items.txt");
        Scanner sc = new Scanner(file);
        
        ArrayList<Item> items = new ArrayList<>();
        
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().toLowerCase().split(" ");
            
            Item newItem = new Item(
                    data[0], data[1], data[2], 
                    Double.parseDouble(data[3]), 
                    parseInt(data[4]), 
                    Boolean.parseBoolean(data[5])
            );
            
            items.add(newItem);
        }
        
        return items;
    }
    
    private UserInfo getUserInfo(String username, String password) {
        UserInfo userInfo = new UserInfo(username, password);
        return userInfo;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
// </editor-fold>

}
