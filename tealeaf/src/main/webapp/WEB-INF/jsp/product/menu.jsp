<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <%-- Needed for things like if and forEach--%>
<jsp:include page="../include/header.jsp"/>
<H1>menu</H1>

<form action="/search" method="post">
    <input type="text" name="searchTerm"/>
    <button type="submit">Search</button>
</form>
<section class = "container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-md-4 mb-4">
                <div class="card" style="width: 18rem;">
                    <c:if test="${empty product.imageUrl}">
                        <img src="https://teakandthyme.com/wp-content/uploads/2023/05/honeydew-bubble-tea-DSC_2635-1x1-1200.jpg" class="card-img-top" alt="...">

                    </c:if>
                    <c:if test="${not empty product.imageUrl}">
                        <img src="${product.imageUrl}" class="card-img-top" alt="...">
                    </c:if>

                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.description}</p>
                        <p class="card-text">Price: $${df.format(product.price)}</p>
                        <a href="/product/${product.id}" class="btn btn-primary">View Details</a>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>