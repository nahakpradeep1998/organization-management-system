<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<style>
.container {
	/*display: flex;*/
	margin-left: 500px;
	justify-content: center;
	height: 400px;
}
form {
	background-color: #f2f2f2;
	border-radius: 12px;
	text-align: center;
	width: 350px;
}
h2 {
	text-align: center;
}
input[type=text], input[type=password] {
	width: 260px;
	padding: 12px;
	margin: 8px;
	border: 2px solid #ccc;
	border-radius: 7px;
	font-size: 16px;
}
input[type=checkbox] {
	margin-top: 10px;
}
.registerbtn {
	background-color: #0fb00dea;
	color: white;
	padding: 14px;
	margin: 10px;
	border: none;
	border-radius: 7px;
	width: 290px;
	font-size: 16px;
}
.login {
	text-align: center;
}
a {
	color: #4839cf;
}
.msg {
	display: flex;
}
.register-div {
	display: flex !important;
    margin-top: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="msg">
			<c:if test="${errorMessage != null }">
				<p>${errorMessage }</p>
			</c:if>
		</div>
		<div class="register-div ">
			<form action="register" method="post">
				<h2>Register</h2>
				<div>
					<input type="text" placeholder="Organization Name" name="orgName"
						id="orgName" required> <input type="text"
						placeholder="Email" name="email" id="email" required> <input
						type="text" placeholder="Password" name="password" id="password"
						required><br> <input type="checkbox"> I agree
					to the Terms and Conditions<br>
					<button class="registerbtn">Register</button>
				</div>
				<div class="login">
					<p>
						Already have an account? <a href="loginPage.jsp">Login</a>.
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>