<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<div class="d-flex flex-column align-items-center">
<h1>cart</h1>
<%--Show all product and quantity from order with status of cart--%>


<table class="table table-hover" style="width:600px;">
    <thead>
    <tr>
        <th scope="col">Product</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Total</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderDetails}" var="orderDetail">
        <tr>
            <td>${orderDetail.product.name}</td>
            <td>${orderDetail.product.price}</td>
            <td>${orderDetail.quantity}</td>
            <td>${orderDetail.product.price*orderDetail.quantity}</td>
            <td><a href="/removeFromCart?orderDetailId=${orderDetail.id}&orderId=${orderDetail.orderId}" class="btn btn-danger">X</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</div>

<jsp:include page="../include/footer.jsp"/>