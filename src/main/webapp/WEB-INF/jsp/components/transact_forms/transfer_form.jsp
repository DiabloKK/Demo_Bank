<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card transfer-card">
    <div class="card-body text-bg-light">
        <form action="/transact/transfer" method="post" >

            <div class="form-group mb-3">
                <label for="">Select Account</label>
                <select name="transfer_from" class="form-control">
                    <option value="">-- Select Account From--</option>
                    <c:if test="${userAccounts != null}">
                        <c:forEach items="${userAccounts}" var="selectAccount">
                            <option value="${selectAccount.accountId}">${selectAccount.accountName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>

            <div class="form-group mb-3">
                <label for="">Select Account</label>
                <select name="transfer_to" class="form-control">
                    <option value="">-- Select Account To--</option>
                    <c:if test="${accounts != null}">
                        <c:forEach items="${accounts}" var="selectAccount">
                            <option value="${selectAccount.accountId}">${selectAccount.accountName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>

            <div class="form-group mb-2">
                <label for=""> Enter transfer Amount</label>
                <input type="text" name="transfer_amount" class="form-control" placeholder="Enter Transfer Amount">
            </div>

            <div class="form-group mb-2">
                <button class="transact-btn btn btn-md">Transfer</button>
            </div>

        </form>
    </div>
</div>