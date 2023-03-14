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
    <title>Login</title>
</head>
<body class="d-flex align-items-center justify-content-center">
<div class="card login-form-card col-4 bg-transparent border-0">
    <div class="card-body">
        <h1 class="form-header card-title mb-3">
            <i class="fa fa-user-circle"></i> Login
        </h1>

        <c:if test="${requestScope.success != null}">
            <div class="alert alert-success text-center border border-success">
                <b>${requestScope.success}</b>
            </div>
        </c:if>

        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger text-center border border-danger">
                <b>${requestScope.error}</b>
            </div>
        </c:if>

        <c:if test="${requestScope.logged_out != null}">
            <div class="alert alert-info text-center border border-info">
                <b>${logged_out}</b>
            </div>
        </c:if>

        <form action="/login" class="login-form" method="post">
            <div class="form-group col">
                <input type="email" name="email" class="form-control form-control-lg" placeholder="Enter Email">
            </div>
            <div class="form-group col">
                <input type="password" name="password" class="form-control form-control-lg" placeholder="Enter Password">
            </div>

            <div class="form-group col">
                <input type="hidden" name="_token" value="${token}">
            </div>

            <div class="form-group col">
                <button class="btn btn-lg">Login</button>
            </div>
            <p class="card-text text-white my-2">
                Dont have an account?
                <span class="ms-2"><a href="/register" class="btn btn-sm text-warning">Sign Up</a></span>
            </p>
            <small class="text-warning d-flex align-items-center">
                <i class="fa fa-arrow-alt-circle-left"></i>
                <a href="/" class="btn btn-sm text-warning">Back</a>
            </small>
        </form>
    </div>
</div>
</body>
</html>