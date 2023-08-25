<%--
<jsp:useBean id="userId" scope="request" type="java.util.UUID"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Menu </h1>


<form action="${pageContext.request.contextPath}/add-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Add Card</button>
</form>

<form action="${pageContext.request.contextPath}/get-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Get card</button>
</form>

<form action="${pageContext.request.contextPath}/delete-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>delete Card</button>
</form>
<form action="${pageContext.request.contextPath}/transaction-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Tranzaction</button>
</form>

</body>
</html>
--%>

<!DOCTYPE html>
<html>
<head>
    <style>
        /* Apply general styles to the body */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        /* Style the heading */
        h1 {
            text-align: center;
            margin-top: 20px;
        }

        /* Apply styles to the forms */
        form {
            text-align: center;
            margin: 20px auto;
        }

        /* Style the button */
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            font-size: 16px;
        }

        /* Adjust button appearance on hover */
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<jsp:useBean id="userId" scope="request" type="java.util.UUID"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Menu </h1>

<form action="${pageContext.request.contextPath}/add-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Add Card</button>
</form>

<form action="${pageContext.request.contextPath}/get-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Get card</button>
</form>

<form action="${pageContext.request.contextPath}/delete-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Delete Card</button>
</form>

<form action="${pageContext.request.contextPath}/transaction-card">
    <input type="hidden" name="userId" value="${userId}">
    <button>Transaction</button>
</form>

</body>
</html>

</body>
</html>

