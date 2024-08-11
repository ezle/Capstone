<jsp:include page="../include/header.jsp" />



<section class="vh-100 bg-image"
         style="background-image: url('https://i.pinimg.com/564x/74/bc/f0/74bcf0e38d3926a5e8af165e7bb7bd62.jpg'); background-repeat: repeat;"> <!-- Background Image for registration -->
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Login</h2>

                            <form action="/account/login" method="post">

                                <%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
                                <%--                                    <input type="text" id="form3Example1cg" class="form-control form-control-lg" />--%>
                                <%--                                    <label class="form-label" for="form3Example1cg">Your Name</label>--%>
                                <%--                                </div>--%>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="email" id="email" name="username" value="${form.email}" class="form-control form-control-lg" />
                                    <label class="form-label" for="email">Email</label>
                                </div>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="password" id="password" name="password" value="${form.password}" class= "form-control form-control-lg"/>
                                    <label class="form-label" for="password">Password</label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button  type="submit" data-mdb-button-init
                                             data-mdb-ripple-init class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Log In</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Don't have an Account? <a href="account/sign-up"
                                                                                                        class="fw-bold text-body"><u>Sign up here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>