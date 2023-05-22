<%-- 
    Document   : createNewAccount.jsp
    Created on : Mar 4, 2023, 4:21:21 PM
    Author     : Buihuydat
--%>

<%@page import="dat.registration.InsertRegistrationError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController">
            <%InsertRegistrationError errors = (InsertRegistrationError) request.getAttribute("INSERTERROR");%>
            Username* <input type="text" name="txtUsername" value="<%=request.getParameter("txtUsername")%>" />(2-15 chars)
            <%
                if (errors != null) {
                    if (errors.getUsernameLengthErr() != null) {
            %>
            <font color="red"><%=errors.getUsernameLengthErr()%></font>
            <%}
                }
            %>
            <br>Password* <input type="text" name="txtPassword" value="" />(6-20 chars)
            <%
                if (errors != null) {
                    if (errors.getPasswordLengthErr() != null) {
            %>
            <font color="red"><%=errors.getPasswordLengthErr()%></font>
            <%}
                }
            %>
            <br>Confirm* <input type="text" name="txtConfirm" value="" />(6-20 chars)
            <%
                if (errors != null) {
                    if (errors.getConfirmNotMath() != null) {
            %>
            <font color="red"><%=errors.getConfirmNotMath()%></font>
            <%}
                }
            %>
            <br>Full name* <input type="text" name="txtFullname" value="<%=request.getParameter("txtFullname")%>" />(6-40 chars)
            <%
                if (errors != null) {
                    if (errors.getFullnameLengthErr() != null) {
            %>
            <font color="red"><%=errors.getFullnameLengthErr()%></font>
            <%}
                }
            %>
            <br><input type="submit" value="CreateNewAccount" name="btAction" />
            <input type="reset" value="Reset" />
            <%
                if (errors != null) {
                    if (errors.getUsernameIsExistErr() != null) {
            %>
            <font color="red"><%=errors.getUsernameIsExistErr()%></font>
            <%}
                }
            %>
        </form>
    </body>
</html>
