<%-- 
    Document   : adminpage
    Created on : Sep 18, 2021, 4:10:14 AM
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
        <h1>Admin Page</h1>

        <font>
        Welcome, ${sessionScope.USERID}, ${sessionScope.FULLNAME}
        </font>


        <form action="MainController">
            <input type="submit" value="Log Out" name="btAction" />
        </form>

        <form action="MainController">                          
            Search Cake <input type="text" name="txtSearchValue" 
                               value="${param.txtSearchValue}"/> <br/>
            Price : From : <input type="number" name="txtPriceFrom" min="0" value="${param.txtPriceFrom}" />
            To: <input type="number" name="txtPriceTo" min="0" value="${param.txtPriceTo}" />

            Search Option <select name="searchOption">
                <option>--Chose--Option--</option>
                <option>Search By Name</option>
                <option>Search by Price</option>
                <option>Category</option>
            </select> </br>

            <input type="submit" value="Search" name="btAction" />

            <a href="createNewCake.html">Click here to Create</a>
            
        </form>

        <c:set var ="option" value="${param.searchOption}"/>
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
                        <th>Status</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <c:forEach var="dto" items="${result}" varStatus="counter">
                    <tbody>
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.cakeID}
                                <input type="hidden" name="txtcakeID" value="${dto.cakeID}" />
                            </td>
                            <td>${dto.cakeName}
                                <input type="hidden" name="cakeName" value="${dto.cakeName}" />
                            </td>
                            <td> <img src="${dto.image}" width="150" height="150">
                                <input type="hidden" name="image" value="${dto.image}" accept="image/png, image,jpeg"/>
                            </td>
                            <td>${dto.description}</td>
                            <td>${dto.price}
                                <input type="hidden" name="txtprice" value="${dto.price}" />
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
                                <input type="checkbox" name="chkAdmin" value="${dto.status}" 
                                       <c:if test="${dto.status}">
                                           checked="checked"
                                       </c:if>
                                       />
                            </td>
                            <td>
                                <input type="submit" value="Update" name="btAction" />
                                <input type="hidden" name="txtCakeID" value="${dto.cakeID}" />
                                <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                <input type="hidden" name="lastSearchOption" value="${option}" />
                                <input type="hidden" name="lastSearchPriceFrom" value="${param.txtPriceFrom}" />
                                <input type="hidden" name="lastSearchPriceTo" value="${param.txtPriceTo}" />
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
