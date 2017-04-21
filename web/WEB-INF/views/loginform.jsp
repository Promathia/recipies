<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring 4 Example</title>
</head>
<body>

<h3>Login Form</h3>

<a>User Name="12" and password="12"</a>

<form:form action="loginform.html" commandName="loginForm">
    <table>
        <tr>
            <td>User Name:<form:errors path="login"/></td>
        </tr>
        <tr>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>Password:<form:errors path="password"/></td>
        </tr>
        <tr>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>