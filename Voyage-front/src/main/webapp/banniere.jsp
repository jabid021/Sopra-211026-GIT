<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   
  <style media="screen">

      header {
        display: flex;
        margin-bottom:150px;
      }

      body {
        background-color: silver;
      }

      #logo {
        width: 20%;
        left: -25px;
        top: -20px;
        padding: 15px;
        position: absolute;
        border-radius: 8%;
        border: solid black 5px;
        background-color: #5A9599;
      }

      #title {
        display:flex;
        width: 100%;
        height: 200px;
        background-color: #FF6F00;
        justify-content: right;
        border: solid black 3px;
      }

      #txtTitle {
        font-size: 75px;
        line-height: 100%;
        font-family: Prompt, monospace;
        margin: 1% 25% 1% 1%;
      }

      #identity {
        width: 20%;
        right: -20px;
        top:0;
        height: 200px;
        position: absolute;
        border-radius: 20px;
        padding: 10px;
        background-color: #ADE2D0;
        border: solid black 3px;
      }

      li {
        list-style-type: none;
      }

    </style>
 
 <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
    crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
    crossorigin="anonymous"></script>
    
 	
 </head>
 
 <header>
      <a href="home"><div id="logo"><img src="img/logo.png" width=100% alt=""></div></a>
      <div id="title"><span id="txtTitle">Notre �quipage est <br>rempla�able, vous non!</span></div>
      <div id="identity">
        
        <c:if test="${isConnected!='y'}">
	         <ul>
	          <li id="connect"><a href="connexion.jsp">Se connecter</a></li>
	          <li id="nvCompte"><a href="creerCompte.html">Cr�er un compte</a></li>
	        </ul>
        </c:if>
        
        <c:if test="${isConnected=='y'}">Vous etes deja co</c:if>
       
      </div>
    </header>