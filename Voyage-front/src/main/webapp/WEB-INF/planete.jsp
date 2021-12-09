<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<h1>Partie planete</h1>

<head>
/*
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">


  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
*/

  <style>
  #formUpdate,#formAjout
{
	display:none;
}
  body{background-color:#F4EFE7;}

  fieldset
  {
    width:100%;
  }
  div
  {
    display:flex;
    background-color:white;
    width:30%;
    border:2px solid black;
    margin:10px;
    margin-left:35%;

    padding: 30px;
    box-shadow: 0 0 20px 0 rgb(0 0 0 / 20%), 0 5px 5px 0 rgb(0 0 0 / 24%);
  }

  #titre
  {
    display:flex;
  }
  table
  {
    text-align: center;
  }
  input[type=nom]
  {
    width:100%;

  }
  #buttonFormulaire
  {
  width:100%;
  }
  </style>

</head>

<input class ="btn btn-success"type="button" name="add" value="Ajouter">

<table class="table table-striped" border>
	<tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Coordonnees(x,y,z)</th>
		<th>Type</th>
		<th>Actions</th>
	</tr>
	<tbody>
		<c:forEach items="${planete}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nom}</td>
				<td>${p.coordonnees.x},${p.coordonnees.y},${p.coordonnees.z}</td>
				<td>${p.type}</td>
				<td><input
					onclick="updatePlanete(${p.id},'${p.nom}','${p.coordonnees.x}','${p.coordonnees.y}','${p.coordonnees.z}','${p.type}')"
					type="button" class="btn btn-warning" value="Modifier"> <input
					type="button" class="btn btn-danger" value="Supprimer"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<div id="formAjout">
	<fieldset>
		<legend>&nbsp;Formulaire Ajout&nbsp;</legend>
		Charactéristiques de la planète : <br>
		<br>
		<!--  ID : <input name="id" type="" value="1"><br><br> -->
		<form action="planetes" method="post">
			<input type="hidden" name="tache" value="insert">
			Nom : <input name="nom" required placeholder="saisir le nom"
				type="text"><br>
			<br> Coordonnées de la planète : <br> Coordonnées X : <input
				name="x" required placeholder="saisir les coordonnees en X"
				type="number"><br> Coordonnées Y : <input name="y"
				required placeholder="saisir les coordonnees en Y" type="number"><br>
			Coordonnées Z : <input name="z" required
				placeholder="saisir les coordonnees en Z" type="number"><br>
			<br> Le type de la planète ? : <select name="type">
				<option value="Choisir un type" selected>Choisir un type</option>
				<option value="Tellurique">Tellurique</option>
				<option value="Gazeuse">Gazeuse</option>
			</select><br>
			<br> <input class="btn btn-success" type="button" name="add"
				value="Ajouter une planete" id="buttonFormulaire">
		</form>
	</fieldset>
</div>


<div id="formUpdate">
	<fieldset>
		<legend>&nbsp;Formulaire Update&nbsp;</legend>
		Charactéristiques de la planète à modifier : <br> <br>
		<form action="planetes" method="post">
		<input type="hidden" name="tache" value="insert">
			Saisir l'ID de la planète à modifier : <input name="id" type="number"
				placeholder="saisir l'ID"><br> <br> Nouveau Nom :
			<input name="nom" required placeholder="saisir le nom" type="nom"><br>
			<br> Nouvelles coordonnées : <br> Coordonnées X : <input
				name="X" required placeholder="saisir les coordonnees en X"
				type="number"><br> Coordonnées Y : <input name="Y"
				required placeholder="saisir les coordonnees en Y" type="number"><br>
			Coordonnées Z : <input name="Z" required
				placeholder="saisir les coordonnees en Z" type="number"><br>
			<br> Le type de la planète ? : <select name="type">
				<option value="Choisir un type" selected>Choisir un type</option>
				<option value="Tellurique">Tellurique</option>
				<option value="Gazeuse">Gazeuse</option>
			</select><br> <br> <input class="btn btn-warning" type="button"
				value="Update la planete" id="buttonFormulaire">
		</form>
	</fieldset>
</div>

<script>

btnAdd.onclick=ajouterPlanete;

function ajouterPlanete()
{
	formAjout.style.display="block";
	formUpdate.style.display="none";
}

function updatePlanete(idUpdate,nomUpdate,xUpdate,yUpdate,zUpdate,typeUpdate)
{
	formAjout.style.display="none";
	formUpdate.style.display="block";
	nom.value=nomUpdate;
	x.value=idUpdate;
	y.value=idUpdate;
	z.value=idUpdate;
	type.value=typeUpdate;
	
}


</script>
