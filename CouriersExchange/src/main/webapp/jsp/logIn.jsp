<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 26.10.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body><h3>Login</h3>
<hr/>
<form name="loginForm" method="post" action="controller">
    <input type="hidden" name="command" value="logIn" />
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value="">
    <br/>
    <input type="submit" value="LogIn">
</form>
<hr/>
<a href="SignUp.jsp">Don't have account? SignUp</a>
</body>
</html>
