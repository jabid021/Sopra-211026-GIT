<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<title>lotr</title>
</head>
<body>
	<div class="container">
		<h1>edition equipement</h1>
		<c:if test="${equipement.getClass().name=='model.Arme'}">
			<c:url var="action" value="/equipement/save/arme"></c:url>
		</c:if>
		<c:if test="${equipement.getClass().name=='model.Armure'}">
			<c:url var="action" value="/equipement/save/armure"></c:url>
		</c:if>
		<c:if test="${equipement.getClass().name=='model.Monture'}">
			<c:url var="action" value="/equipement/save/monture"></c:url>
		</c:if>
		<form:form action="${action}" method="post"
			modelAttribute="equipement">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input cssClass="form-control" path="id" readonly="true"
					placeholder="generation automatique" />	
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input cssClass="form-control" path="nom" />
				<form:errors path="nom" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="stats.attaque">attaque:</form:label>
				<form:input cssClass="form-control" path="stats.attaque" />
				<form:errors path="stats.attaque" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="stats.defense">defense:</form:label>
				<form:input cssClass="form-control" path="stats.defense" />
				<form:errors path="stats.defense" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<c:if test="${equipement.getClass().name=='model.Arme'}">
				<div class="form-group">
					<form:label path="hand">nombre main:</form:label>
					<form:input cssClass="form-control" path="hand" />
					<form:errors cssClass="alert alert-danger" path="hand" element="div"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="portee">portee:</form:label>
					<form:input cssClass="form-control" path="portee" />
					<form:errors path="portee" cssClass="alert alert-danger" element="div"></form:errors>
				</div>
			</c:if>
			<c:if test="${equipement.getClass().name=='model.Armure'}">
				<div class="form-group">
					<form:label path="materiaux">materiaux:</form:label>
					<form:input cssClass="form-control" path="materiaux" />
					<form:errors path="materiaux" cssClass="alert alert-danger" element="div"></form:errors>
				</div>
			</c:if>
			<c:if test="${equipement.getClass().name=='model.Monture'}">
				<form:label path="type">monture:</form:label>
				<form:select cssClass="form-control"  path="type" items="${montures}"></form:select>
			</c:if>

			<div>
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/equipement" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>