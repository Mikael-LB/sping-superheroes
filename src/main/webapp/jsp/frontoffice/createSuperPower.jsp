<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp"%>
	<h1>Ajout de super pouvoir</h1>
	<form:form action="/superpower/add" method="POST"
	 modelAttribute="superPowerForm">
		<p>
			<form:label path="name">Nom du super pouvoir</form:label>
			<form:input type="text" path="name" />
		</p>
		<form:button>Enregistrer</form:button>
	</form:form>
</body>
</html>