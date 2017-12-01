<html>
<head>
<title>Registration</title>
<style>
div.container {
    width: 100%;
    border: 1px solid gray;
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
	width: 50%;
	margin-left:320px;
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
    			<li><b><a href="login">Sign In</a></b></li>
  			</ul>
		</nav>
		
		<article>
			<p align="center"><font size="5" color="black">Registration</font></p>
			<form action="registrationVerify" method="post" >
				<table>
					<tr>
						<td width="20">User Name*          :</td>
						<td width="30"><input type="text" name="userName"/>  <font color="red">${errorMessage.duplicateUser}</font></td>
					</tr>
					<tr>
						<td width="20">Password*           :</td>
						<td width="30"><input type="password" name="password"/>  <font color="red">${errorMessage.passowrdNotmatch}</font></td>					
					</tr>
					<tr>
						<td width="20">Re-Enter Password*  :</td>
						<td width="30"><input type="password" name="reEnterPassword"/>  <font color="red">${errorMessage.passowrdNotmatch}</font></td>					
					</tr>
					<tr>
						<td width="20">First Name*         :</td>
						<td width="30"><input type="text" name="firstName"/></td>
					</tr>
					<tr>
						<td width="20">Last Name*          :</td>
						<td width="30"><input type="text" name="lastName"/></td>
					</tr>
					<tr>
						<td width="20">Email*              :</td>
						<td width="30"><input type="text" name="email"/>  <font color="red">${errorMessage.emailExist}</font></td>						
					</tr>
					<tr>
						<td align="right" width="20"><input type="submit" name="register" value="Register"/></td>
						<td> </td>
					</tr>
				</table>
			</form>
		</article>
		<footer>Designed by Abhishek Kotalwar</footer>
	</div>
	</body>
</html>