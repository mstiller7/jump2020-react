<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 3/31/2020
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>First JSP Program!</title>
</head>

<body>
<p>Today's date is: </p>
<% out.println(new java.util.Date().toString()); %>
<%
    out.println("Print the numbers");
    for (int i = 0; i < 10; i++) {
        out.println("i " + i);
    }
%>
</body>

</html>