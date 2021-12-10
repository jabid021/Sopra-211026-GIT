<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style media="screen">
  #formUpdate,#formAjout
{
	display:none;
    background-color:white;
    width:30%;
    border:2px solid black;
    margin:10px;
    margin-left:35%;

    padding: 30px;
    box-shadow: 0 0 20px 0 rgb(0 0 0 / 20%), 0 5px 5px 0 rgb(0 0 0 / 24%);
}
  body{background-color:#F4EFE7!important;}
header {
	display: flex;
	justify-content: center;
}

#title {
	display: flex;
	width: 100%;
	height: auto;
	background-color: #5A9599;
	justify-content: center;
	align-items: center;
	margin: 0px;
	border: solid black 5px;
}

#imgLogo {
	display: flex;
}

#logo {
	display: flex;
	justify-content: center;
	background-color: #FF6F00;
	border: solid black 5px;
}

#txtTitle {
	font-size: auto;
	line-height: 100%;
	font-family: Prompt, monospace;
}

#connection {
	display: flex;
	background-color: #FF6F00;
	border: solid black 5px;
}

.btnC {
	background-color: silver;
	padding: 3px;
	margin: 3px;
	border: solid black 1px;
	border-radius: 4px;
}

.padding-0 {
	margin-right: 0;
	margin-left: 0;
	padding-right: 0;
	padding-left: 0;
}

@media screen and (min-width: 320px) {
	#txtTitle {
		font-size: calc(22px + 38 * (( 100vw - 320px)/(1360- 320)));
	}
	#imgLogo {
		width: calc(100px + 38 * (( 100vw - 320px)/(1360- 320)));
	}
	#connection {
		justify-content: space-around;
		align-items: center;
		flex-direction: row;
		border-top: none;
	}
	#logo {
		border-bottom: none;
	}
}

@media screen and (min-width: 768px) {
	#connection {
		justify-content: center;
		align-items: center;
		flex-direction: column;
		border-top: solid black 5px;
		border-left: none;
	}
	#logo {
		border-bottom: solid black 5px;
		border-right: none;
	}
}

@media screen and (min-width: 1400px) {
	#txtTitle {
		font-size: 60px;
	}
	#imgLogo {
		width: 160px;
	}
}
</style>
<head>
<meta charset="utf-8">
<link
	href="https://fonts.googleapis.com/css2?family=Prompt:ital,wght@1,500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="icon" href="img/logo.png">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<header class="row no-gutters">
	<div class="col-12 col-md-2" id="logo">
		<a href="home"><img id="imgLogo" src="img/logo.png" alt=""></a>
	</div>
	<div id="title" class="col-md-8 d-none d-md-flex">
		<span id="txtTitle">Notre équipage est <br>remplaçable,
			vous non!
		</span>
	</div>
	<div class="col-12 col-md-2 no-gutters" id="connection">
		<c:if test="${isConnected==null}">

			<div class="row no-gutters btnC" id="connect">
				<a href="connexion.jsp">Se connecter</a>
			</div>
			<div class="row no-gutters btnC" id="nvCompte">
				<a href="inscription">Créer un compte</a>
			</div>

		</c:if>

		<c:if test="${isConnected=='y'}"><div class="row no-gutters btnC" id="deConnect">
				<a href="deconnection">Se déconnecter</a>
			</div></c:if>

	</div>
</header>