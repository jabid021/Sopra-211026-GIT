<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalogue</title>

</head>
<body>

</head>



  <body>
  <div id="corps">
    <h1>Les offres imbattables du moment :</h1>



  <div class="album py-5 bg-light">
          <div class="container">

            <div class="row">
             
             <c:forEach items="${planetes}" var="p">
             
             
             <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                  <img class="card-img-top"
								data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail"
								alt="Thumbnail [100%x225]" style="display: block;"
								src="img/catalogue/${p.img}" data-holder-rendered="true">
                  <div class="card-body">
                    <p class="card-text">${p.nom}, ${p.description}</p>
                    <div
									class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                        <button type="button"
											class="btn btn-sm btn-outline-secondary">Voir les voyages disponibles</button>
                      </div>
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
             
             
             </c:forEach>
            
        </div>




</div>
</body>


</html>