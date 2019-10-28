<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 26.10.2019
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<form name="signUpForm" method="post" action="logIn">
    <input type="hidden" name="command" value="signUp" />
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Email:<br/>
    <input type="email" name="email" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value="">
    <br/>
    <input type="submit" value="SignUp">
</form>
<hr/>
<a href="logIn.jsp">Already have account? LogIn</a>
</body>
</html>
