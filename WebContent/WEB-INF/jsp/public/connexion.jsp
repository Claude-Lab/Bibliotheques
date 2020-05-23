<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="fr">

<%@ include file="includes/header.html"%>
<body>

	<!-- Navigation -->
	<%@ include file="includes/nav.html"%>

	<!-- Page Header -->
	<%@ include file="includes/pageheader.html"%>

	<!-- Main Content -->
	<div class="container">
		<!-- Outer Row -->
		<div class="row justify-content-center">


			<div class="col-xl-10 col-lg-12 col-md-9">


				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">

						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-12">

								<div class="p-5">
									<p style="color: red" align="center"
										class="${empty form.erreurs ? 'succes' : 'erreur'}">${message}</p>

									<!--   Vérification de la présence d'un objet utilisateur en session -->
									<c:if test="${!empty sessionScope.sessionPersonne}">
										<!--   Si l'utilisateur existe en session, alors on affiche son adresse email. -->
										<p style="color: blue" align="center" class="succes">Vous
											êtes connecté(e) avec l'adresse :
											${sessionScope.sessionPersonne.mail_Personne}</p>
									</c:if>
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Bienvenue
											${sessionScope.sessionPersonne.getPrenom_Personne()} !</h1>
									</div>
									<form method="post" action="connexion" class="user">
										<div class="form-group">
											<input type="email" name="mail_Personne"
												class="form-control form-control-user" id="mail_Personne"
												aria-describedby="emailHelp"
												placeholder="Entrez votre eMail..."
												pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
										</div>
										<div class="form-group">
											<input type="password" name="motDePasse_Personne"
												class="form-control form-control-user"
												id="motDePasse_Personne" placeholder="Votre mot de passe">
										</div>
										<div class="form-group">
											<input type="hidden" name="id_Personne" value="id_Personne"
												class="form-control form-control-user" id="id_Personne">
										</div>
										<div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input type="checkbox" class="custom-control-input"
													id="customCheck"> <label
													class="custom-control-label" for="customCheck">Se
													souvenir de moi</label>
											</div>
										</div>
										<div class="col-sm-12 mb-3 mb-sm-0">
											<input type="submit" value="Valider"
												class="btn btn-primary btn-user btn-block" />
										</div>





									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="forgot-password.html">Mot de passe
											oublié ?</a>
									</div>
									<div class="text-center">
										<a class="small" href="register.html">Créez un compte !</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<hr>

	<%@include file="includes/footer.html"%>