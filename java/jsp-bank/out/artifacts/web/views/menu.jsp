<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 8/19/2020
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/w3.css">
	<title>DollarsBank // Account Menu</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
	<h1>DollarsBank</h1>
	<h2>Account Menu</h2>
</div>
<div class="w3-container w3-center w3-padding-16">
	Welcome, ${requestScope.name}!
</div>
<div class="w3-center">
	<form method="post">
		<button type="submit" name="button" value="signout" class="w3-btn w3-pale-red w3-hover-red w3-round-large">
			Sign Out
		</button>
	</form>
</div>

<div>
	<form method="post">
		<label for="transactions">Choose an operation:</label>
		<select name="transaction" id="transactions">
			<option value="deposit">Deposit</option>
			<option value="withdraw">Withdraw</option>
			<%--		<option value="transfer">Transfer</option>--%>
		</select>
		<br/>
		<label>Amount (USD):
			<input type="number" name="amount"><br/>
		</label>
		<button type="submit" name="button" value="transaction" class="w3-btn w3-pale-blue w3-hover-blue w3-round-large">
			Confirm Transaction
		</button>
	</form>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-container w3-center w3-padding-16">
	Recent Transactions:
	<br/>
	<table>
		<c:forEach items="${requestScope.transactions}" var="t">
			<tr>
				<td>${t}</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>
