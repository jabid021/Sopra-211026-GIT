<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <style media="screen">


      body {
        margin: 0;
        height: 100vh;
      }

      main {
        width: 100%;
        height:100%;
        display: flex;
        position: relative;
        justify-content: center;
        align-items: center;
      }

      .connect {
        margin: auto;
        padding: 5px;
        position: absolute;
        background-color: silver;
        border: solid darkblue 10px;
        border-radius: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      td {
        padding: 10px;
      }

      .finTab {
        display: flex;
        justify-content: space-around;
        align-items: center;
      }

    </style>
  </head>
  <body>
    <header>

    </header>

    <main class="container">
      <div class="connect">
        <form action="inscription" method="post">
          <table>
            <tbody>
              <tr>
                <td>Prénom:</td>
                <td><input type="text" name="prenom" value=""></td>
              </tr>
              <tr>
                <td>Nom: </td>
                <td><input type="text" name="nom" value=""></td>
              </tr>
              <tr>
                <td>Identifiant:</td>
                <td><input type="text" name="id" value=""></td>
              </tr>
              <tr>
                <td>Mot de passe: </td>
                <td><input type="password" name="mdp" value=""></td>
              </tr>
            </tbody>
          </table>
          <br>
          <div class="finTab">
            <input class="btn btn-success" value="Créer le compte" type="submit">
            <input class="btn btn-danger" value="Annuler" type="reset">
            <a href="home">Accueil</a>
          </div>
          <br>
        </form>

      </div>
    </main>

    <footer>

    </footer>

  </body>
</html>