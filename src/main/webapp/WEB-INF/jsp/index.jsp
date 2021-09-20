<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Welcome message</title>
</head>
<body>
<html:form action="/welcome/hello/page" method="get">
    <input type="text" class="form-control" id="user"
           name="user" required>
    <input type="text" class="form-control" id="welcomeMessage"
           name="welcomeMessage" required>
    <button type="submit" class="btn btn-primary" >submit</button>
</html:form>
</body>
</html>