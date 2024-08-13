<jsp:include page="../include/header.jsp"/>
<H1>product</H1>


<section class="container">
    <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
            <div class="col-md-4">

                <img src="${product.imageUrl}" class="img-fluid rounded-start" alt="...">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="card-text">Price: $${df.format(product.price)}</p>
                    <a href="/account/order/addToCart?productId=${product.id}" class="btn btn-primary">Add To Cart</a>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>