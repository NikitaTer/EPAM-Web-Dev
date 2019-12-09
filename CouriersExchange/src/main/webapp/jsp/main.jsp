<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 12.11.2019
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Main Page</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <%--<script src="js/SignUpButton.js" type="text/javascript"></script>--%>

    <c:set var="language" value="${sessionScope.lang}"/>

    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="properties.local" var="local"/>

    <fmt:message bundle="${local}" key="main.signIn" var="signIn"/>
    <fmt:message bundle="${local}" key="main.signOut" var="signOut"/>
    <fmt:message bundle="${local}" key="main.signUp" var="signUp"/>

    <fmt:message bundle="${local}" key="main.signIn.signIn" var="signIn_signIn"/>
    <fmt:message bundle="${local}" key="main.signIn.login" var="signIn_login"/>
    <fmt:message bundle="${local}" key="main.signIn.enterLogin" var="signIn_enterLogin"/>
    <fmt:message bundle="${local}" key="main.signIn.password" var="signIn_password"/>
    <fmt:message bundle="${local}" key="main.signIn.enterPassword" var="signIn_enterPassword"/>
    <fmt:message bundle="${local}" key="main.signIn.forgotPassword" var="signIn_forgotPassword"/>
    <fmt:message bundle="${local}" key="main.signIn.signUpHere" var="signIn_signUpHere"/>
    <fmt:message bundle="${local}" key="main.signIn.login" var="signIn_login"/>
    <fmt:message bundle="${local}" key="main.signIn.enterLogin" var="signIn_enterLogin"/>

    <fmt:message bundle="${local}" key="main.signUp.signUp" var="signUp_signUp"/>
    <fmt:message bundle="${local}" key="main.signUp.email" var="signUp_email"/>
    <fmt:message bundle="${local}" key="main.signUp.enterEmail" var="signUp_enterEmail"/>
    <fmt:message bundle="${local}" key="main.signUp.login" var="signUp_login"/>
    <fmt:message bundle="${local}" key="main.signUp.enterLogin" var="signUp_enterLogin"/>
    <fmt:message bundle="${local}" key="main.signUp.password" var="signUp_password"/>
    <fmt:message bundle="${local}" key="main.signUp.enterPassword" var="signUp_enterPassword"/>
    <fmt:message bundle="${local}" key="main.signUp.repeatPassword" var="signUp_repeatPassword"/>
    <fmt:message bundle="${local}" key="main.signUp.userType.choose" var="signUp_userType_choose"/>
    <fmt:message bundle="${local}" key="main.signUp.userType.courier" var="signUp_userType_courier"/>
    <fmt:message bundle="${local}" key="main.signUp.userType.client" var="signUp_userType_client"/>
    <fmt:message bundle="${local}" key="main.signUp.signInHere" var="signUp_signInHere"/>

    <fmt:message bundle="${local}" key="main.verify.header" var="verify_header"/>
    <fmt:message bundle="${local}" key="main.verify.enterCode" var="verify_enterCode"/>
    <fmt:message bundle="${local}" key="main.verify.message" var="verify_message"/>
    <fmt:message bundle="${local}" key="main.verify.notCome" var="verify_notCome"/>
    <fmt:message bundle="${local}" key="main.verify.submit" var="verify_submit"/>

</head>
<body style="background-image: url('https://cdn.wallpapersafari.com/0/41/8hPboS.jpg');">

<%-- Navigation Bar --%>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="#" class="navbar-brand">CourierEx</a>
            </div>

            <div>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#signUp" data-toggle="modal" data-target="#signUp">${signUp}</a></li>
                    <li class="active"><a href="#signIn" data-toggle="modal" data-target="#signIn">${signIn}</a></li>
                </ul>
            </div>
        </div>
    </nav>

<%-- SignIn form --%>
    <div class="modal fade login" id="signIn" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header" style="padding: 35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3>${signIn_signIn}</h3>
                </div>

                <div class="modal-body" style="padding: 40px 50px;">
                    <form name="signInForm" method="post" action="controller">
                        <input type="hidden" name="command" value="signIn" />
                        <div class="form-group">
                            <label for="login_signIn">${signIn_login}</label>
                            <input type="text" name="login" id="login_signIn" value="" class="form-control" placeholder="${signIn_enterLogin}" />
                        </div>
                        <div class="form-group">
                            <label for="password_signIn">${signIn_password}</label>
                            <input type="password" name="password" id="password_signIn" value="" class="form-control" placeholder="${signIn_enterPassword}" />
                        </div>
                        <button type="submit" class="btn btn-success btn-block">${signIn_signIn}</button>
                        <p><a href="#">${signIn_forgotPassword}</a></p>
                    </form>
                </div>

                <div class="modal-footer" style="padding: 40px 50px;">
                    <p><a href="#signUp" data-toggle="modal" data-target="#signUp" data-dismiss="modal">${signIn_signUpHere}</a></p>
                </div>

            </div>
        </div>
    </div>

<%-- SignUp form --%>
    <div class="modal fade login" id="signUp" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header" style="padding: 35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3>${signUp_signUp}</h3>
                </div>

                <div class="modal-body" style="padding: 40px 50px;">
                    <form name="signUpForm" id="signUpForm" method="post" action="controller">
                        <input type="hidden" name="command" value="signUp" />
                        <div class="form-group">
                            <label for="email_signUp">${signUp_email}</label>
                            <input type="text" name="email" id="email_signUp" value="" class="form-control" placeholder="${signUp_enterEmail}" />
                        </div>
                        <div class="form-group">
                            <label for="login_signUp">${signUp_login}</label>
                            <input type="text" name="login" id="login_signUp" value="" class="form-control" placeholder="${signUp_enterLogin}" />
                            <p>${loginMessage}</p>
                        </div>
                        <div class="form-group">
                            <label for="password_signUp">${signUp_password}</label>
                            <input type="password" name="password" id="password_signUp" value="" class="form-control" placeholder="${signUp_enterPassword}" />
                        </div>
                        <div class="form-group">
                            <input type="password" name="repeatPassword" id="repeatPassword_signUp" value="" class="form-control" placeholder="${signUp_repeatPassword}" />
                            <p>${passwordMessage}</p>
                        </div>
                        <div class="form-group">
                            <label for="userType_signUp">${signUp_userType_choose}</label>
                            <br/>
                            <select name="userType" id="userType_signUp">
                                <option value="courier">${signUp_userType_courier}</option>
                                <option value="client">${signUp_userType_client}</option>
                            </select>
                        </div>
                        <input type="submit" value="${signUp_signUp}" id="signUpButton_signUp" class="btn btn-success btn-block" />
                    </form>
                </div>

                <div class="modal-footer" style="padding: 40px 50px;">
                    <p><a href="#signIn" data-toggle="modal" data-target="#signIn" data-dismiss="modal">${signUp_signInHere}</a></p>
                </div>

            </div>
        </div>
    </div>

</body>
</html>
