<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div
        class="offcanvas offcanvas-start"
        tabindex="-1"
        id="offcanvasExample"
        aria-labelledby="offcanvasExampleLabel"
>
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">
            Transact
        </h5>
        <button
                type="button"
                class="btn-close"
                data-bs-dismiss="offcanvas"
                aria-label="Close"
        ></button>
    </div>
    <div class="offcanvas-body">
        <small class="card-text">
            Choose an option below to perform a transaction
        </small>
        <select name="transact-type" class="form-control text-bg-info my-3" id="transact-type">
            <option value="">--Select Transaction Type--</option>
            <option value="payment">Payment</option>
            <option value="transfer">Transfer</option>
            <option value="deposit">Deposit</option>
            <option value="withdraw">Withdraw</option>
        </select>

        <c:import url="components/transact_forms/payment_form.jsp"/>
        <c:import url="components/transact_forms/transfer_form.jsp"/>
        <c:import url="components/transact_forms/deposit_form.jsp"/>
        <c:import url="components/transact_forms/withdraw_form.jsp"/>

    </div>
</div>