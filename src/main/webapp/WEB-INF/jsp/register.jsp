<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/default.css">
    <script
            src="https://kit.fontawesome.com/26f8ebd080.js"
            crossorigin="anonymous"
    ></script>
    <title>Register</title>
</head>
<body class="d-flex align-items-center justify-content-center">
<div class="card registration-form-card col-6 bg-transparent border-0">
    <div class="card-body">
        <h1 class="form-header card-title mb-3">
            <i class="fa fa-edit"></i> Register
        </h1>

        <c:if test="${requestScope.passwordMisMatch != null}">
            <div class="alert alert-danger text-center border border-danger">
                <b>${requestScope.passwordMisMatch}</b>
            </div>
        </c:if>

        <c:if test="${requestScope.success != null}">
            <div class="alert alert-success text-center border border-success">
                <b>${requestScope.success}</b>
            </div>
        </c:if>

        <%--@elvariable id="registerUser" type=""--%>
        <form:form action="/register" class="reg-form" modelAttribute="registerUser">
            <div class="row">
                <div class="form-group col">
                    <form:input type="text" path="first_name" class="form-control form-control-lg" placeholder="Enter First Name" />
                    <form:errors path="first_name" class="text-white bg-danger" />
                </div>
                <div class="form-group col">
                    <form:input type="text" path="last_name" class="form-control form-control-lg" placeholder="Enter Last Name" />
                    <form:errors path="last_name" class="text-white bg-danger" />
                </div>
            </div>
            <div class="form-group col">
                <form:input type="email" path="email" class="form-control form-control-lg" placeholder="Enter Email" />
                <form:errors path="email" class="text-white bg-danger" />
            </div>
            <div class="row">
                <div class="form-group col">
                    <form:input type="password" path="password" class="form-control form-control-lg" placeholder="Enter Password" />
                    <form:errors path="password" class="text-white bg-danger" />
                </div>
                <div class="form-group col">
                    <input type="password" name="confirm_password" class="form-control form-control-lg" placeholder="Confirm Password">
                    <small class="text-white bg-danger">${confirm_pass}</small>
                </div>
            </div>
            <div class="form-group col">
                <button class="btn btn-lg">Register</button>
            </div>
            <p class="card-text text-white my-2">
                Already have an account?
                <span class="ms-2"><a href="/login" class="btn btn-sm text-warning">Sign In</a></span>
            </p>
            <small class="text-warning d-flex align-items-center">
                <i class="fa fa-arrow-alt-circle-left"></i>
                <a href="/" class="btn btn-sm text-warning">Back</a>
            </small>
        </form:form>
    </div>
</div>
</body>
</html>