<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer une catégorie</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp"%>
	<h1>Nouvelle catégorie</h1>
	<p>
		Liste des catégories existantes : <select>
			<c:forEach var="cat" items="${ categoryList }">
				<option value="${cat.id}">${cat.name }</option>
			</c:forEach>
		</select>
	</p>

	<form:form action="/category/create" method="post"
		modelAttribute="categoryForm">
		<p>
			<form:label path="name">Nom de nouvelle catégorie</form:label>
			:
			<form:input path="name" />
		</p>
		<form:button>Enregistrer</form:button>
	</form:form>
</body>
</html>