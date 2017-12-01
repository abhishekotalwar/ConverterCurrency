<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "co" %>

<html>
<head>
<title>Currency Converter</title>
<style>
.error {
    color: #ff0000;
    font-size: 18px;
}

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

td {
	padding: 10px;
}
</style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  function disableDate() {
      if (document.getElementById("current").checked) {
    	  document.getElementById("dateValue").disabled = true;
      } else {
    	  document.getElementById("dateValue").disabled = false;
      }
 }
</script>
</head>
	<body>
	<div class="container">
		<header>
   			<h1>Currency Converter</h1>
		</header>
		<nav>
  			<ul>
  				<li><b><a href="showtransactionhistory">History</a></b></li>
  				<li><br/></li>    				
    			<li><b><a href="logout">Log out</a></b></li>
  			</ul>
		</nav>
		<article>
			<p style="float:right"><b> Hello, ${pageData.userName}</b></p><br/><br/><br/>
			<springForm:form commandName="currencyConvertData" action="currencyconverter" method="post">
				<table style="float:center;width: 50%;margin-left:290px;">
					<tr>
						<td width="20">Amount         :</td>
						<td width="30"><input type="number" name="amount"/>  <springForm:errors path="amount" cssClass="error" /></td>
					</tr>
					<tr>
						<td width="20">Source Currency     :</td>
						<td width="30"><select name="sourceCurrency" id="sourceCurrency">			    
   											<co:forEach items="${pageData.currencyList}" var="value">
       											<option value="${value.code}">${value.description}</option>
    										</co:forEach>
										</select>
						</td>
					</tr>
					<tr>
						<td width="20">Destination Currency   :</td>
						<td width="30"><select name="destinationCurrency" id="destinationCurrency">			    
   											<co:forEach items="${pageData.currencyList}" var="value">
       											<option value="${value.code}">${value.description}</option>
    										</co:forEach>
										</select>
						</td>
					</tr>
					<tr>
						<td width="20">Type           :</td>
						<td width="30"><input type="radio" name="type" id="current" value="current" onclick="disableDate();"> Current <input type="radio" name="type" id="history" value="history" onclick="disableDate();"> History  <springForm:errors path="type" cssClass="error" /></td>
					</tr>
					<tr>
						<td width="20">Date(yyyy-MM-dd)      : </td>
						<td width="30"><input type="text" id="dateValue" name="dateValue" disabled="disabled"/></td>
					</tr>
					<tr>
						<td align="right" width="20"><input type="submit" name="Submit" value="Submit"/></td>
						<td> </td>
					</tr>
				</table>
			</springForm:form>
		</article>
		<footer>Designed by Abhishek Kotalwar</footer>
	</div>
	</body>
</html>