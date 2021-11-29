<%-- 
    Document   : YellowMoonShop
    Created on : Sep 17, 2021, 8:47:14 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    <h1 style="color:Yellow;" >Yellow Moon Shop</h1>

</head>

<body>


    <form action="MainController">                              
        Search Cake: <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /><br/><br/>
        Price: From: <input type="number" name="txtPriceFrom" min="0" value="${param.txtPriceFrom}" /> 
        To: <input type="number" name="txtPriceTo" min="0" value="${param.txtPriceTo}" />

        Filter <select name="searchOption" >
            <c:set var="option" value="${param.searchOption}"/>
            <option>--Choose option--</option>
            <option <c:if test="${option == 'Product name' }" >selected</c:if> >Product name</option>
            <option <c:if test="${option == 'Price' }" >selected</c:if> >Price</option>
            <option <c:if test="${option == 'Category' }" >selected</c:if> >Category</option>
            </select><br/><br>
            <input type="submit" value="Search" name="btAction"/>
            <a href="viewcart.jsp">View Your Cart</a>

        </form> <br>


    <c:set var="option" value="${param.searchOption}"/>
    <c:set var ="searchValue" value="${param.txtSearchValue}"/>
    <c:set var ="result" value="${requestScope.RESULT}"/>

    <c:if test="${result != null}">

        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Create Date</th>
                    <th>Expiration Date</th>
                    <th>Category</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <c:forEach var="dto" items="${result}" varStatus="counter">
                <tbody>
                <form action="MainController" method="POST">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${dto.cakeID}
                            <input type="hidden" name="cakeID" value="${dto.cakeID}" />
                        </td>
                        <td>${dto.cakeName}
                            <input type="hidden" name="cakeName" value="${dto.cakeName}" />
                        </td>
                        <td> <img src="${dto.image}" width="150" height="150">
                            <input type="hidden" name="image" value="${dto.image}" accept="image/png, image,jpeg"/>
                        </td>
                        <td>${dto.description}</td>
                        <td>${dto.price}
                            <input type="hidden" name="price" value="${dto.price}" />
                        </td>
                        <td>${dto.createDate}</td>
                        <td>${dto.expirationDate}</td>
                        <td>${dto.category}
                            <input type="hidden" name="category" value="${dto.category}" />
                        </td>
                        <td>${dto.quantity}
                            <input type="hidden" name="quantity" value="${dto.quantity}" />
                        </td>
                        <td>
                            <input type="submit" value="Add To Cart" name="btAction" />
                            <input type="hidden" name="txtCakeID" value="${dto.cakeID}" />
                            <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                            <input type="hidden" name="lastSearchOption" value="${option}" />
                            <input type="hidden" name="lastSearchPriceFrom" value="${param.txtPriceFrom}" />
                            <input type="hidden" name="lastSearchPriceTo" value="${param.txtPriceTo}" />
                        </td>
                        </td>
                    </tr>
                </form>
            </tbody>
        </c:forEach>
    </table>


    <c:if test="${result == null}">
        <font color="red">
        <h2> No record found </h2>
        </font>
    </c:if>
</c:if>



</form> <br/>




</body>

</html>
