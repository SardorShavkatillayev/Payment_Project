<%--
  Created by IntelliJ IDEA.
  User: sardor
  Date: 23.08.2023
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Card</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add-card" method="post">
    <label>
        card-Number
        <input type="text" name="card-Number">
    </label>
    <br>
    <label>
        password
        <input type="password" name="password">
    </label>
    <input type="hidden" name="cardId" value="${cardId}">
    <input type="hidden" name="userId" value="${userId}">

    <button type="submit">Submit</button>
</form>

</body>
</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Card</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/add-card" method="post">
    <label for="cardNumber">Card Number</label>
    <input type="text" id="cardNumber" name="card-Number">

    <label for="password">Password</label>
    <input type="password" id="password" name="password">

    <input type="hidden" name="cardId" value="${cardId}">
    <input type="hidden" name="userId" value="${userId}">

    <button type="submit">Submit</button>
</form>
</body>
</html>

