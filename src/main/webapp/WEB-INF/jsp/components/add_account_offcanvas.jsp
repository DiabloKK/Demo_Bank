<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div
        class="offcanvas offcanvas-end"
        tabindex="-1"
        id="offcanvasRight"
        aria-labelledby="offcanvasRightLabel"
>
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasRightLabel">
            Create / Add an Account
        </h5>
        <button
                type="button"
                class="btn-close"
                data-bs-dismiss="offcanvas"
                aria-label="Close"
        ></button>
    </div>
    <div class="offcanvas-body">
        <div class="card">
            <div class="card-body">
                <form action="/account/create_account" method="POST" class="add-account-form">
                    <div class="form-group mb-3">
                        <label for="">Enter Account Name</label>
                        <input type="text" name="account_name" class="form-control" placeholder="Enter Account name...">
                    </div>
                    <div class="form-group mb-3">
                        <label for="">Select Account Type</label>
                        <select name="account_type"  class="form-control">
                            <option value="">-- Select Account Type --</option>
                            <option value="check">Check</option>
                            <option value="savings">Saving</option>
                            <option value="business">Business</option>
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        <button type="submit" class="btn btn-md transact-btn">Add Account</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
