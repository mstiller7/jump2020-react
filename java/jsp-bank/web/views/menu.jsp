<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 8/19/2020
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div>
	<label for="transactions">Choose an operation:</label>
	<select name="transactions" id="transactions">
		<option value="deposit">Deposit</option>
		<option value="withdraw">Withdraw</option>
		<option value="transfer">Transfer</option>
	</select>
</div>


</body>
</html>
