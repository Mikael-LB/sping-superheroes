<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail d'un super héros</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp" %>
	<h1>Détail du super héros</h1>
	<p>Surnom : ${ superHero.nickname }</p>
	<p>Super pouvoir : ${ superHero.superpower }</p>
	<p>Prénom : ${ superHero.firstname }</p>
	<p>Nom : ${ superHero.lastname }</p>
	<p>Catégorie : ${ superHero.category.name }</p>
</body>
</html>