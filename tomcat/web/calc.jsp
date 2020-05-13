<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 3/31/2020
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<p>Enter values below and choose an operation: </p>

<form id="calculator" action="${pageContext.request.contextPath}/server-calculator" method="post">
    <p>
        <label for="first">Value 1</label>
        <input name="first" id="first"><br>
        <label for="second">Value 2</label>
        <input name="second" id="second"><br>
        <label for="operator">Operation</label>
        <select name="operator" id="operator">
            <option value="+">add</option>
            <option value="-">subtract</option>
            <option value="*">multiply</option>
            <option value="/">divide</option>
        </select><br>
        <input type="submit" value="Compute">
    </p>
</form>

</body>
</html>
