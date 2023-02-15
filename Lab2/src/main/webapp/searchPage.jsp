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
        <title>Store Page</title>
    </head>
    
    <%
        ArrayList<Item> cart = (ArrayList)request.getAttribute("cart");
        ArrayList<Item> items = (ArrayList)request.getAttribute("items");
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
                    <th> Add To Cart </th>
                </tr>
                
                <% 
                    for(int i = 0; i < items.size(); i++){ 
                    Item item = items.get(i);
                %>
                <tr>
                    
                <td> <%= item.getItemName() %> </td>
                <td> <%= item.getUPC() %> </td>
                <td> <%= item.getLocation() %> </td>
                <td> <%= item.getPrice() %> </td>
                <td> <%= item.getQuantity() %> </td>
                
                <% if (item.isAvailable()){ %>
                    <% if(cart.contains(item)){ %>
                        <td> <input type="checkbox" name="item" value="<%=item.getUPC()%>" checked></td>
                    <% }else{ %>
                        <td> <input type="checkbox" name="item" value="<%=item.getUPC()%>"></td>
                <%}} else { %>
                    <td> Not Available </td>
                <% }} %>
                
                </tr>
            </table>
            
            <input type="submit" value="View Cart">
        </form>
    </body>
</html>
