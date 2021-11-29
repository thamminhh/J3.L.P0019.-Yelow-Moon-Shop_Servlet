<%-- 
    Document   : createNewAccount
    Created on : Sep 17, 2021, 3:39:46 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Account JSP</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController" method="POST">
            Username* <input type="text" name="txtUserID" value="${param.txtUserID}" /> (4 - 20 chars)<br/>
            <c:set var="errors" value="${requestScope.INSERTERR}" />
            <c:if test="${not empty errors.userIDLengErr}">
                <font color="red"> ${errors.userIDLengErr} </font><br/>
            </c:if>
            <c:if test="${not empty errors.userIDIsExist}">
                <font color="red"> ${errors.userIDIsExist} </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value="${param.txtPassword}" />(8 - 30 chars)<br/>
            <c:set var="errors" value="${requestScope.INSERTERR}" />
            <c:if test="${not empty errors.passwordLengErr}">
                <font color="red"> ${errors.passwordLengErr} </font><br/>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="${param.txtConfirm}" /> <br/>
            <c:set var="errors" value="${requestScope.INSERTERR}" />
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red"> ${errors.confirmNotMatch} </font><br/>
            </c:if>
            Full name* <input type="text" name="txtFullname" value="${param.txtFullname}" />(8 - 50 chars)<br/>
            <c:set var="errors" value="${requestScope.INSERTERR}" />
            <c:if test="${not empty errors.fullnameLengErr}">
                <font color="red"> ${errors.fullnameLengErr} </font><br/>
            </c:if>
            Email* <input type="text" name="txtEmail" value="${param.txtEmail}" />(2 - 50 chars)<br/>
            <c:set var="errors" value="${requestScope.INSERTERR}" />
            <c:if test="${not empty errors.emailLengErr}">
                <font color="red"> ${errors.emailLengErr} </font><br/>
            </c:if>
            <input type="submit" value="Create new Account" name="btAction"/>
            <input type="submit" value="Reset" />

        </form> <br/>
    </body>
</html>
