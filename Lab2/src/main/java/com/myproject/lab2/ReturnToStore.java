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
import java.util.ArrayList;
import java.util.Scanner;
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
@WebServlet(name = "ReturnToStore", urlPatterns = {"/ReturnToStore"})
public class ReturnToStore extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        // load items from storage
        ArrayList<Item> items = retrieveItems();
        request.setAttribute("items", items);
        
        // pass cart backwards
        String[] cartUPCs = request.getParameterValues("item");
        ArrayList<Item> cart = new ArrayList();
        
        if(cartUPCs != null){
            for(int i = 0; i < cartUPCs.length; i++){
                String UPC = cartUPCs[i];

                for(int j = 0; j < items.size(); j++){
                    if(items.get(j).getUPC().equals(UPC))
                        cart.add(items.get(j));
                }
            }
        }
        
        System.out.println(cart.size());
        request.setAttribute("cart", cart);
        
        RequestDispatcher rd= request.getRequestDispatcher("searchPage.jsp");
            rd.forward(request, response);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
