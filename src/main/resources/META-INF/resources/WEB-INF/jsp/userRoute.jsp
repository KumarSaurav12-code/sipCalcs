<!DOCTYPE html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> User Selection </title>
<c:url value="/css/login.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}" /> 
</head>  
<body>  
    <center> <h1> Welcome </h1> </center> 
    <center> <h1> Please Select </h1> </center> 
    <form>
        <div class="container"> 
            <button method="post"><a href="http://localhost:8080/signUp"> Sign Up</a></button>
            <button method="post"><a href="http://localhost:8080/signIn">Sign In</a></button>  
        </div> 
    </form>    
</body>   
</html>

 
