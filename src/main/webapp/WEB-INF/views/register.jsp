<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet">
<link href="js/script.css" rel="stylesheet">
</head>
<body>
	<h1>Register Page</h1>
	<br>

	<!--  make the fields required,  -->
	<form action="username">
		<div id="box">
			First Name: <input type="text" name="firstName"> <br>
			Last Name: <input type="text" name="lastName"> <br>
			Email: <input type="text" name="email"> <br> Phone
			Number: <input type="text" name="phone"> <br>
			<div id="hidden">
				<!-- Password: <input type="text" name="password"> <br> -->
				Password: <input type="password" value="" id="myInput" name=password>

				<!-- An element to toggle between password visibility -->
				<input type="checkbox" onclick="myFunction()">Show Password
			</div>
		</div>
		<input type="submit" name="Submit"> <br>
	</form>


	<table border="1">
		<c:forEach var="cust" items="${regist}">
			<tr>
				<!-- left out title on purpose -->
				<td>${cust.id}</td>
				<td>${cust.firstName}</td>
				<td>${cust.lastName}</td>
				<td>${cust.email}</td>
				<td>${cust.phoneNum}</td>
				<td>${cust.password}</td>
				<!-- this is url encoding and allows us to pass some data into the link for our controller method  -->
				<td><a class="btn btn-light bnt-small"
					href="/cust/${cust.id}/update">Edit</a> <a
					class="btn btn-light bnt-small" href="/cust/${cust.id}/delete">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>


	<script src="js/script.js"></script>

</body>
</html>