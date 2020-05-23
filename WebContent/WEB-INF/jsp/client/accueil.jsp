<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<%@ include file="includes/header.html"%>
<body id="page-top">

	<!-- Navigation -->
	<%@ include file="includes/nav.html"%>

	<!-- Page Header -->
	<%@ include file="includes/pageheader.html"%>

	<!-- Main Content -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h3>Bienvenue ${sessionPersonne.prenom_Personne}
						${sessionPersonne.nom_Personne} !</h3>
					<br>
					<p>Voici l'exercice comportant une base de données de livres à
						disposition dans les cinq bibliothèques d'une communauté de
						communes.</p>
					<p>Le but ici est de réussir à faire des requêtes sur
						l'ensemble de la base de données pour :</p>

					<ul>
						<li>Se connecter avec son compte (utilisateurs abonnés et
							admin),</li>
						<li>Faire une recherche (utilisateurs abonnés et admin),</li>
						<li>Enregistrer un livre (utilisateurs admin),</li>
						<li>Enregistrer une personne, abonnée ou salariée
							(utilisateurs admin),</li>
						<li>Enregistrer les emprunts (utilisateurs admin),</li>
						<li>Etc.</li>

					</ul>
				</div>
			</div>
		</div>
	</section>

	<hr>

	<%@include file="includes/footer.html"%>

</body>
</html>