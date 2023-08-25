<%--
  Created by IntelliJ IDEA.
  User: sardo
  Date: 21.08.2023
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign In(Login)</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sign-in" method="post">
  <label> Username
    <input type="text" name="username" >
  </label>
  <br>
  <label> Password
    <input type="text" name="password" >
  </label>
  <br>
  <button>Submit</button>

</form>
</body>
</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign In (Login)</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 400px;
      margin: 50px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    input[type="text"] {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    button {
      display: inline-block;
      padding: 10px 20px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="container">
  <form action="${pageContext.request.contextPath}/sign-in" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">Password</label>
    <input type="password" id="password" name="password" required>
    <br>
    <button type="submit">Submit</button>
  </form>
</div>
</body>
</html>

