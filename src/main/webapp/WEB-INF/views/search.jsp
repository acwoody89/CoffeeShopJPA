<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>SEARCH RESULTS</h1>
	<table border="1">
		<c:forEach var="item" items="${person}">
			<tr>
				<!-- left out title on purpose -->
				<td>${item.itemName}</td>
				<td>${item.itemType}</td>
				<td>$${item.itemPrice}</td>
				<td>${item.itemQuant}</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>