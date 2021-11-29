<%-- 
    Document   : viewcart
    Created on : Sep 21, 2021, 8:54:45 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>View Cart.jsp </h1>

        <c:if test="${sessionScope.USERID != null}">
            <font>
            Welcome, ${sessionScope.USERID}, ${sessionScope.FULLNAME}
            </font>
        </c:if>
        <form action="MainController">
            <c:if test="${sessionScope.USERID == null}">
                <a href="login.html">Click here to Login </a>
            </c:if> 
            <c:if test="${sessionScope.USERID != null}">
                <input type="submit" value="Log Out" name="btAction" />
            </c:if> 
        </form>

        <h2>Your Cart</h2>

        <c:set var="cart" value="${sessionScope.CART}" />
        <c:if test="${cart != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Cake Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    <c:set var="total" value="0"/>
                <form action="MainController">
                    <c:forEach var="cartCus" items="${cart.items}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${cartCus.key}
                                <input type="hidden" name="txtCakeID" value="${cartCus.key}" />
                            </td>
                            <td>${cartCus.value.cakeName}</td>
                            <td>
                                <form action="MainController">
                                    <input type="number" name="txtQuantity" value="${cartCus.value.quantity}" min="1" max="1000"/>
                                    <input type="hidden" name="txtQuantity" value="${cartCus.value.quantity}" min="1" max="1000"/>
                                    <input type="hidden" name="txtCakeID" value="${cartCus.key}" />
                                    <input type="submit" value="Update Quantity" name="btAction" />
                                </form>

                            </td>
                            <td>${cartCus.value.quantity * cartCus.value.price}
                                <input type="hidden" name="txtPrice" value="${cartCus.value.quantity * cartCus.value.price}" />
                                <c:set var="total" value="${total + cartCus.value.quantity * cartCus.value.price}" />
                            </td>
                            <td> 
                                <form action="MainController">
                                    <input type="hidden" name="txtQuantity" value="${cartCus.value.quantity}" min="1" max="1000"/>
                                    <input type="hidden" name="txtCakeID" value="${cartCus.key}" />
                                    <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" 
                                            onclick="return confirm('Do you want to Delete this product?')" name="btAction" value="Remove Items">
                                        Delete
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4">
                            <a href="search.jsp">Add more Cake To Cart </a>
                        </td>
                        <td colspan="2">
                            Total Price =  ${total}
                        </td>
                        <td>

                        </td>
                    </tr>
                    </tbody>
                </form>
            </table> <br/>
        </c:if>
        <c:if test="${cart == null}">
            <font color="red">
            <h2> Cart is empty</h2>
            </font>
        </c:if>

        <form action="MainController">

            Phone number <input type="text" name="txtPhoneNumber" value="" />
            Name <input type="text" name="txtName" value="" />
            Address <input type="text" name="txtAddress" value="" />

            <input type="submit" value="Order" name="btAction" />
        </form>



    </body>
</html>
