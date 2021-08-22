<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des super pouvoirs</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp"%>
	<h1>Liste de super pouvoir</h1>

	<c:forEach var="superpower" items="${ lstSuperPower }">
		<div>
			<form action="/superpower/delete" method="POST" )>
				<p>${ superpower.name }
					<input type="hidden" name="id" value="${ superpower.id }" />
					<input type="submit" value="X" />
				</p>
			</form>
		</div>
	</c:forEach>
</body>
</html>