<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<h1>Partie planete</h1>

<head>

  <style>
 

  fieldset
  {
    width:100%;
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

<input id="btnAdd" class ="btn btn-success"type="button" name="add" value="Ajouter">

<table class="table table-striped" border>
	<tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Coordonnees(x,y,z)</th>
		<th>Type</th>
		<th>Description</th>
		<th>Image</th>
		<th>Actions</th>
	</tr>
	<tbody>
		<c:forEach items="${planetes}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nom}</td>
				<td>${p.coordonnees.x},${p.coordonnees.y},${p.coordonnees.z}</td>
				<td>${p.type}</td>
				<td>
					<c:choose>
						<c:when test="${p.description==null}">Pas de description</c:when>
						<c:otherwise>${p.description}</c:otherwise>
					</c:choose>
				</td>
				
				<td>
					<c:choose>
						<c:when test="${p.img==null}">Pas d'image</c:when>
						<c:otherwise><img width="50" src="/img/catalogue/${p.img}"></c:otherwise>
					</c:choose>
				</td>
				<td><input
					onclick="updatePlanete(${p.id},'${p.nom}','${p.coordonnees.x}','${p.coordonnees.y}','${p.coordonnees.z}','${p.description}','${p.img}')"
					type="button" class="btn btn-warning" value="Modifier"> <input
					type="button" class="btn btn-danger" value="Supprimer"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<div id="formAjout">
	<fieldset>
		<legend>&nbsp;Formulaire Ajout&nbsp;</legend>
		Caractéristiques de la planète : <br>
		<br>
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
				<option value="Tellurique">Tellurique</option>
				<option value="Gazeuse">Gazeuse</option>
			</select><br>
			Description : <textarea name="description" rows="2" cols="30"></textarea><br>
			Nom Image : <input name="image" type="text"><br>
			<br> <input class="btn btn-success" type="submit" name="add"
				value="Ajouter une planete" id="buttonFormulaire">
		</form>
	</fieldset>
</div>


<div id="formUpdate">
	<fieldset>
		<legend>&nbsp;Formulaire Update&nbsp;</legend>
		Caractéristiques de la planète à modifier :
		<form action="planetes" method="post">
		<input type="hidden" name="tache" value="update">
		<input name="id" id="idPlanete" type="hidden">
		 Nouveau Nom :
			<input id="nom" name="nom" required placeholder="saisir le nom" type="text"><br>
			<br> Nouvelles coordonnées : <br> Coordonnées X : <input
				name="x" id="x" required placeholder="saisir les coordonnees en X"
				type="number"><br> Coordonnées Y : <input id="y" name="y"
				required placeholder="saisir les coordonnees en Y" type="number"><br>
			Coordonnées Z : <input id="z" name="z" required
				placeholder="saisir les coordonnees en Z" type="number"><br>
			<br> Le type de la planète ? : <select name="type">
				<option value="Tellurique">Tellurique</option>
				<option value="Gazeuse">Gazeuse</option>
			</select><br> 
			Description : <textarea id="description" name="description" rows="2" cols="30"></textarea><br>
			Nom Image : <input id="image" name="image" type="text"><br>
			<br> <input class="btn btn-warning" type="submit"
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

function updatePlanete(idUpdate,nomUpdate,xUpdate,yUpdate,zUpdate,descriptionUpdate,imgUpdate)
{
	formAjout.style.display="none";
	formUpdate.style.display="block";
	idPlanete.value=idUpdate;
	nom.value=nomUpdate;
	x.value=xUpdate;
	y.value=yUpdate;
	z.value=zUpdate;

	description.value=descriptionUpdate;
	image.value=imgUpdate;
	
}


</script>
