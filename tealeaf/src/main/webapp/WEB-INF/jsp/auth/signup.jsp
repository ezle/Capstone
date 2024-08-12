<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />



<section class="vh-100 bg-image"
         style="background-image: url('https://i.pinimg.com/564x/74/bc/f0/74bcf0e38d3926a5e8af165e7bb7bd62.jpg'); background-repeat: repeat;"> <!-- Background Image for registration -->
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                            <form action="/account/sign-up" id="signup-form" method="post">

<%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
<%--                                    <input type="text" id="form3Example1cg" class="form-control form-control-lg" />--%>
<%--                                    <label class="form-label" for="form3Example1cg">Your Name</label>--%>
<%--                                </div>--%>

                                <div class="form-outline mb-4">
                                    <input type="email" id="email" name="email" value="${form.email}" class="form-control form-control-lg <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>" />
                                    <label class="form-label" for="email">Your Email</label>
                                    <c:if test="${bindingResult.hasFieldErrors('email')}">
                                        <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                            <div class="text-danger">${error.defaultMessage}</div>
                                        </c:forEach>
                                    </c:if>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="password" name="password" value="${form.password}" class= "form-control form-control-lg <c:if test="${bindingResult.hasFieldErrors('password')}">is-invalid</c:if>"/>
                                    <label class="form-label" for="password">Password</label>
                                    <c:if test="${bindingResult.hasFieldErrors('password')}">
                                        <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                                            <div class="text-danger">${error.defaultMessage}</div>
                                        </c:forEach>
                                    </c:if>
                                </div>

<%--                                <div data-mdb-input-init class="form-outline mb-4">--%>
<%--                                    <input type="password" id="form3Example4cdg" class="form-control form-control-lg" />--%>
<%--                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>--%>
<%--                                </div>--%>

<%--                                <div class="form-check d-flex justify-content-center mb-5">--%>
<%--                                    <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />--%>
<%--                                    <label class="form-check-label" for="form2Example3cg">--%>
<%--                                        I agree to the <a href="#!" class="text-body"><u>Terms of service</u></a>--%>
<%--                                    </label>--%>
<%--                                </div>--%>

                                <div class="d-flex justify-content-center">
                                    <button  type="submit"
                                              class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Already have an account? <a href="/login"
                                                                                                        class="fw-bold text-body"><u>Login here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>