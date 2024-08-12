<jsp:include page="../include/header.jsp" />



<c:choose>
    <c:when test="${empty form.id}">
        <h1 class="page-title">Create Product</h1>
    </c:when>
    <c:otherwise>
        <h1 class="page-title">Edit Product</h1>
    </c:otherwise>
</c:choose>

<div class="container">
    <form action="/admin/create-product" method="post">
        <input type="hidden" name="id" value="${form.id}">

        <div class="row pt-5">
            <div class="col-6">
                <div class="mb-3">  <!-- Margin Bottom -->
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" value="${form.name}" id="name" >
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <div class="mb-3">  <!-- Margin Bottom -->
                    <label for="description" class="form-label">Description</label>
                    <input type="text" name="description" class="form-control" value="${form.description}" id="description">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <div class="mb-3">  <!-- Margin Bottom -->
                    <label for="price" class="form-label">Price</label>
                    <input type="text" name="price" class="form-control" value="${form.price}" id="price">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <div class="mb-3">  <!-- Margin Bottom -->
                    <label for="imageUrl" class="form-label">Image URL</label>
                    <input type="text" name="imageUrl"class="form-control" id="imageURL" value="${form.imageUrl}">
                </div>
            </div>
        </div>

        <div class="row pt-3">
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Save Product</button>
            </div>
        </div>

    </form>
</div>
</div>


<jsp:include page="../include/footer.jsp"/>