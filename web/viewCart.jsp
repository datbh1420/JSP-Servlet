<%-- 
    Document   : viewCart
    Created on : Mar 1, 2023, 3:45:59 PM
    Author     : MSI GF63
--%>

<%@page import="java.util.Map"%>
<%@page import="dat.controller.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Cart Here</h1>

        <%
            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    if (cart.getItems() != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController">
                <%
                    Map<String, Integer> items = cart.getItems();
                    int count = 0;
                    for (Map.Entry item : items.entrySet()) {
                %>
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= item.getKey()%>
                    </td>
                    <td>
                        <%= item.getValue()%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkBook" value="<%= item.getKey()%>" />
                    </td>
                </tr> 
                <%
                    }
                %>
                <tr>
                    <td colspan="3">
                        <a href="bookStore.html">Add More Items To Cart</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove From Cart" name="btAction" />
                    </td>
                </tr>
            </form>

        </tbody>
    </table>
    <%
                    return;
                }
            }
        }
    %>
    <h2>Your Cart is Empty</h2>
    <a href="bookStore.html">Add More Items To Cart</a>
</body>
</html>
