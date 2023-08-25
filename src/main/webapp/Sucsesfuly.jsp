<%--
  Created by IntelliJ IDEA.
  User: sardo
  Date: 23.08.2023
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sucsesfuly</title>
</head>
<body>
<h1>sucsesfuly</h1>
</body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successfully</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #336699;
            text-align: center;
            margin-top: 100px;
        }
    </style>
</head>
<body>
<h1>Successfully</h1>
<form action="${pageContext.request.contextPath}/MainMenu">
    <button>MAIN</button>
    <input type="hidden" name="userId" value="${userId}">
</form>

</body>
</html>
