<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des héros</title>
</head>
<body>
	<%@include file="navmenu/mainMenu.jsp"%>
	<h1>Liste des super héros</h1>
	<table>
		<thead>
			<tr>
				<th>Surnom</th>
				<th>Super pouvoir</th>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Date naissance</th>
				<th>Categorie</th>
			</tr>
			<tr>
				<td>
					<button><a href="/superheros/list/sortByNicknameAsc">&#9652;</a></button> 
					<button><a href="/superheros/list/sortByNicknameDesc">&#9662;</a></button>
				</td>
				<td></td>
				<td>
					<button><a href="/superheros/list/sortByFirstnameAsc">&#9652;</a></button>
					<button><a href="/superheros/list/sortByFirstnameDesc">&#9662;</a></button>
				</td>
				<td>
					<button><a href="/superheros/list/sortByLastnameAsc">&#9652;</a></button>
					<button><a href="/superheros/list/sortByLastnameDesc">&#9662;</a></button>
				</td>
				<td></td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="superhero" items="${ listSuperHero }">
				<tr>
					<td>${ superhero.nickname }</td>
					<td>${ superhero.superpower.name }</td>
					<td>${ superhero.firstname }</td>
					<td>${ superhero.lastname }</td>
					<td>
						<fmt:parseDate value="${ superhero.dateOfBirth }"
							pattern="yyyy-MM-dd"
							 var="dateOfBirthParse"
							 type="date" />
						<fmt:formatDate	value="${ dateOfBirthParse }"
						 pattern="dd-MM-yyyy" />
					</td>
					<td>${ superhero.category.name }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>