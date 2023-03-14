<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="card no-accounts-card">
        <div class="card-body">
            <h1 class="card-title">
                <i class="fa fa-ban text-danger"></i> NO Registered
                Accounts
            </h1>
            <hr />
            <div class="car-text">
                You currently do not have any registered accounts.
                <br />
                Please click below to register / add a new account.
            </div>
            <br>
            <button
                    class="btn btn-primary btn-lg shadow"
                    type="button"
                    data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasRight"
                    aria-controls="offcanvasRight"
            >
                <i class="fa fa-credit-card"></i> Add New Account
            </button>
        </div>
    </div>
</div>
