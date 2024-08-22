<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Add Fund</title>
<c:url value="/css/welcome.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}" />
</head>
<body>
	<form method="post">
        <div class="container"> 
            <label>Fund Name : </label> 
            <input type="text" placeholder="Enter Fund Name" name="fundName" required>
            <label>Rates : </label> 
            <input type="number" placeholder="Enter Rates" name="rates" required>
            <label>No of Years</label> 
            <input type="number" placeholder="Enter No of Years" name="years" required>
            <button type="submit" >Add Fund</button> 
            <pre>${errorMessage}</pre> 
        </div> 
    </form>
</body>
</html>