<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
.container {
	display: flex;
	justify-content: center;
	height: 564px;
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
input[type="date"] {
  width: 260px;
	padding: 12px;
	margin: 8px;
	border: 2px solid #ccc;
	border-radius: 7px;
	font-size: 16px;
}

input[type="date"]::placeholder {
  color: #999;
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
			<c:if test="${errorMessage != null}">
				<p>${errorMessage}</p>
			</c:if>
		</div>
		<div class="register-div">
			<c:if test="${user != null}">
					<form action="updateservlet" method="post" >
			</c:if>
			<c:if test="${user == null}">
					<form action="registerservlet" method="post" >
			</c:if>
				<h2>Organization User</h2>			
				<input type="hidden" name="userId" value="${user.userId}"> 
				<input type="text" placeholder="First Name" name="fName" id="fName" value="${user.firstName}" required> 
				<input type="text" placeholder="Last Name" name="lName" id="lName" value="<c:out value='${user.lastName}'/>" required>  
				<input type="text" placeholder="Email" name="email" id="email" value="<c:out value='${user.email}'/>" required> 
				<input type="text" placeholder="Phone Number" name="phoneNo" id="phoneNo" value="<c:out value='${user.phoneNo}'/>" required>
				<input type="text" placeholder="Designation" name="designation" id="designation" value="<c:out value='${user.designation}'/>" required>
				<input type="date" placeholder="Date of Join" name="doj" id="doj" value="<c:out value='${user.dateOfJoin}'/>" required><br>
				<button type="submit" class="registerbtn">Register User</button>	
			</form>		
		</div>
	</div>
</body> 
</html>