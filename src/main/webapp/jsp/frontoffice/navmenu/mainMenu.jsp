<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglibprefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<script type="text/javascript" src="/js/script.js"></script>
</head>
<body>
	<nav>
		<button id="nav-accueil">
			<a href="/">
				<spring:message code="navmenu.btnhomepage" text="default" />
			Accueil</a>
		</button>
		<button>
			<a href="/superheros/create">
				<spring:message code="navmenu.btnnewsuperheroe" text="default" />
			</a>
		</button>
		<button>
			<a href="/superheros/list/all">
				<spring:message code="navmenu.btnlistsuperheroes" text="default" />
			</a>
		</button>
		<button>
			<a href="/superpower/add">
				<spring:message code="navmenu.btnaddsuperpower" text="default" />
			</a>
		</button>
		<button>
			<a href="/superpower/list">
				<spring:message code="navmenu.btnlistsuperpower" text="default" />
			</a>
		</button>
		<button>
			<a href="/category/create">
				<spring:message code="navmenu.btnaddcategory" text="default" />
			</a>
		</button>
		<span><spring:message code="lang.change" text="default"/></span>:
		<select id="locales" onchange="handleChangeLanguageSelect(value)">
			<option value=""></option>
			<option value="en"><spring:message code="lang.eng" text="default"/></option>
			<option value="fr"><spring:message code="lang.fr" text="default"/></option>
		</select>
	</nav>
</body>
</html>