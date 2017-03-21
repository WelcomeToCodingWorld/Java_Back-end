<%-- 
    Document   : Login
    Created on : 2017-3-10, 14:49:52
    Author     : zz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
//导入bean类
<%@page import = "com.zyl.bean.User" %>
//创建bean类实例
<jsp:useBean id="user" class="com.zyl.bean.User" scope="page"></jsp:useBean>
//访问bean类实例的属性
<jsp:setProperty property="name" name="user" value="大伟"></jsp:setProperty>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form name="loginFrm" method="POST" action="CalendarServlet">
            <table frame="box" cellSpacing="5" aligh="left">
                <tr>
                    <td colspan="2" align="center"><p><h3>用户登录</h3></p></td>
                </tr>
                <tr>
                    <td><label for="username">用户名</label></td>
                    <td><input type="text" name="username" value=""/></td>
                </tr>
                <tr>
                    <td><label for="userpwd">密 码</label></td>
                    <td><input type="text" name="userpwd" value=""/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="image" src="./pingbao.png" width="100%" height="80%" border="0" value="登录" onclick="document.forms['loginFrm'].submit();"/>
                    </td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
