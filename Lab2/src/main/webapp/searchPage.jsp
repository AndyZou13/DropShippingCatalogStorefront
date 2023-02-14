<%-- 
    Document   : searchPage
    Created on : Feb 14, 2023, 9:45:28 AM
    Author     : student
--%>

<%@page import="com.myproject.lab2.Item"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%
        ArrayList<Item> cart = (ArrayList)request.getAttribute("cart");
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("testItem", "176839402934", "Canada", 15.0, 10, true));
    %>
    
    <body>
        <center><h3> Items </h3></center>
        <form action="AddToCart" method="post">
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th> Item Name </th>
                    <th> UPC </th>
                    <th> Location </th>
                    <th> Price </th>
                    <th> Quantity </th>
                </tr>
                
                <% 
                    for(Item item : items){ %>
                <tr>
                    
                <td> <%= item.getItemName() %> </td>
                <td> <%= item.getUPC() %> </td>
                <td> <%= item.getLocation() %> </td>
                <td> <%= item.getPrice() %> </td>
                <td> <%= item.getQuantity() %> </td>
                
                <% if (item.isAvailable()){ %>
                    <td> <input type="submit" value="+"></td>
                <%} else { %>
                    <td> "The item is not available for purchase" </td>
                <% }} %>
                
                </tr>
            </table>
                
        </form>
    </body>
</html>
