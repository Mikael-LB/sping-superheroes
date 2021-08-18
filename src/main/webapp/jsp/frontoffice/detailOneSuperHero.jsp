<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail d'un super héros</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp"%>
	<h1>Détail du super héros</h1>
	<p>Surnom : ${ superHero.nickname }</p>
	<p>Super pouvoir : ${ superHero.superpower }</p>
	<p>Prénom : ${ superHero.firstname }</p>
	<p>Nom : ${ superHero.lastname }</p>
	<p>
		Age :
		<fmt:parseDate value="${ superHero.dateOfBirth }" pattern="yyyy-MM-dd"
			var="dateOfBirthParse" type="date" />
		<fmt:formatDate value="${ dateOfBirthParse }" pattern="dd-MM-yyyy" />
	</p>
	<p>Catégorie : ${ superHero.category.name }</p>
</body>
</html>