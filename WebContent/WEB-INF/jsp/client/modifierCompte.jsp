<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
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
					<h1>${sessionPersonne.prenom_Personne}
						${sessionPersonne.nom_Personne}</h1>
					<br>
					<h3>Modification des informations personnelles :</h3>
					<br>

					<form method="post" class="user" action="modifiercompte">
						<div class="form-group row">
						<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="hidden"
									class="form-control form-control-user" id="nom_Personne"
									name="nom_Personne" value="<c:if test ="${!empty listeCodesErreur }">
														${sessionPersonne.nom_Personne }
													</c:if>"/> 
							</div>
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="hidden"
									class="form-control form-control-user" id="prenom_Personne"
									name="prenom_Personne" value="<c:if test ="${!empty listeCodesErreur }">
														${sessionPersonne.prenom_Personne }
													</c:if>"/> 
							</div>
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="hidden"
									class="form-control form-control-user" id="id_Personne"
									name="id_Personne" value="<c:if test ="${!empty listeCodesErreur }">
														${sessionPersonne.id_Personne }
													</c:if>"/>
							</div>
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="hidden"
									class="form-control form-control-user" id="cotisation_Personne"
									name="cotisation_Personne" value="<c:if test ="${!empty listeCodesErreur }">
														${sessionPersonne.cotisation_Personne }
													</c:if>"/>
							</div>
							<div class="col-sm-6 mb-3 mb-sm-0">
								<div class="small mb-1"></div>
								<nav class="navbar navbar-expand navbar-light bg-light mb-4">
									<a class="navbar-brand">Nom : </b>${sessionPersonne.nom_Personne }</a>
									<ul class="navbar-nav ml-auto">
									</ul>
								</nav>
							</div>
							
							<div class="col-sm-6 mb-3 mb-sm-0">
								<div class="small mb-1"></div>
								<nav class="navbar navbar-expand navbar-light bg-light mb-4">
									<a class="navbar-brand">Prenom : </b>${sessionPersonne.prenom_Personne }</a>
									<ul class="navbar-nav ml-auto">
									</ul>
								</nav>
							</div>
							
							<div class="col-sm-6 mb-3 mb-sm-0">
								<div class="small mb-1"></div>
								<nav class="navbar navbar-expand navbar-light bg-light mb-4">
									<a class="navbar-brand">Identifiant : </b>${sessionPersonne.id_Personne }</a>
									<ul class="navbar-nav ml-auto">
									</ul>
								</nav>
							</div>
							
							<div class="col-sm-6 mb-3 mb-sm-0">
								<div class="small mb-1"></div>
								<nav class="navbar navbar-expand navbar-light bg-light mb-4">
									<a class="navbar-brand">Cotisation versée : </b>${sessionPersonne.cotisation_Personne }
										€
									</a>
									<ul class="navbar-nav ml-auto">

									</ul>
								</nav>

							</div>
							


							<div class="col-sm-12 mb-3 mb-sm-0">

								<label for="adresse_Personne"></label> <input type="text"
									class="form-control form-control-user" id="adresse_Personne"
									name="adresse_Personne"
									placeholder="${sessionPersonne.adresse_Personne }" 
									pattern="[-[:alpha:][:digit:] ]{2,25}"
									title="chiffre et signe spéciaux interdit"
									value="<c:if test ="${!empty listeCodesErreur }">
																		${request.getAdresse_Personne}
																	</c:if>">
							</div>
							<div class="col-sm-12 mb-3 mb-sm-0">
								<label for="cp_Personne"></label> <input type="text"
									class="form-control form-control-user" id="cp_Personne"
									name="cp_Personne"
									placeholder="${sessionPersonne.cp_Personne }" 
									pattern="[0-9]{5}" minlength="5" maxlength="5"
									title="5 chiffres pour le CP"
									value="<c:if test ="${!empty listeCodesErreur }">
																	${request.getCp_Personne}
																</c:if>">
							</div>
							<div class="col-sm-12 mb-3 mb-sm-0">
								<label for="ville_Personne"></label> <input type="text"
									class="form-control form-control-user" id="ville_Personne"
									name="ville_Personne"
									placeholder="${sessionPersonne.ville_Personne }" 
									pattern="[a-zA-Z ]{2,25}"
									title="chiffre et signe spéciaux interdit"
									value="<c:if test ="${!empty listeCodesErreur }">
																${request.getVille_Personne}
															</c:if>">
							</div>
							<div class="col-sm-12 mb-3 mb-sm-0">
								<label for="mail_Personne"></label> <input type="mail"
									class="form-control form-control-user" id="mail_Personne"
									name="mail_Personne"
									placeholder="${sessionPersonne.mail_Personne }" 
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
									value="<c:if test ="${!empty listeCodesErreur }">
															${request.getMail_Personne}
														</c:if>">
							</div>
							<div class="col-sm-12 mb-3 mb-sm-0">
								<label for="tel_Personne"></label> <input type="tel"
									class="form-control form-control-user" id="tel_Personne"
									name="tel_Personne"
									placeholder="${sessionPersonne.tel_Personne }" 
									pattern="[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}"
									title="00 00 00 00"
									value="<c:if test ="${!empty listeCodesErreur }">
														${request.getTel_Personne}
													</c:if>">
							</div>
						</div>
						<br /> <br />
						<h3>Modifier le mot de passe</h3>
						<div class="form-group row">
							<div class="col-sm-12 mb-3 mb-sm-0">
								<label for="motDePasse_Personne" value="test"></label> <input
									type="password" class="form-control form-control-user"
									id="motDePasse_Personne" name="motDePasse_Personne"
									placeholder="Mot de passe..."
									value="<c:if test ="${!empty listeCodesErreur }">
													${request.getMotDePasse_Personne}
												</c:if>">
							</div>
							<div class="col-sm-12 mb-3 mb-sm-0">
								<label for="motDePasse_Personne" value="test"></label> <input
									type="password" class="form-control form-control-user"
									id="motDePasse_Personne" name="motDePasse_Personne"
									placeholder="Entrez à nouveau votre mot de passe..."
									value="<c:if test ="${!empty listeCodesErreur }">
													${request.getMotDePasse_Personne}
												</c:if>">
							</div>


						</div>
						<br /> <br />
						<div class="form-group row">
							<div class="col-sm-12 mb-3 mb-sm-0">
								<input type="submit" value="Valider"
									class="btn btn-primary btn-lg btn-block" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<hr>

	<%@include file="includes/footer.html"%>

</body>
</html>