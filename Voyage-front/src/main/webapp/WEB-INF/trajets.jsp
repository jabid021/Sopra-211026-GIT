<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Trajets</title>
</head>
<body>
	<h1>Liste des trajets</h1>
	<input class="btn btn-success" type="submit" name="" value="Ajouter"
		onclick="masquer_div('DisplayAjout');">

	<div class="container-fluid">


		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>id</th>
					<th>Planète de départ</th>
					<th>Planète d'arrivée</th>
					<th>Date de départ</th>
					<th>Heure de départ</th>
					<th>Nom du vaisseau</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${trajets}" var="t">
					<tr>
						<td>${t.id}</td>
						<td>${t.depart.nom}</td>
						<td>${t.arrivee.nom}</td>
						<td>${t.dateDepart}</td>
						<td>${t.heureDepart}</td>
						<td>${t.vaisseau.nom}</td>
						<td><a href="fiche_trajet.html?id=${t.id}"
							class="btn btn-warning" role="button">Voir Fiche</a> <input
							class="btn btn-danger" type="submit" name="" value="Supprimer"></td>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<div id="DisplayAjout" class="container-fluid addFormTrajet"
		style="display: none;">
		<h3>Ajouter nouveau Trajet</h3>
		<div id="BlocAjout" class="shadow p-3">

			<form id="FormGr" action="trajets" method="post">
				<label for="add_PlaneteDepart">Planète de départ :</label><br>
				<select class="form-control" name="planeteDepart">
						<c:forEach items="${planetes}" var="p">
						<option value="${p.id}">${p.nom}</option>
						</c:forEach>
						</select><br> 
				<label for="add_PlaneteArrivee">Planète d'arrivée :</label>
				<select class="form-control" name="planeteArrivee">
						<c:forEach items="${planetes}" var="p">
						<option value="${p.id}">${p.nom}</option>
						</c:forEach>
						</select><br>
				
				<label for="add_DateDepart">Date de départ :</label> <br> <input
					class="form-control" name="dateDepart" type="date" min="2000-01-01"><br>
				<label for="add_DateDepart">Heure de départ :</label><br> <input
					class="form-control" name="heureDepart" type="time" min="00:00"
					max="23:59"><br> 
					
				<label for="add_Vaisseau">Nom du vaisseau :</label><br> 
				
				<select class="form-control" name="vaisseau">
						<c:forEach items="${vaisseaux}" var="v">
						<option value="${v.id}">${v.nom}</option>
						</c:forEach>
						</select><br> 
						
						 <br>
				<input class="btn btn-success form-control" type="submit"
					name="add" value="Ajouter">
			</form>
		</div>
	</div>

</body>
</html>

<script type="text/javascript">
	function masquer_div(id) {
		if (document.getElementById(id).style.display == 'none') {
			document.getElementById(id).style.display = 'block';
		} else {
			document.getElementById(id).style.display = 'none';
		}
	}
</script>