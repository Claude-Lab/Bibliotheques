<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<%@include file="../../includes/header.html"%>

<body id="page-top">

	<%@include file="../../includes/sidebarAdmin.html"%>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<%@include file="../../includes/topbar.jsp"%>

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Personnes</h1>
				<p class="mb-4">Modification</p>

				<!-- Grow In Utility -->

				<div class="card position-relative">

					
				</div>
				<br>
				<br>

				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Modifier le compte de ${personne.getPrenom_Personne()} ${personne.getNom_Personne()}</h6>
					</div>


					<div class="card-body">
						<c:if test="${ !empty listeCodesErreur }">
							<p style="color: red;">
								<c:out value="ERREUR" />
							</p>
						</c:if>
						<c:if test="${!empty form}">
							<p style="color: red";>
								<c:out value="${form.resultatInsert}"></c:out>
							</p>
						</c:if>
						<c:if test="${empty form}">
							<p style="color: red";>
								<c:out value="${form.resultatInsert}"></c:out>
							</p>
						</c:if>
						<form method="post" class="user" action="gestionsalarie">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="prenom_Personne"></label> <input type="text"
										class="form-control form-control-user" id="prenom_Personne"
										name="prenom_Personne" placeholder="${personne.getPrenom_Personne()}" 
										pattern="[-[:alpha:] ]{2,30}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																				${request.getPrenom_Personne}
																			</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="nom_Personne"></label> <input type="text"
										class="form-control form-control-user" id="nom_Personne"
										name="nom_Personne" placeholder="${personne.getNom_Personne()}" 
										pattern="[-[:alpha:] ]{2,25}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																			${request.getNom_Personne}
																		</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="adresse_Personne"></label> <input type="text"
										class="form-control form-control-user" id="adresse_Personne"
										name="adresse_Personne" placeholder="${personne.getAdresse_Personne()}" 
										pattern="[-[:alpha:][:digit:] ]{2,25}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																		${request.getAdresse_Personne}
																	</c:if>" >
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="cp_Personne"></label> <input type="text"
										class="form-control form-control-user" id="cp_Personne"
										name="cp_Personne" placeholder="${personne.getCp_Personne()}" 
										pattern="[0-9]{5}" minlength="5" maxlength="5"
										title="5 chiffres pour le CP"
										value="<c:if test ="${!empty listeCodesErreur }">
																	${request.getCp_Personne}
																</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="ville_Personne"></label> <input type="text"
										class="form-control form-control-user" id="ville_Personne"
										name="ville_Personne" placeholder="${personne.getVille_Personne()}" 
										pattern="[a-zA-Z ]{2,25}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																${request.getVille_Personne}
															</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="mail_Personne"></label> <input type="mail"
										class="form-control form-control-user" id="mail_Personne"
										name="mail_Personne" placeholder="${personne.getMail_Personne()}" 
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
										value="<c:if test ="${!empty listeCodesErreur }">
													${request.getMail_Personne} </c:if>">
       										
  										
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="tel_Personne"></label> <input type="tel"
										class="form-control form-control-user" id="tel_Personne"
										name="tel_Personne" placeholder="${personne.getTel_Personne()}" 
										pattern="[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}"
										title="00 00 00 00"
										value="<c:if test ="${!empty listeCodesErreur }">
														${request.getTel_Personne}
													</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="motDePasse_Personne"></label> <input
										type="password" class="form-control form-control-user"
										id="motDePasse_Personne" name="motDePasse_Personne"
										placeholder="Mot de passe..."
										value="<c:if test ="${!empty listeCodesErreur }">
													${request.getMotDePasse_Personne}
												</c:if>">
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="small mb-1">
										<br />
									</div>
									<nav class="navbar navbar-expand navbar-light bg-light mb-4">
										<a class="navbar-brand">Rôle du Salarié : ${param.roles}</a>
										<ul class="navbar-nav ml-auto">
											<div class="form-group">
												<select name="role_Personne" class="custom-select" >
													<option value="">-- CHOIX ROLE --</option>
													<c:forEach var="roles" items="${roles}">
														<option value="${roles.getId_Role() }">${roles.getType_Role()}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Selection obligatoire</div>
											</div>
										</ul>
									</nav>
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="small mb-1">
										<br />
										<nav class="navbar navbar-expand navbar-light bg-light mb-4">
											<a class="navbar-brand">Caution d'emprunt versée :
												${param.cautions}</a>
											<ul class="navbar-nav ml-auto">
												<div class="form-group">
													<select name="cotisation_Personne" class="custom-select"
														>
														<option value="">-- CHOIX CAUTION --</option>
														<c:forEach var="cautions" items="${cautions}">
															<option value="${cautions.getId_Caution()}">${cautions.getValeurs_Caution()}</option>
														</c:forEach>
													</select>
													<div class="invalid-feedback">Selection obligatoire</div>

												</div>
											</ul>
										</nav>

									</div>
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="small mb-1">
										<br />
										<nav class="navbar navbar-expand navbar-light bg-light mb-4">
											<a class="navbar-brand">Type de Personne : </a>
											<ul class="navbar-nav ml-auto">
												<div class="form-group">
													<select name="type_Personne" class="custom-select"
														>
														<option value="">-- CHOIX TYPE --</option>
														
															<option value="SALARIE">SALARIE</option>
															<option value="CLIENT">CLIENT</option>
														
													</select>
													<div class="invalid-feedback">Selection obligatoire</div>

												</div>
											</ul>
										</nav>

									</div>
								</div>


							</div>
							<div class="col-sm-12 mb-3 mb-sm-0">
								<input type="submit" value="Valider"
									class="btn btn-primary btn-lg btn-block" />
							</div>
						</form>
					</div>
				</div>
				<br>
				<hr>
				<br>
				

			</div>
		</div>
	</div>
	<!-- End of Main Content -->
	</div>
	<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<%@include file="../../includes/footer.html"%>
</body>
</html>
