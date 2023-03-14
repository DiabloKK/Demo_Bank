<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card payment-card">
    <div class="card-body text-bg-light">
        <form action="/transact/payment" method="post">
            <div class="form-group mb-3">
                <label for=""> Account Holder / Beneficiary</label>
                <input type="text" name="beneficiary" class="form-control" placeholder="Enter Account holder / Beneficiary name">
            </div>

            <div class="form-group mb-3">
                <label for=""> Beneficiary Account Number</label>
                <input type="text" name="account_number" class="form-control" placeholder="Enter Beneficiary Account No">
            </div>

            <div class="form-group mb-3">
                <label for="">Select Account</label>
                <select name="account_id" class="form-control">
                    <option value="">-- Select Account From--</option>
                    <c:if test="${userAccounts != null}">
                        <c:forEach items="${userAccounts}" var="selectAccount">
                            <option value="${selectAccount.accountId}">${selectAccount.accountName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>

            <div class="form-group mb-3">
                <label for=""> Reference</label>
                <input type="text" name="reference" class="form-control" placeholder="Enter Reference">
            </div>

            <div class="form-group mb-2">
                <label for=""> Enter Payment Amount</label>
                <input type="text" name="payment_amount" class="form-control" placeholder="Enter Payment Amount">
            </div>

            <div class="form-group mb-2">
                <button class="transact-btn btn btn-md">Pay</button>
            </div>
        </form>
    </div>
</div>