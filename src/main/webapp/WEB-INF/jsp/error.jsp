<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&family=Roboto:wght@300&display=swap"
            rel="stylesheet"
    />
    <script
            src="https://kit.fontawesome.com/26f8ebd080.js"
            crossorigin="anonymous"
    ></script>
    <style>
        * {
            box-sizing: border-box;
            font-family: "Comfortaa", cursive;
        }
        body {
            height: 100vh;
            background-image: url("../images/main_bg.jpg");
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
        }
        .card {
            box-shadow: 0px 3px 6px rgb(0, 14, 53);
        }
        .card .card-text {
            font-size: 16px;
        }
    </style>
    <title>Errors</title>
</head>
<body class="d-flex align-items-center justify-content-center">
<div class="card col-4 alert alert-danger boder border-danger text-danger">
    <h3 class="card-title">
        <i class="fa fa-window-close me-2"></i>Errors:
    </h3>
    <hr />
    <div class="card-body">
        <p class="card-text">
            <c:if test="${requestScope.error != null}">
                <div class="alert alert-danger text-center border border-danger">
                    <b>${requestScope.error}</b>
                </div>
            </c:if>
        </p>
        <hr />
        <a href="/" class="btn btn-sm btn-danger">
            <i class="fa fa-arrow-alt-circle-left me-1"></i> Back
        </a>
    </div>
</div>
</body>
</html>
