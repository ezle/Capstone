<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<H1>Admin Product</H1>
<style>
    .admin-table{
        width: 100%;
        height: auto;
    }

    .col{
        width: 50px;
    }
    .col-description{
        width: 200px;
        text-wrap: pretty;
    }
    .col-img {
        width: 100px;
        overflow: hidden;
        text-wrap: pretty;
    }
</style>


<section class="container" style="background-color: lavenderblush">
    <table class="table admin-table" style="background-color: lightgoldenrodyellow";>
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col" style="background-color: ligh >Name</th>
            <th scope="col col-description">Description</th>
            <th scope="col">Price</th>
            <th scope="col col-img">Image URL</th>
        </tr>
        </thead>

        <tbody style="background-color: lightcyan";>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td> ${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.imageUrl}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<jsp:include page="../include/footer.jsp"/>