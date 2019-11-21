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

<form id="form-signUp" name="signUpForm" method="post" action="controller">
    <input type="hidden" name="command" value="signUp" />
    Login:<br/>
    <input type="text" name="login" value=""/><br/>
    Email:<br/>
    <input type="email" name="email" value=""/><br/>
    Name:<br/>
    <input type="text" name="name" value=""/><br/>
    Password:<br/>
    <input type="password" name="password" value=""/><br/>
    Type of user:<br/>
    <select form="form-signUp" id="select-userType" name="userType" autofocus>
        <option value="client">Client</option>
        <option value="courier">Courier</option>
    </select>
    <br/>${errorMessage}<br/>
    <input type="submit" value="SignUp"/>
</form>
<form name="testForm" method="post" action="controller">
    <input type="hidden" name="command" value="signUp"/>
    <input type="submit" name="testButton" value="Click Me"/>
</form>
<hr/>
<a href="${pageContext.request.contextPath}/jsp/logIn.jsp">Already have account? LogIn</a>
</body>
</html>
