<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User Details</title>
</head>
<body>
    <section>
        <h1>Add New User in Database</h1>
        <form action="addUser" method="post">
            <input type="number" name="userId" placeholder="Enter User ID" /><br>
            <br> 
            <input type="text" name="userName" placeholder="Enter UserName" /><br> 
            <br> 
            <input type="text" name="userEmail" placeholder="Enter UserEmail" /><br>
            <br>
            <br>
             <input type="text" name="userPassword" placeholder="Enter userPassword" /><br>
            <br>
            <br>
               <input type="text" name="reuserPassword" placeholder="ReEnter password" /><br>
            <br>
           <textarea name="userAddress" rows="5" placeholder="Enter user address ..."></textarea>
            <br> 
            <br> 
            <input type="submit" value="ADD USER" />
        </form>
        <br> <br>
        <h2>
            <a href="index.jsp">Home Page</a>
        </h2>
    </section>
</body>
</html>
