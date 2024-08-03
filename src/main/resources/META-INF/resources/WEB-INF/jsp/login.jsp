<!DOCTYPE html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Login Page </title>
<c:url value="/css/login.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}" /> 
</head>  
<body>  
    <center> <h1> Welcome </h1> </center> 
    <center> <h1> Please Fill In Below Details  </h1> </center> 
    <form method="post">
        <div class="container"> 
            <label>First Name : </label> 
            <input type="text" placeholder="Enter First Name" name="firstName" required>
            <label>Last Name : </label> 
            <input type="text" placeholder="Enter Last Name" name="lastName" required>
            <label>Email: </label> 
            <input type="email" placeholder="Enter Email" name="email" required>
            <label>Password: </label> 
            <input type="password" placeholder="Enter Password" name="password" required>
            <button type="submit" >Sign Up</a></button> 
            <pre>${errorMessage}</pre> 
        </div> 
    </form>    
</body>   
</html>

 
