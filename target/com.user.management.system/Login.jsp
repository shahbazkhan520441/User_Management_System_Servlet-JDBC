<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User Details</title>
</head>
<body>
    <section>
        <h1>signin to your account</h1>
        <form action="login" method="get">
            <input type="text" name="userEmail" placeholder="Enter User Email" /><br>
            <br>
            <input type="text" name="userPassword" placeholder="Enter password" /><br>
            <br>
            <input type="submit" value="sign in" />
        </form>
        <br> <br>
        <h2>
            <a href="index.jsp">Back To Home Page</a>
        </h2>
    </section>
</body>
</html>
