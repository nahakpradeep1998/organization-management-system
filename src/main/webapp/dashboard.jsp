<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Screen</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
table {
	width: 100%;
	max-width: 800px;
	margin: 0 auto;
	font-size: 16px;
}
th, td {
	padding: 10px;
	text-align: left;
	border: 1px solid #ccc;
}
thead {
	background-color: #f2f2f2;
}
tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}
tbody tr:hover {
	background-color: #e6f7ff;
	cursor: pointer;
}
.table-container {
	margin: 0 auto;
	max-width: 800px;
	position: relative;
}
.add-user-btn {
	padding: 10px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	margin-bottom: 10px;
}
.add-user-btn:hover {
	background-color: #3e8e41;
}
.logout-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	padding: 10px;
	background-color: #f20808;
	color: #fff;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	margin-bottom: 10px;
}
@media only screen and (max-width: 600px) {
	table {
		font-size: 14px;
	}
}
</style>
</head>
<body>
	<div class="table-container">
		<c:if test="${successMessage != null}">
			<p>${successMessage}</p>
		</c:if>
		<c:if test="${errorMessage != null}">
			<p>${errorMessage}</p>
		</c:if>
		<button onclick="window.location.href = 'registerUser.jsp'" class="add-user-btn">Add User</button>
		<button onclick="window.location.href = 'logoutServlet'" class="logout-btn">Logout</button>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Designation</th>
					<th>Date of Joining</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.phoneNo}</td>
						<td>${user.designation}</td>
						<td>${user.dateOfJoin}</td>
						<td>
							<a href="editservlet?userId=${user.userId}"><i class="fa fa-edit"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="deleteservlet?userId=${user.userId}" onclick="return confirmDelete();"><i class="fa fa-trash"></i></a> 	 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		function confirmDelete() {
		    var result = confirm("Are you sure you want to delete this user?");
		    if (result) {
		        return true;
		    } else {
		        return false;
		    }
		}
	</script>
</body>
</html>