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
	<link rel="stylesheet" href="styles/w3.css">
	<title>DollarsBank // Sign Up</title>
</head>
<body>
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
