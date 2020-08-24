<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 8/18/2020
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/w3.css">
	<title>DollarsBank // Log In</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
	<h1>DollarsBank</h1>
	<h2>Log In</h2>
</div>

<form method="post" class="w3-container w3-center w3-padding-16">
	<label>Name:
		<br/><input type="text" name="name"><br/>
	</label>
	
	<label>Password:
		<br/><input type="password" name="pw"><br/>
	</label>
	<div class="w3-padding-24">
		<button class="w3-btn w3-light-green w3-hover-green w3-round-large" type="submit">Submit</button>
		<button class="w3-btn w3-pale-red w3-hover-red w3-round-large" type="button" onclick="location.href='/'">Cancel
		</button>
	</div>
</form>

</body>
</html>
