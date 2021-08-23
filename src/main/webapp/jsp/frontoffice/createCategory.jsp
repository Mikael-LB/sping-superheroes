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
	<form:form action="/category/create" method="post"
		modelAttribute="categoryForm">
		<p>
			<form:label path="name">Category</form:label>
			<form:select path="name">
				<c:forEach var="cat" items="${ categoryList }">
					<form:option value="${cat}">${cat.name }</form:option>
				</c:forEach>
			</form:select>
		</p>
		<form:button>Enregistrer</form:button>
	</form:form>
</body>
</html>