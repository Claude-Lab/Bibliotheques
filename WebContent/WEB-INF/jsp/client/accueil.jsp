<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page session="true" %>

	
<!DOCTYPE html>
<html lang="fr">

<%@include file="../includes/header.html"%>


<body>
<h1>Ca Marche !!!</h1>
<ul>
<li>${sessionPersonne.prenom_Personne}</li>
<li>${sessionPersonne.nom_Personne}</li>
<li>${sessionPersonne.type_Personne}</li>
</ul>
</body>
</html>