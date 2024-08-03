<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Fund</title>
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