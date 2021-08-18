<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer un Super Héros</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp" %>
	<h1>Nouveau super héros</h1>
	<form action="/createPost" method="post">
	<p>
		<label for="nickname">Surnom du super héros</label> <input type="text"
			id="nickname" name="nickname" />
	</p>
	<p>
		<label for="superpower">Super pouvoir</label> <input type="text"
			id="superpower" name="superpower" />
	</p>
	<p>
		<label for="firstname">Prénom du super héros</label> <input type="text"
			id="firstname" name="firstname" />
	</p>
	<p>
		<label for="lastname">Nom du super héros</label> <input type="text"
			id="lastname" name="lastname" />
	</p>
	<p>
		<label for="category">Category</label>
		<select name="category" id="category">
			<c:forEach var="cat" items="${ categoryEnum }">
				<option value="${cat}">${cat.message }</option>
			</c:forEach>			
		</select>
	</p>
	 <input type="submit" value="Enregistrer" />
	</form>
</body>
</html>