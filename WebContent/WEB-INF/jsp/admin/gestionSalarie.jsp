<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<%@include file="../includes/header.html"%>

<body id="page-top">

	<%@include file="../includes/sidebarAdmin.html"%>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<%@include file="../includes/topbar.jsp"%>

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Personnes</h1>
				<p class="mb-4">Liste des personnes inscrites.</p>

				<!-- Grow In Utility -->

				<div class="card position-relative">

					<div class="card-body">

						<div class="small mb-1">Selection :</div>
						<nav class="navbar navbar-expand navbar-light bg-light mb-4">
							<a class="navbar-brand" href="gestionsalarie">Salariés</a>
							<ul class="navbar-nav ml-auto">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="gestionsalarie"
									id="navbarDropdown" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Salariés </a>
									<div
										class="dropdown-menu dropdown-menu-right animated--grow-in"
										aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="gestionclient">Clients</a> <a
											class="dropdown-item" href="gestionsalarie">Salariés</a>
									</div></li>
							</ul>
						</nav>
						<p class="mb-0 big">Note : utilisez le menu pour selectionner
							le type de personnes.</p>
					</div>
				</div>
				<br>
				<hr>
				<br>

				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Ajouter un
							salarié</h6>
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
										name="prenom_Personne" placeholder="Prenom..." required
										pattern="[-[:alpha:] ]{2,30}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																				${request.getPrenom_Personne}
																			</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="nom_Personne"></label> <input type="text"
										class="form-control form-control-user" id="nom_Personne"
										name="nom_Personne" placeholder="Nom..." required
										pattern="[-[:alpha:] ]{2,25}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																			${request.getNom_Personne}
																		</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="adresse_Personne"></label> <input type="text"
										class="form-control form-control-user" id="adresse_Personne"
										name="adresse_Personne" placeholder="Adresse..." required
										pattern="[-[:alpha:][:digit:] ]{2,25}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																		${request.getAdresse_Personne}
																	</c:if>"
										required="required">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="cp_Personne"></label> <input type="text"
										class="form-control form-control-user" id="cp_Personne"
										name="cp_Personne" placeholder="Code postal..." required
										pattern="[0-9]{5}" minlength="5" maxlength="5"
										title="5 chiffres pour le CP"
										value="<c:if test ="${!empty listeCodesErreur }">
																	${request.getCp_Personne}
																</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="ville_Personne"></label> <input type="text"
										class="form-control form-control-user" id="ville_Personne"
										name="ville_Personne" placeholder="Ville..." required
										pattern="[a-zA-Z ]{2,25}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																${request.getVille_Personne}
															</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="mail_Personne"></label> <input type="mail"
										class="form-control form-control-user" id="mail_Personne"
										name="mail_Personne" placeholder="eMail..." required
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
										value="<c:if test ="${!empty listeCodesErreur }">
															${request.getMail_Personne}
														</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="tel_Personne"></label> <input type="tel"
										class="form-control form-control-user" id="tel_Personne"
										name="tel_Personne" placeholder="Téléphone..." required
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
												<select name="role_Personne" class="custom-select" required>
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
														required>
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
									<label for="type_Personne"></label> <input type="hidden"
										class="form-control form-control-user" id="type_Personne"
										name="type_Personne" value="SALARIE" />
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
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des
							comptes SALARIES</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<c:if test="${!empty form}">
									<p style="color: red";>
										<c:out value="${form.resultatInsert}"></c:out>
									</p>
								</c:if>
								<br />
								<thead>
									<tr>
										<th>id</th>
										<th>Prenom</th>
										<th>Nom</th>
										<th>Adresse</th>
										<th>CP</th>
										<th>Ville</th>
										<th>Tel</th>
										<th>Mail</th>
										<th>Role</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<c:forEach items="${salaries}" var="salaries">
									<tbody>
										<tr>
											<td><c:out value="${salaries.getId_Personne()}" /></td>
											<td><c:out value="${salaries.getPrenom_Personne()}" /></td>
											<td><c:out value="${salaries.getNom_Personne()}" /></td>
											<td><c:out value="${salaries.getAdresse_Personne()}" /></td>
											<td><c:out value="${salaries.getCp_Personne()}" /></td>
											<td><c:out value="${salaries.getVille_Personne()}" /></td>
											<td><c:out value="${salaries.getTel_Personne()}" /></td>
											<td><c:out value="${salaries.getMail_Personne()}" /></td>
											<td><c:out value="${salaries.getRole_Personne()}" /></td>
											<td><a
												href="modifierpersonne?id_Personne=${salaries.getId_Personne()}">Modifier</a></td>
											<td><a
												href="supprimer?id_Personne=${salaries.getId_Personne()}&type_Personne=${salaries.getType_Personne()}">Supprimer</a></td>

										</tr>
								</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- End of Main Content -->
	</div>
	<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<%@include file="../includes/footer.html"%>
</body>
</html>
