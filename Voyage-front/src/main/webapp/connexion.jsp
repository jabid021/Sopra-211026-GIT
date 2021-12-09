<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%><style>
.image {
	height: 100%;
	background-image: url("img/background/2015-8-11_14-14-10-852.BMP");
}

.text-white

legend {
	color: white;
}

tr {
	color: white;
}

#error{color:red;font-size:25px;}
</style>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>





<body>

	<div class="image">
		<fieldset>
			<legend class="text-white">Bienvenue dans l'aventure ! </legend>
			<form action="home" method="post">
				<table>
					<tr>
						<td>Login * : <input name="login" required
							placeholder="Login" class="form-control"></td>
					</tr>

					<tr>
						<td >Mot de passe * : <input type="password"
							name="password" required placeholder="Mot de passe"
							class="form-control">
							<input type="submit" value="Se connecter">
							<div id="error">${error}</div>
						</td>
					</tr>

				</table>

			</form>
		</fieldset>


	</div>
</body>
</html>
