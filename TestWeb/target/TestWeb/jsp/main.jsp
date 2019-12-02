<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 21.11.2019
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Welcome</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <%--<script src="js/JSTest.js" type="text/javascript"></script>--%>



    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
</head>
<body>
    <div>
        <form action="controller" name="form" id="form">
            <input type="button" value="Submit" id="testButton" class="btn btn-success btn-block" />
        </form>
    </div>

    <script>
        $('#testButton').click(function(){
            $('#form').submit();
            $('#verify').modal();
        });
    </script>

    <div class="modal fade" id="verify" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <p>lololo</p>
            </div>
        </div>
    </div>
</body>
</html>