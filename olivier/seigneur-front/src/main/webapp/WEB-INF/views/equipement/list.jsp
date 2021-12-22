<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>liste des equipements</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>nom:</th>
					<th>date de creation</th>
					<th>att/def</th>
					<th>infos specifiques</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${equipements}" var="e">
					<tr>
						<td>${e.id}</td>
						<td>${e.nom}</td>
						<td>
						<fmt:parseDate value="${e.creation}" var="dateCreation" pattern="yyyy-MM-dd'T'HH:mm:ss"></fmt:parseDate>
						<fmt:formatDate value="${dateCreation}"
								pattern="'date creation:'dd/MM/yyyy', heure:'hh:mm" /></td>
						<td>${e.stats.attaque}/${e.stats.defense}</td>
						<td><c:if test="${e.getClass().name=='model.Arme'}">main:${e.hand}&nbsp;portée:${e.portee}</c:if>
							<c:if test="${e.getClass().name=='model.Armure'}">materiaux:${e.materiaux}</c:if>
							<c:if test="${e.getClass().name=='model.Monture'}">type de monture:${e.type}</c:if>

						</td>
						<td><a href="${ctx}/equipement/edit?id=${e.id}"
							class="btn btn-outline-primary">editer</a></td>
						<td><a href="${ctx}/equipement/delete?id=${e.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${ctx}/equipement/add/arme" class="btn btn-link">ajouter
			une arme</a> <a href="${ctx}/equipement/add/armure" class="btn btn-link">ajouter
			une armure</a> <a href="${ctx}/equipement/add/monture"
			class="btn btn-link">ajouter une monture</a>
	</div>
</body>
</html>