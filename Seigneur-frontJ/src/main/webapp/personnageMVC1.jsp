<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>




<%
Personnage p=(Personnage)request.getAttribute("monPerso");
out.println("<p>"+p.getNom()+","+p.getRace()+","+p.getMonture().getNom()+","+p.getArme().getNom()+"<p>");
%>





</body>
</html>


<script></script>
