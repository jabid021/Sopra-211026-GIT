<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
  <style>
      body{background-color:lightgrey;}

      content{
        display:flex;
        margin-left : 30px;
      }

      #div1{

        background-color:white;
        border : solid black 2px;
        width : 40%;
        justify-content: flex-end;
        align-content: flex-start;
        padding : 10px;

      }

      #div2{

        background-color:white;
        border : solid black 2px;
        width : 40%;
        justify-content: flex-start;
        align-items: flex-start;
        padding : 10px;
        margin-left :30px;
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
	<button type="button" class="btn btn-success">Ajouter</button>
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

	<h2>Modifier/Ajouter vaisseau</h2>
	<content>
	<div id="div1">
	<fieldset>
		<legend>Update vaisseau</legend>
		<form action="vaisseau" method="post">
		
			<input type="hidden" name="tache" value="update">
			<input name="id" id="idVaisseau" type="hidden">
			Nom : <input name="Nom" placeholder="Nom" type="text"><br>
			<br> Vitesse : <input name="Vitesse" type="text"
				placeholder="Vitesse"><br>
			<br> Capacité : <input name="Capacite" placeholder="CapacitÃ©"
				type="text"><br>
			<br> Distance : <input name="Distance" placeholder="Distance"
				type="text"><br>
			<br> 
			<input class="btn btn-success" type="submit" name="modif"
				value="Modifier un vaisseau" id="buttonFormulaire">
			</form>
		</fieldset>
	</div>

	<div id="div2">
	<fieldset>
		<legend>Ajouter vaisseau</legend>
		<form action="vaisseau" method="post">
		<input type="hidden" name="tache" value="insert">
			Nom : <input name="Nom" placeholder="Nom" type="text"><br>
			<br> Vitesse : <input name="Vitesse" type="text"
				placeholder="Vitesse"><br>
			<br> Capacité : <input name="Capacite" placeholder="CapacitÃ©"
				type="text"><br>
			<br> Distance : <input name="Distance" placeholder="Distance"
				type="text"><br>
			<br> ID : <input type="text" name="ID"
				placeholder="ID vaisseau Ã  ajouter"><br>
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
	nom.value=prenomUpdate;
	
}

</script>