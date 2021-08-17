<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des héros</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp" %>
	<h1>Liste des super héros</h1>
	<p>Surnom de super héros : ${ listSuperHero[0].nickname }</p>
	<p>Super pouvoir : ${ listSuperHero[0].superpower }</p>
</body>
</html>