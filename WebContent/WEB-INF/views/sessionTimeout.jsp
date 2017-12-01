<html>
<head>
<title>Login</title>
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
	width: 40%;
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
		<article>
			<p align="center"><b><font color="red">${errorMessage}</font></b></p><br/>
			<form action="loginVerify" method="post" >
				<table>
					<tr>
						<td>User Name     :</td>
						<td><input type="text" name="userName"/></td>
					</tr>
					<tr>
						<td>Password      :</td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td align="center"><input type="submit" name="Login" value="Login"/> </td>     
						<td align="left"><b><a href="register">Sign up</a></b></td>
					</tr>
				</table>
			</form>
		</article>
		<footer>Designed by Abhishek Kotalwar</footer>
	</div>
	</body>
</html>