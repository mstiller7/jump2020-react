<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 8/18/2020
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/w3.css">
	<title>DollarsBank // Sign Up</title>
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
	<h1>DollarsBank Account Creation</h1>
</div>

<form method="post">
	<label>Name:
		<input type="text" name="name"><br/>
	</label>
	
	<label>Password:
		<input type="password" name="pw"><br/>
	</label>
	<button type="submit">Submit</button>
</form>
<div>
	<button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
