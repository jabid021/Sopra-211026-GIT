<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>Trajets</title>
</head>
<body>
<h1>Liste des trajets</h1>
<input class="btn btn-success" type="submit" name="" value="Ajouter" onclick="masquer_div('DisplayAjout');">

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
  <tr>
    <td>1</td>
    <td>Terre</td>
    <td>Mars</td>
    <td>21-11-2020</td>
    <td>14h00</td>
    <td>Corvette</td>
    <td><a href="fiche_trajet.html?id=1" class="btn btn-warning" role="button">Voir Fiche</a>
    <input class="btn btn-danger" type="submit" name="" value="Supprimer"></td>
  </tr>
  <tr>
    <td>2</td>
    <td>Terre</td>
    <td>Jupiter</td>
    <td>21-11-2020</td>
    <td>14h00</td>
    <td>Corvette</td>
    <td><a href="fiche_trajet.html?id=1" class="btn btn-warning" role="button">Voir Fiche</a>
    <input class="btn btn-danger" type="submit" name="" value="Supprimer"></td>
  </tr>
  <tr>
    <td>3</td>
    <td>Terre</td>
    <td>Pluton</td>
    <td>21-11-2020</td>
    <td>14h00</td>
    <td>Corvette</td>
    <td><a href="fiche_trajet.html?id=1" class="btn btn-warning" role="button">Voir Fiche</a>
    <input class="btn btn-danger" type="submit" name="" value="Supprimer"></td>
  </tr>

</tbody>
</table>
</div>

<!--<th>id</th>
<th>Planète de départ</th>
<th>Planète d'arrivée</th>
<th>Date de départ</th>
<th>Heure de départ</th>
<th>Nom du vaisseau</th>
<th>Actions</th>*/-->
<div id="DisplayAjout" class="container-fluid addFormTrajet" style="display:none;">
<h3>Ajouter nouveau Trajet</h3>
<div id="BlocAjout" class="shadow">

       <form id="FormGr" action="gestionTrajet.html" method="get">
         <label for="add_PlaneteDepart">Planète de départ :</label> <br> <input class="form-control" required id="add_PlaneteDepart" name="Planete de depart" type="text" placeholder="Saisir la planète de depart"><br>
         <label for="add_PlaneteArrivee">Planète d'arrivée :</label> <br><input class="form-control" required id="add_PlaneteArrivee" name="Planete Arrivee" type="text" placeholder="Saisir la planète d'arrivee"><br>
         <label for="add_DateDepart">Date de départ :</label> <br><input class="form-control" name="DateDepart" type="date" min="2000-01-01"><br>
         <label for="add_DateDepart">Heure de départ :</label><br> <input class="form-control" name="HeureDepart" type="time" min="00:00" max="23:59"><br>
         <label for="add_Vaisseau">Nom du vaisseau :</label><br> <input class="form-control" required id="add_Vaisseau" name="Vaisseau" type="text" placeholder="Saisir le nom du vaisseau"><br>
         <br>
         <input class ="btn btn-success form-control" type="submit" name="ajouter" value="Ajouter">
       </form>
   </div>
</div>

</body>
</html>

<script type="text/javascript">
  function masquer_div(id)
{
  if (document.getElementById(id).style.display == 'none') {
       document.getElementById(id).style.display = 'block';
  }
  else {
       document.getElementById(id).style.display = 'none';
  }
}
</script>