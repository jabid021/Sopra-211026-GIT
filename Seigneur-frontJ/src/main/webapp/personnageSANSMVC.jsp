<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.*" %>
<%@ page import="util.Context" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<%
Class.forName("com.mysql.jdbc.Driver");
Personnage p = Context.getInstance().getDaoP().findById(1);
%>


<%="<p>"+p.getNom()+","+p.getRace()+","+p.getMonture().getNom()+","+p.getArme().getNom()+"<p>" %>



<%

List<Personnage> players = Context.getInstance().getDaoP().findAll();
out.println("<table border><tr><th>Nom</th><th>Race</th><th>Monture</th><th>Arme</th></tr>");

/*for(Personnage p : players)
{
	out.println("<tr><td>"+p.getNom()+"</td><td>"+p.getRace()+"</td><td>"+p.getMonture().getNom()+"</td><td>"+p.getArme().getNom()+"</td></tr>");
}*/

%>
</table>




</body>
</html>


<script></script>
