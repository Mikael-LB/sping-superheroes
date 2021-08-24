<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Créer un Super Héros</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp"%>
	<h1><spring:message code="superhero.create.h1" text="default" /></h1>
	<form:form action="/superheros/create" method="post"
		modelAttribute="superheroForm">
		<p>
			<form:label path="nickname">
				<spring:message code="superhero.create.nickname" text="default" />
			</form:label>
			<form:input type="text" path="nickname" />
			<form:errors path="nickname" cssClass="form-error-red" />
		</p>
		<p>
			<form:label path="superpower">
				<spring:message code="superhero.create.superpowername" text="default" />
			</form:label>
			<form:select path="superpower">
				<c:forEach var="spwr" items="${ superPowerList }">
					<form:option value="${spwr.id}">
						<spring:message code="${spwr.name }" text="default" />
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="superpower" cssClass="form-error-red" />
		</p>
		<p>
			<form:label path="firstname">
				<spring:message code="superhero.create.firstname" text="default" />
			</form:label>
			<form:input type="text" path="firstname" />
			<form:errors path="firstname" cssClass="form-error-red" />
		</p>
		<p>
			<form:label path="lastname">
				<spring:message code="superhero.create.lastname" text="default" />
			</form:label>
			<form:input type="text" path="lastname" />
			<form:errors path="lastname" cssClass="form-error-red" />
		</p>
		<p>
			<form:label path="dateOfBirth">
				<spring:message code="superhero.create.dateOfBirth" text="default" />
			</form:label>
			<form:input type="date" path="dateOfBirth" />
			<form:errors path="dateOfBirth" cssClass="form-error-red" />
		</p>
		<p>
			<form:label path="category">
				<spring:message code="superhero.create.category" text="default" />
			</form:label>
			<form:select path="category">
				<c:forEach var="cat" items="${ categoryList }">
					<form:option value="${cat.id}">
						<spring:message code="${cat.name }" text="default" />
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="category" cssClass="form-error-red" />
		</p>
		<form:button>
			<spring:message code="superhero.create.btnsave" text="default" />
		</form:button>
	</form:form>
</body>
</html>