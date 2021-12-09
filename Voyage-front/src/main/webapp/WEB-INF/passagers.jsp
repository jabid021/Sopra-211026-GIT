<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Partie Passager</h1>

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

<input id="btnAdd" class="btn btn-success" type="button" name="add" value="Ajouter">

<table class="table table-striped" border>
	<tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Prenom</th>
		<th>Client</th>
		<th>Action</th>
	</tr>
	<tbody>
		<c:forEach items="${passagers}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nom}</td>
				<td>${p.prenom}</td>
				<td>${p.client.nom} (${p.client.id})</td>
				<td><input onclick="updatePassager(${p.id},'${p.nom}','${p.prenom}','${p.client.id}')" type="button"
					class="btn btn-warning" value="Modifier"> <input
					type="button" class="btn btn-danger" value="Supprimer"></td>
			</tr>

		</c:forEach>

	</tbody>
</table>


<div id="formAjout">
	<fieldset>
		<legend>&nbsp;Formulaire Ajout&nbsp;</legend>
		Infos passager <br>
		<form action="passagers" method="post">
			<input type="hidden" name="tache" value="insert">
			Nom : <input name="nom" required placeholder="saisir le nom"
				type="text"><br>
			Prenom : <input name="prenom" required placeholder="saisir le prenom"
				type="text"><br>
			Client : <select name="client">
						<c:forEach items="${comptes}" var="compte">
						<option value="${compte.id}">${compte.login}</option>
						</c:forEach>
					</select>
			
			<input class="btn btn-success" type="submit" name="add"
				value="Ajouter un passager" id="buttonFormulaire">
			</form>

	</fieldset>
</div>


<div id="formUpdate">
	<fieldset>
		<legend>&nbsp;Formulaire Update&nbsp;</legend>
		Infos passager <br>
		<form action="passagers" method="post">
			
			<input type="hidden" name="tache" value="insert">
			<input name="id" id="idPassager" type="hidden">
			Nom : <input id="nom" name="nom" required placeholder="saisir le nom"
				type="text"><br>
			Prenom : <input id="prenom" name="prenom" required placeholder="saisir le prenom"
				type="text"><br>
			Client : <select id="client" name="client">
						<option>Choisir un compte	</option>
						<c:forEach items="${comptes}" var="compte">
						
						<option value="${compte.id}">${compte.login}</option>
						</c:forEach>
					</select>
			
			<input class="btn btn-success" type="submit" name="add"
				value="Modifier un Passager" id="buttonFormulaire">
			</form>

	</fieldset>
</div>


<script>

btnAdd.onclick=ajouterPassager;

function ajouterPassager()
{
	formAjout.style.display="block";
	formUpdate.style.display="none";
}

function updatePassager(idUpdate,nomUpdate,prenomUpdate,idClient)
{
	formAjout.style.display="none";
	formUpdate.style.display="block";
	nom.value=nomUpdate;
	idPassager.value=idUpdate;
	prenom.value=prenomUpdate;
}


</script>