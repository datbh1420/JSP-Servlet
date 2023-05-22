<%-- 
    Document   : search
    Created on : Feb 18, 2023, 4:06:35 PM
    Author     : Buihuydat
--%>

<%@page import="java.util.List"%>
<%@page import="dat.registration.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <% 
            String fullname = (String) session.getAttribute("FULLNAME");
                if(fullname!=null){
            
        %>
        <font color="red">welcome, <%=fullname %></font>
        <%}%>
        <h1>Search</h1>
        <form action="MainController">
            Search Value:
            <input type="text" name="txtSearchValue" value="" />
            <input type="submit" value="Search" name="btAction" />
        </form>
        
        <%
            String searchValue = request.getParameter("txtSearchValue");
            if(searchValue != null){
                List<RegistrationDTO> results = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if(results!= null){
                    %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Lastname</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
                <tbody>
                    <%
                        int count = 0;
                        for(RegistrationDTO dto : results){
                            String urlRewriting = "MainController?btAction=Del&pk="
                            + dto.getUsername() + "&lastSearchValue=" + request.getParameter("txtSearchValue");
                    %>
                <form action="MainController">
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getUsername() %>
                        <input type="hidden" name="txtUsername" value="<%= dto.getUsername() %>" />
                    </td>
                    <td>
                        <input type="text" name="txtPassword" value="<%= dto.getPassword() %>" />
                    </td>
                    <td>
                        <input type="text" name="txtLastname" value="<%= dto.getLastname()%>" />
                    </td>
                    <td>
                        <input type="checkbox" name="ADMIN" value="ON"<%if(dto.isRole()){%>
                               checked="checked"
                               <% }%>
                               />
                    </td>
                    <td>
                        <a href="<%= urlRewriting %>">Delete</a>
                    </td>
                    <td>
                        <input type="submit" value="Update" name="btAction" />
                        <input type="hidden" name="lastSearchValue" value="<%= request.getParameter("txtSearchValue") %>" />
                    </td>
                </tr>
            </form>

                <%
                    }
                %>
           
                </tbody>
        </table>   
        <%
                }else{
                %>
                <h2>No record!</h2>
        <%
                }
            }
        %>
    </body>
</html>
