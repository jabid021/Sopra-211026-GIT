<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
  <style>
      body{background-color:lightgrey;}

      content{
        display:flex;
        margin-left : 30px;
      }

      

      /* Full-width inputs */
  input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
  }

  /* Set a style for all buttons */
  input[type=submit] {
      background-color: #53af57;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
  }
  input[type=submit]:hover {
      background-color: white;
      color: #53af57;
      border: 1px solid #53af57;
  }


#buttonFormulaire {
	width: 100%;
}


  </style>  


<head>

<title>Liste des vaisseaux</title>
</head>

<body>
	<button type="button" id="btnAdd" class="btn btn-success">Ajouter</button>
	<br>
	<br>
	<table class="table table-striped" border>

		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Vitesse</th>
			<th>Capacité</th>
			<th>Distance</th>
			<th>Action</th>
		</tr>

		<tbody>
		<c:forEach items="${vaisseau}" var="v">
			<tr>
				<th>${v.id}</th>
				<td>${v.nom} </td>
				<td>${v.vitesse}</td>
				<td>${v.capacite}</td>
				<td>${v.distance}</td>
				<td><button  onclick ="updateVaisseau(${v.id},'${v.nom}',${v.vitesse},${v.capacite},${v.distance})" type="button" class="btn btn-warning">Modifier</button>
					<button type="button" class="btn btn-danger">Supprimer</button></td>
			</tr>
			</c:forEach>

		</tbody>

	</table>

	<content>
	<div id="formUpdate">
	<fieldset>
		<legend>Update vaisseau</legend>
		<form action="vaisseau" method="post">
		
			<input type="hidden" name="tache" value="update">
			<input name="id" id="idVaisseau" type="hidden">
			Nom : <input id="nom" name="Nom" placeholder="Nom" type="text"><br>
			<br> Vitesse : <input step="0.1" id="vitesse" name="Vitesse" type="number"
				placeholder="Vitesse"><br>
			<br> Capacité : <input id="capacite" name="Capacite" placeholder="Capacite"
				type="number"><br>
			<br> Distance : <input step="0.1" id="distance" name="Distance" placeholder="Distance"
				type="number"><br>
			<br> 
			<input class="btn btn-success" type="submit" name="modif"
				value="Modifier un vaisseau" id="buttonFormulaire">
			</form>
		</fieldset>
	</div>

	<div id="formAjout">
	<fieldset>
		<legend>Ajouter vaisseau</legend>
		<form action="vaisseau" method="post">
		<input type="hidden" name="tache" value="insert">
			Nom : <input name="Nom" placeholder="Nom" type="text"><br>
			<br> Vitesse : <input step="0.1" name="Vitesse" type="number"
				placeholder="Vitesse"><br>
			<br> Capacité : <input name="Capacite" placeholder="Capacite"
				type="number"><br>
			<br> Distance : <input step="0.1" name="Distance" placeholder="Distance"
				type="number">
			<br>
			
			<input class="btn btn-success" type="submit" name="add"
				value="Ajouter un vaisseau" id="buttonFormulaire">
			</form>
		</fieldset>
	</div>
	</content>

	<!--  <div class="d-grid gap-2">
		<button class="btn btn-primary" type="button">Valider</button>
	</div>-->
</body>


<script>

btnAdd.onclick=ajouterVaisseau;

function ajouterVaisseau()
{
	formAjout.style.display="block";
	formUpdate.style.display="none";
}

function updateVaisseau(idUpdate,nomUpdate,viteUpdate,capaciteUpdate,distanceUpdate)
{
	formAjout.style.display="none";
	formUpdate.style.display="block";
	nom.value=nomUpdate;
	idVaisseau.value=idUpdate;
	vitesse.value=viteUpdate;
	capacite.value=capaciteUpdate;
	distance.value=distanceUpdate;
	
}

</script>