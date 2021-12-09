<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Partie Trajet</h1>

<head>

<style>

#formUpdate,#formAjout
{
	display:none;
}
body {
	background-color: #F4EFE7;
}

fieldset {
	width: 100%;
}

div {
	display: flex;
	background-color: white;
	width: 30%;
	border: 2px solid black;
	margin: 10px;
	margin-left: 35%;
	padding: 30px;
	box-shadow: 0 0 20px 0 rgb(0 0 0/ 20%), 0 5px 5px 0 rgb(0 0 0/ 24%);
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

<input id="btnMod" class="btn btn-success" type="button" name="add" value="Modifier">

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
				<td>${ft.id}</td>
				<td>${ft.depart.nom}</td>
				<td>${ft.arrivee.nom}</td>
				<td>${ft.dateDepart}</td>
				<td>${ft.heureDepart}</td>
				<td>${ft.vaisseau.nom}</td>
				<!-- <td>${p.client.nom} (${p.client.id})</td> -->
				<td><input onclick="updateFicheTrajet() type="button"
					class="btn btn-warning" value="Modifier"> <input
					type="button" class="btn btn-danger" value="Supprimer"></td>
			</tr>

	</tbody>
</table>

<!--  
<div id="formUpdate">
	<fieldset>
		<legend>&nbsp;Formulaire Update&nbsp;</legend>
		Infos trajet <br>
		<form action="ficheTrajet" method="post">
			<input type="hidden" name="tache" value="insert">
			Planète de départ : 
					<select name="planeteDep">
						<c:forEach items="${planetes}" var="planete">
						<option value="${planeteDep.id}">${planete.nom}</option>
						</c:forEach>
					</select>
			
			Planète d'arrivée : 
					<select name="planeteArrivee">
						<c:forEach items="${planetes}" var="planete">
						<option value="${planeteAr.id}">${planete.nom}</option>
						</c:forEach>
					</select>
					
			Date de départ : <input name="dateDep" required 
				type="date"><br>
					
					
			Heure de départ : <input name="heureDep" required 
				type="time"><br>
				
			Nom du vaisseau : 
					<select name="nomVaisseau">
						<c:forEach items="${vaisseaux}" var="vaisseau">
						<option value="${vaisseau.id}">${vaisseau.nom}</option>
						</c:forEach>
					</select>
			
			  <input class="btn btn-success" type="submit" name="add"
				value="Ajouter un passager" id="buttonFormulaire">
				
				<input class="btn btn-success" type="submit" name="add"
				value="Modifier un Trajet" id="buttonFormulaire">
			</form>

	</fieldset>
</div>
-->

<script>

btnMod.onclick=updateTrajet;


function updateTrajet(idUpdate,idPlaneteDep,idPlaneteArr,dateDep,heureDep,nomVaisseau)
{
	//formAjout.style.display="none";
	//formUpdate.style.display="block";
	//nom.value=nomUpdate;
	idTrajet.value=idUpdate;
	planeteDep.value=idPlaneteDep;
	planeteAr.value=idPlaneteArr;
	planeteDep.value=idPlaneteDep;
	
	
	
}


</script>