<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>HOME PAGE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.button {
	background-color: rgb(21, 2, 65);
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>



	<div class="container"></div>
	<nav class="navbar navbar-expand-sm bg-light">

		<!-- Links -->


		<ul class="navbar-nav">
			<li class="nav-item"><img src="images/logo.jpg" width="100"
				height="60"></li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/new_account">CREATE
					NEW ACCOUNT</a></li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/withdrawPage">WITHDRAWALS</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/depositPage">DEPOSITS</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/fundsPage">FUNDS</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/cbPage">CHECK
					BALANCE</a></li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/dadPage">DISPLAY
					ACCOUNT DETAILS</a></li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/deletePage">DELETE
					ACCOUNT</a></li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/updatePage">UPDATE
					BANK DETAILS</a></li>
			<li class="nav-item"><a class="nav-link" href="/spring-bankapp-mvc/app/bank/searchAccountPage">SEARCH
					ACCOUNT </a></li>
		</ul>

	</nav>
	<br>
	<br>

	<CENTER>
		<h1>
			<font color="PURPLE">WELCOME TO MUMBAI BANK</font>
		</h1>
	</CENTER>
	<br>
	<br>
	<br>
	<br>
	<br>

	<center>
		<a href="login1.jsp" class="button"> LOGIN</a>
	</center>


</body>
</html>




