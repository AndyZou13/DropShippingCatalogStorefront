/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
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
        String username=(String) request.getParameter("username");
        String password=(String) request.getParameter("password");
        
        UserInfo uinfo=getUserInfo(username, password);
        File file = new File("/home/student/Documents/Lab2/src/main/webapp/resources/logins.txt");
        Scanner sc = new Scanner(file);
        String[] temp = new String[2];
        ArrayList<String[]> userpass = new ArrayList<>();
        String[] up = {username, password};
        while (sc.hasNextLine()) {
            temp = sc.nextLine().toLowerCase().split(" ");
            userpass.add(temp);
        }
        
        if (uinfo==null){
            RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else if (userpass.contains(up) == false) {
            RequestDispatcher rd= request.getRequestDispatcher("loginfailed.jsp");
            rd.forward(request, response);
        }
        else {
            request.getSession().setAttribute("uname", username);
            request.setAttribute("booksBorrowedInfo", uinfo.getCart());
            
            RequestDispatcher rd= request.getRequestDispatcher("userbooks.jsp");
            rd.forward(request, response);
            
        }
    }
    private UserInfo getUserInfo(String uname, String password) {
        
        UserInfo uf= new UserInfo(uname, password);
        
        return uf;
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
