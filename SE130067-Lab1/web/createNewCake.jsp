<%-- 
    Document   : createNewCake
    Created on : Sep 19, 2021, 9:48:37 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Cake.jsp</h1>

        <form action = "MainController">

            CakeID * <input type="text" name="txtCakeID" value="${param.txtCakeID}" /> (4 to 20 chars) </br>
            <c:set var="errors" value="${requestScope.CREATEERR}" />
            <c:if test="${not empty errors.cakeIDLengErr}">
                <font color="red"> ${errors.cakeIDLengErr} </font><br/>
            </c:if>
            <c:if test="${not empty errors.cakeIDIsExist}">
                <font color="red"> ${errors.cakeIDIsExist} </font><br/>
            </c:if>
            Cake Name * <input type="text" name="txtCakeName" value="${param.txtCakeName}" /> (2 to 30 chars) </br>
            <c:set var="errors" value="${requestScope.CREATEERR}" />
            <c:if test="${not empty errors.cakeNameLengErr}">
                <font color="red"> ${errors.cakeNameLengErr} </font><br/>
            </c:if>
            Image <input type="text" name="txtImage" value="" /> (.jpg, .jpeg,...) </br>
            Description <input type="text" name="txtDescription" value="" /> </br>
            Price * <input type="text" name="txtPrice" value="${param.txtPrice}" /> (VND) </br>
            <c:set var="errors" value="${requestScope.CREATEERR}" />
            <c:if test="${not empty errors.priceErr}">
                <font color="red"> ${errors.priceErr} </font><br/>
            </c:if>
            Create Date * <input type="text" name="txtCreateDate" value="" /> (dd/MM/yyyy) </br>
            Expiration Date <input type="text" name="txtExpirationDate" value="" /> (dd/MM/yyyy) </br>
            Category <input type="text" name="txtCategory" value="" /> </br>
            Quantity <input type="text" name="txtQuantity" value="" /> (Must be number) </br>
            
            <input type="hidden" name="lastSearchValue" value="${param.lastSearchValue}" />
            <input type="hidden" name="lastSearchOption" value="${param.lastSearchOption}" />
            <input type="hidden" name="lastSearchPriceFrom" value="${param.lastSearchPriceFrom}" />
            <input type="hidden" name="lastSearchPriceTo" value="${param.lastSearchPriceTo}" />

            <input type="submit" value="Create" name="btAtion" /> 
            <input type="submit" value="Cancel" name="btAction" />

        </form>

    </body>
</html>
