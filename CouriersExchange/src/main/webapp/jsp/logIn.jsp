<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 26.10.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<hr/>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginMessage}
    <br/>
    <input type="submit" value="Log in"/>
</form><hr/>
<a href="${pageContext.request.contextPath}/jsp/signUp.jsp">Don't have account? SignUp</a>
</body>
</html>
