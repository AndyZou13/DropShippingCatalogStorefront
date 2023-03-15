<%-- 
    Document   : searchPage
    Created on : Feb 14, 2023, 9:45:28 AM
    Author     : student
--%>

<%@page import="Persistence.SessionInfo"%>
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
        ArrayList<Item> cart = SessionInfo.userInfo.getCart();
    %>
    
    <body>
        
        <div style="display:flex; flex-direction:row; justify-content: center; align-items:center;gap:5rem;"> 
            <p> Welcome, <%= SessionInfo.userInfo.getFname() %> </p>
            
            <form action="Logout" method="post">
                <input type="submit" value="Log out">
            </form>
        </div>
        
        <center><h3> Cart </h3></center>
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
                    for(int i = 0; i < cart.size(); i++){ 
                    Item item = cart.get(i);
                %>
                <tr>
                    
                <td> <%= item.getItemName() %> </td>
                <td> <%= item.getUPC() %> </td>
                <td> <%= item.getLocation() %> </td>
                <td> <%= item.getPrice() %> </td>
                <td> <%= item.getQuantity() %> </td>
                
                <form action="UpdateCartView" method="post">
                    <center>
                    <% if (item.isAvailable()){ %>
                            <td> <input type="submit" name=<%=item.getUPC()%> value="Remove"/></td>
                    <%} else { %>
                        <td> Not Available </td>
                    <% }} %>
                    </center>
                </form>
                </tr>
            </table>
            
            <br>
            
            <center>
                <form action="ReturnToStore" method="post">
                    <input type="submit" value="Return to Search">
                </form>
            </center>
    </body>
</html>
