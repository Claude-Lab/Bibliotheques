<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="fr">

<%@ include file="includes/header.html"%>
<body id="page-top">

	<!-- Navigation -->
	<%@ include file="includes/nav.jsp"%>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('../img/book.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>Mon compte</h1>
						<!--    <span class="subheading">A Blog Theme by Start Bootstrap</span> -->
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<section id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h1>Compte de ${sessionPersonne.prenom_Personne}
						${sessionPersonne.nom_Personne}</h1>
					<br>
					<h3>Modifier mes informations personnelles :</h3>
					<br>

					
					
					<p><b>Mon Adresse : </b>${sessionPersonne.adresse_Personne } - ${sessionPersonne.cp_Personne }
							${sessionPersonne.ville_Personne }</p>
					
					<p><b>Mon eMail : </b>${sessionPersonne.id_Personne }</p>
					
					<p><b>Mon Téléphone : </b>${sessionPersonne.tel_Personne }</p>
					
					<p><b>Mon mot de passe : </b>${sessionPersonne.id_Personne }</p>
						

				</div>
			</div>
		</div>
	</section>

	<hr>

	<%@include file="includes/footer.html"%>

</body>
</html>