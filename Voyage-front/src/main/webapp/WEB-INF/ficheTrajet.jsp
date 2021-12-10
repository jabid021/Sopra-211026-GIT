<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Partie Trajet</h1>

<head>

<style>

fieldset {
	width: 100%;
}



#titre {
	display: flex;
}

table {
	text-align: center;
}

input[type=nom] {
	width: 100%;
}

#buttonFormulaire {
	width: 100%;
}
</style>

</head>

<a href="trajets"><input id="btnMod" class="btn btn-primary" type="button" name="add" value="Retour"></a>

<table class="table table-striped" border>
	<tr>
		<th>Id</th>
		<th>Planète de départ</th>
		<th>Planète d'arrivée</th>
		<th>Date de départ</th>
		<th>Heure de départ</th>
		<th>Nom du vaisseau</th>
		<th>Action</th>
	</tr>
	<tbody>
			<tr>
				<td>${trajet.id}</td>
				<td>${trajet.depart.nom}</td>
				<td>${trajet.arrivee.nom}</td>
				<td>${trajet.dateDepart}</td>
				<td>${trajet.heureDepart}</td>
				<td>${trajet.vaisseau.nom}</td>
				<td><input onclick="updateFicheTrajet()" type="button"
					class="btn btn-warning" value="Modifier"> <input
					type="button" class="btn btn-danger" value="Supprimer"></td>
			</tr>

	</tbody>
</table>

 
<div id="formUpdate">
	<fieldset>
		<legend>&nbsp;Formulaire Update&nbsp;</legend>
		Infos trajet <br>
		<form action="ficheTrajet" method="post">
			<input type="hidden" name="id" value="${trajet.id}">
			Planète de départ : 
					<select name="planeteDepart">
						<c:forEach items="${planetes}" var="planete">
						<c:choose>
							<c:when test="${planete.id==trajet.depart.id}">
								<option selected value="${planete.id}">${planete.nom}</option>
							</c:when>
							<c:otherwise>
								<option value="${planete.id}">${planete.nom}</option>
								</c:otherwise>
						</c:choose>
						
						</c:forEach>
					</select>
			
			Planète d'arrivée : 
					<select name="planeteArrivee">
						<c:forEach items="${planetes}" var="planete">
						<c:choose>
							<c:when test="${planete.id==trajet.arrivee.id}">
								<option selected value="${planete.id}">${planete.nom}</option>
							</c:when>
							<c:otherwise>
								<option value="${planete.id}">${planete.nom}</option>
								</c:otherwise>
						</c:choose>
						
						</c:forEach>
					</select>
					
			Date de départ : <input value="${trajet.dateDepart}" name="dateDepart" required 
				type="date"><br>
					
					
			Heure de départ : <input value="${trajet.heureDepart}" name="heureDepart" required 
				type="time"><br>
				
			Nom du vaisseau : 
					<select name="vaisseau">
						<c:forEach items="${vaisseaux}" var="vaisseau">
						<c:choose>
							<c:when test="${vaisseau.id==trajet.vaisseau.id}">
								<option selected value="${vaisseau.id}">${vaisseau.nom}</option>
							</c:when>
							<c:otherwise>
								<option value="${vaisseau.id}">${vaisseau.nom}</option>
								</c:otherwise>
						</c:choose>
						</c:forEach>
					</select>
			
				<input class="btn btn-success" type="submit" name="add"
				value="Modifier un Trajet" id="buttonFormulaire">
			</form>

	</fieldset>
</div>


<script>




function updateFicheTrajet()
{
	formUpdate.style.display="block";
	
}


</script>