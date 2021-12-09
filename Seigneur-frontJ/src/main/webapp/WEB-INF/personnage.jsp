<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${connected}</title>
</head>
<body>



<p>${monPerso.nom},${monPerso.race},${monPerso.monture.nom},${monPerso.arme.nom}</p>

<h1>Ajout d'un personnage</h1>

<form method="get">
Nom : <input name="nom" type="text"><br>
PV : <input name="pv" min="1" type="number"><br>
Race : <select name="race">
			<option>Nain</option>
			<option>Elfe</option>
			<option>Orc</option>
			<option>Humain</option>
		</select><br>
Vivant : <input name="vivant" type="checkbox"><br>
<input type="date" name="date"> 
<input type="time" name="time"> 
<input type="submit" value="Creer">


</form>

</body>
</html>


<script>

</script>
