<%-- 
    Document   : user
    Created on : 2017-3-23, 10:18:35
    Author     : zz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="user.*"%>
<jsp:useBean id="userDao" type="user.UserDao" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>JPA userBook Web Application Tutorial</title>
    </head>
 
    <body>
        <form method="POST" action="guest.html">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> 
        <% for (User user : userDao.getAllUsers()) { %>
            <li> <%= user %> </li>
        <% } %>
        </ol><hr>
 
        <iframe src="http://www.objectdb.com/pw.html?spring-netbeans"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
     </body>
 </html>
