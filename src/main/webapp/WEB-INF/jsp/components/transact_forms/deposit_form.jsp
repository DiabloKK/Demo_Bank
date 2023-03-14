<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card deposit-card">
    <div class="card-body text-bg-light">
        <form action="/transact/deposit" method="post" class="deposit-form">
            <div class="form-group mb-2">
                <label for=""> Enter Deposit Amount</label>
                <input type="text" name="deposit_amount" class="form-control" placeholder="Enter Deposit Amount">
            </div>

            <div class="form-group mb-3">
                <label for="">Select Account</label>
                <select name="account_id" class="form-control">
                    <option value="">-- Select Account --</option>
                    <c:if test="${userAccounts != null}">
                        <c:forEach items="${userAccounts}" var="selectAccount">
                            <option value="${selectAccount.accountId}">${selectAccount.accountName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>

            <div class="form-group mb-2">
                <button class="transact-btn btn btn-md">Deposit</button>
            </div>
        </form>
    </div>
</div>
