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
					<h3>Mes informations personnelles :</h3>
					<br>

					<ul>
						<li><b>Identifiant : </b>${sessionPersonne.id_Personne }</li>
						<li><b>Nom : </b>${sessionPersonne.nom_Personne }</li>
						<li><b>Prenom : </b>${sessionPersonne.prenom_Personne }</li>
						<li><b>Adresse : </b>${sessionPersonne.adresse_Personne }
							- ${sessionPersonne.cp_Personne }
							${sessionPersonne.ville_Personne }</li>
						<li><b>eMail : </b>${sessionPersonne.mail_Personne }</li>
						<li><b>Téléphone : </b>${sessionPersonne.tel_Personne }</li>
						<li><b>Cotisation : </b>${sessionPersonne.cotisation_Personne }
							€</li>
						<c:if test="${! empty sessionPersonne.role_Personne}">
							<li><b>Mon rôle sur le site : </b>${sessionPersonne.role_Personne }
							</li>
						</c:if>
						<li><b>Ma date d'inscription sur le site : </b> <fmt:formatDate
								pattern="E dd MMMM yyyy  -  HH:mm:ss" type="both"
								dateStyle="long" timeStyle="long"
								value="${sessionPersonne.inscription_Personne}" /></li>

					</ul>
					<br><br>
					<div class="row">
						<div class="col-lg-12 col-md-10 mx-auto">
							<a class="btn btn-primary btn-lg btn-block" href="modifiercompte"
								role="button">Modifier mes informations</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<hr>

	<%@include file="includes/footer.html"%>

</body>
</html>