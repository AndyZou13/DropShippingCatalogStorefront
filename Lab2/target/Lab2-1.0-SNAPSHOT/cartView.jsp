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
        <title>Cart View</title>
    </head>
    
    <%
        ArrayList<Item> cart = (ArrayList)request.getAttribute("cart");
    %>
    
    <body>
        <center><h3> Items </h3></center>
        <form action="ReturnToStore" method="post">
            <table border="2" align="center" cellpadding="5" cellspacing="5">
                <tr>
                    <th> Item Name </th>
                    <th> UPC </th>
                    <th> Location </th>
                    <th> Price </th>
                    <th> Quantity </th>
                    <th> Keep In Cart </th>
                </tr>
                
                <% 
                    for(int i = 0; i < cart.size(); i++){ 
                    Item item = cart.get(i);
                %>
                <tr>
                    
                <td> <%= item.getItemName() %> </td>
                <td> <%= item.getUPC() %> </td>
                <td> <%= item.getLocation() %> </td>
                <td> <%= item.getPrice() %> </td>
                <td> <%= item.getQuantity() %> </td>
                
                <% if (item.isAvailable()){ %>
                    <td> <input type="checkbox" name="item" value="<%=item.getUPC()%>" checked></td>
                <%} else { %>
                    <td> Not Available </td>
                <% }} %>
                
                </tr>
            </table>
            
            <input type="submit" value="Return To Store">
        </form>
    </body>
</html>
