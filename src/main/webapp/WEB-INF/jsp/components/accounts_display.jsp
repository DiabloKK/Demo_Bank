<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container d-flex">
    <button
            id="add-account-btn"
            class="btn btn-primary btn-lg shadow"
            type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasRight"
            aria-controls="offcanvasRight"
    >
        <i class="fa fa-credit-card"></i> Add New Account
    </button>
    <button
            id="transact-btn"
            class="btn btn-primary btn-lg ms-auto shadow"
            type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasExample"
            aria-controls="offcanvasExample"
    >
        <i class="fa fa-wallet"></i> Transact
    </button>
</div>

<div class="container d-flex py-3">
    <h2 class="me-auto">Total Accounts Balance:</h2>
    <h2 class="ms-auto">
        <c:if test="${requestScope.totalBalance != null}">
            <c:out value="${totalBalance}"/>
        </c:if>
    </h2>
</div>

<div class="container">
    <c:if test="${requestScope.userAccounts != null}">
        <c:forEach items="${requestScope.userAccounts}" var="account">
            <div class="accordion accordion-flush" id="accordionFlushExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="flush-headingOne">
                        <button
                                class="accordion-button collapsed"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseOne"
                                aria-expanded="false"
                                aria-controls="flush-collapseOne"
                        >
                            ${account.accountName}
                        </button>
                    </h2>
                    <div
                            id="flush-collapseOne"
                            class="accordion-collapse collapse"
                            aria-labelledby="flush-headingOne"
                            data-bs-parent="#accordionFlushExample"
                    >
                        <div class="accordion-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex">Account Name <span class="ms-auto"><b>${account.accountName}</b></span></li>
                                <li class="list-group-item d-flex">Account Number <span class="ms-auto"><b>${account.accountNumber}</b></span></li>
                                <li class="list-group-item d-flex">Account Type <span class="ms-auto"><b>${account.accountType}</b></span></li>
                                <li class="list-group-item d-flex">Account Balance <span class="ms-auto"><b>${account.balance}</b></span></li>
                                <li class="list-group-item d-flex">Create at <span class="ms-auto"><b>${account.createAt}</b></span></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </c:forEach>
    </c:if>
</div>