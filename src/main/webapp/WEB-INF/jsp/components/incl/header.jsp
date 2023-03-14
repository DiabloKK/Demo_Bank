<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="main-page-header mb-3 bg-primary">
    <div class="container d-flex align-items-center">
        <div class="company-name">Easy-Way Bank</div>
        <nav class="navigation">
            <li><a href="/app/dashboard">Dashboard</a></li>
            <li><a href="/app/payment_history">Payment History</a></li>
            <li><a href="/app/transaction_history">Transaction History</a></li>
        </nav>
        <div class="display-name ms-auto text-white">
            <i class="fa fa-circle text-success me-2 shadow-sm"></i>
            Welcome : <span>${user.first_name} ${user.last_name}</span>
        </div>
        <a href="/logout" class="btn btn-sm text-white ms-2">
            <i class="fas fa-sign-out-alt me-2" aria-hidden="true"></i>
            Sign Out
        </a>
    </div>
</header>