<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link rel="stylesheet" href="../css/main.css"/>
    <script
            src="https://kit.fontawesome.com/26f8ebd080.js"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"
    ></script>
    <title>Dashboard</title>
</head>
<body>
<c:import url="components/incl/header.jsp"/>

<div class="container">
    <div class="card">
        <div class="card-header">
            <i class="fa fa-credit-card me-2" aria-hidden="true"></i> Payment History
        </div>
        <div class="card-body">
            <c:if test="${payment_history != null}">
                <table class="table text-center table-striped">
                    <tr>
                        <th>Record Number</th>
                        <th>Beneficiary</th>
                        <th>Beneficiary Account Number</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Reference</th>
                        <th>Reason Code</th>
                        <th>Created at</th>
                    </tr>
                    <c:forEach items="${requestScope.payment_history}" var="payments">
                        <tr class="md-2">
                            <td>${payments.paymentId}</td>
                            <td>${payments.beneficiary}</td>
                            <td>${payments.beneficiaryAccNo}</td>
                            <td>${payments.amount}</td>
                            <td>${payments.status}</td>
                            <td>${payments.referenceNo}</td>
                            <td>${payments.reasonCode}</td>
                            <td>${payments.createAt}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>


<c:import url="components/incl/footer.jsp"/>