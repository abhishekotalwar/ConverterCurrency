<html>
<head>
<title>Login</title>
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
    			<li><b><a href="register">Sign up</a></b></li>
  			</ul>
		</nav>
		
		<article>
			<p align="center"><b><font color="green">${message}</font></b></p>
			<form action="loginVerify" method="post" >
				<table>
					<tr>
						<td width="20">User Name     :</td>
						<td width="30"><input type="text" name="userName"/></td>
					</tr>
					<tr>
						<td width="20">Password      :</td>
						<td width="30"><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td align="right"><input type="submit" name="Login" value="Login"/> </td>     
						<td> </td>
					</tr>
				</table>
			</form>
		</article>
		<footer>Designed by Abhishek Kotalwar</footer>
	</div>
	</body>
</html>