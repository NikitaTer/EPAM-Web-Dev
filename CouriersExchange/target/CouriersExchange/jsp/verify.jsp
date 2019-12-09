<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 08.12.2019
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Verify Window</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <c:set var="language" value="${sessionScope.lang}"/>

    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="properties.local" var="local"/>

    <fmt:message bundle="${local}" key="main.verify.header" var="verify_header"/>
    <fmt:message bundle="${local}" key="main.verify.enterCode" var="verify_enterCode"/>
    <fmt:message bundle="${local}" key="main.verify.message" var="verify_message"/>
    <fmt:message bundle="${local}" key="main.verify.notCome" var="verify_notCome"/>
    <fmt:message bundle="${local}" key="main.verify.submit" var="verify_submit"/>

</head>
<body style="background-image: url('https://cdn.wallpapersafari.com/0/41/8hPboS.jpg')">
<div class="container" id="verify" role="dialog" style="padding: 35px 50px;">
    <div <%--class="modal-dialog"--%>>
        <div class="modal-content">
            <div class="text-center">
                <%--<button type="button" class="close" data-dismiss="modal">&times;</button>--%>
                <h3>${verify_header}</h3>
            </div>

            <div style="padding: 30px 30px;">
                <form name="verifyForm" method="post" action="controller">
                    <input type="hidden" name="command" value="verify"/>
                    <div class="form-group">
                        <label for="verify_code">${verify_message}</label>
                        <input type="text" name="verifyCode" id="verify_code" value="" class="form-control" placeholder="${verify_enterCode}" />
                    </div>
                    <button type="submit" class="btn btn-success btn-block">${verify_submit}</button>
                </form>
                <p class="text-left"><a href="#">${verify_notCome}</a></p>
            </div>

        </div>
    </div>
</div>
</body>
</html>
