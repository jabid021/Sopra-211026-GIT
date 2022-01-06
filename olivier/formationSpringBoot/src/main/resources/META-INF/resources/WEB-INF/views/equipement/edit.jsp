<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<form action="${action}" method="post">
			<div class="form-group">
				<label>id:</label> <input class="form-control" name="id"
					readonly="readonly" placeholder="generation automatique"
					value="${equipement.id}">
			</div>
			<div class="form-group">
				<label>nom:</label> <input class="form-control" name="nom"
					value="${equipement.nom}">
			</div>
			<div class="form-group">
				<label>attaque:</label> <input class="form-control"
					name="stats.attaque" value="${equipement.stats.attaque}">
			</div>
			<div class="form-group">
				<label>defense:</label> <input class="form-control"
					name="stats.defense" value="${equipement.stats.defense}">
			</div>
			<c:if test="${equipement.getClass().name=='model.Arme'}">
				<div class="form-group">
					<label>main:</label> <input class="form-control" name="hand"
						value="${equipement.hand}">
				</div>
				<div class="form-group">
					<label>portée:</label> <input class="form-control" name="portee"
						value="${equipement.portee}">
				</div>
			</c:if>
			<c:if test="${equipement.getClass().name=='model.Armure'}">
				<div class="form-group">
					<label>materiaux:</label> <input class="form-control"
						name="materiaux" value="${equipement.materiaux}">
				</div>
			</c:if>
			<c:if test="${equipement.getClass().name=='model.Monture'}">
				<label>monture:</label>
				<select class="form-control" name="type">
					<c:forEach items="${montures}" var="monture">
						<option value="${monture}">${monture}</option>
					</c:forEach>
				</select>
			</c:if>

			<div>
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/equipement" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>