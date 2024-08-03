<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Welcome Page</title>
<c:url value="/css/welcome.css" var="cssURL" />
<link rel="stylesheet" href="${cssURL}" />
</head>
<body>
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
	<h1>Welcome ${firstName} ${lastName}</h1>
	<ul>
		<li>Home</li>
		<li>Add Fund</li>
		<li>Remove Fund</li>
		<li style="float: right;"><a href="/">Logout</a></li>
	</ul>
	<div class="main">
		<div class="form1">
			<table>
				<tr>
					<th>Fund Name</th>
					<th>Month</th>
					<th>Rate</th>
				</tr>

				<c:forEach items="${fundDetails}" var="fund">
					<tr>
						<td>${fund.fund_Name}</td>
						<td>${fund.months}</td>
						<td>${fund.rate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="container1">
			<label>The Final Amount after 5 years:</label>
			<h1>${outputAmount}</h1>
			<div id="graph">
			<script>
				const xArray = [ "Interest", "Investment"];
				const yArray = [];
				yArray.push(${interest});
				yArray.push(${investmentAmount});
				const layout = {
					title : "Investment Breakup For Selected Fund",
					plot_bgcolor:"black",
					paper_bgcolor:"#FFF3"
				};

				const data = [ {
					labels : xArray,
					values : yArray,
					type : "pie"
				} ];

				Plotly.newPlot("graph", data, layout);
			</script>
			</div>
		</div>
		<div class="container">
			<h1>SIP Calculator</h1>
			<h1>Please Fill In Below Details:</h1>
			<form method="post">
				<div>
						<label>Fund Name From List</label> 
						<input type="text" placeholder="Enter Fund Name" name="fundName" required> 
						<label>SIP Amount</label> 
						<input type="text" placeholder="Enter SIP Amount" name="sipAmount" required>
					    <button type="submit">Procced</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>


