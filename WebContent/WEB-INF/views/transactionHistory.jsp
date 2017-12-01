<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "co" %>
<html>
<head>
<title>Transaction History</title>
<style>
nav {
    float: left;
    width: 90px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}

div.container {
    width: 100%;
    border: 1px solid gray;
}

header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}

article {
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
	height:600px;
	align:center;
}

table {
	align:center;
	width: 80%;
	margin-left:120px;
}

td {
	padding: 10px;
}
</style>
</head>
	<body>
	<div class="container">
		<header>
   			<h1>Currency Converter</h1>
		</header>
		
		<nav>
  			<ul>
    			<li><b><a href="currencyconverterhome">Home</a></b></li>
  				<li><br/></li>      			
				<li><b><a href="logout">Log out</a></b></li>
  			</ul>
		</nav>
		
		<article>
			<p style="float:right"><b> Hello, ${pageData.userName}</b></p><br/><br/>
			<p align="center"><font size="5" color="black">Transaction History</font></p>
				<table border="1">
				<tr>
					<th align="center">Input Amount</th>
					<th align="center">Source Currency</th>
					<th align="center">Destination Currency</th>
					<th align="center">Converted Amount</th>
					<th align="center">Type</th>
					<th align="center">Date</th>																									
				</tr>
				<co:forEach begin="0" end="9" items="${pageData.historyList}" var="value">
					<tr>
       					<td align="center">${value.amount}</td>
      					<td align="center">${value.sourceCurrency}</td>
      					<td align="center">${value.destinationCurrency}</td>
      					<td align="center">${value.convertedAmount}</td>
      					<td align="center">${value.conversionType}</td>
      					<td align="center">${value.dateValue}</td>      					      					      					      					       					
					</tr>
				</co:forEach>
			</table>	
		</article>
		<footer>Designed by Abhishek Kotalwar</footer>
	</div>
	</body>
</html>