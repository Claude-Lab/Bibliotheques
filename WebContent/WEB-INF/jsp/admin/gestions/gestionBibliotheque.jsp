<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<!DOCTYPE html>
<html lang="en">

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
				<h1 class="h3 mb-2 text-gray-800">Bibliothèques</h1>
				<p class="mb-4">Gestions des bibliothèque.</p>

				<!-- DataTales Example -->

				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Ajouter une
							bibliothèque</h6>
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

						<form method="post" class="user" action="gestionbibliotheque">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="nom_Bibliotheque"></label> <input type="text"
										class="form-control form-control-user" id="nom_Bibliotheque"
										name="nom_Bibliotheque" placeholder="Nom de la bibliothèque"
										required pattern="[-[:alpha:] ]{2,30}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																				${request.getNom_Bibliotheque}
																			</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="adresse_Bibliotheque"></label> <input type="text"
										class="form-control form-control-user"
										id="adresse_Bibliotheque" name="adresse_Bibliotheque"
										placeholder="Adresse de la bibliothèque..." required
										pattern="[-[:alpha:] ]{2,30}"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																			${request.getAdresse_Bibliotheque}
																		</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="cp_Bibliotheque"></label> <input type="text"
										class="form-control form-control-user" id="cp_Bibliotheque"
										name="cp_Bibliotheque"
										placeholder="Code Postal de la bibliothèque" required
										pattern="[0-9]{5}" minlength="5" maxlength="5"
										title="5 chiffres pour le CP" charset="UTF-8"
										value="<c:if test ="${!empty listeCodesErreur }">
																		${request.getCp_Bibliotheque}
																	</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="ville_Bibliotheque"></label> <input type="text"
										class="form-control form-control-user" id="ville_Bibliotheque"
										name="ville_Bibliotheque" placeholder="Ville..." required
										pattern="[a-zA-Z ]{2,25}" charset="UTF-8"
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">
																${request.getVille_Bibliotheque}
															</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="mail_Bibliotheque"></label> <input type="mail"
										class="form-control form-control-user" id="mail_Bibliotheque"
										name="mail_Bibliotheque" placeholder="eMail..." required
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
										value="<c:if test ="${!empty listeCodesErreur }">
															${request.getMail_Bibliotheque}
														</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="tel_Bibliotheque"></label> <input type="tel"
										class="form-control form-control-user" id="tel_Bibliotheque"
										name="tel_Bibliotheque" placeholder="Téléphone..." required
										pattern="[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}"
										title="00 00 00 00"
										value="<c:if test ="${!empty listeCodesErreur }">
														${request.getTel_Bibliotheque}
													</c:if>">
								</div>
							</div>
							<br />
							<div class="col-sm-12 mb-3 mb-sm-0">
								<input type="submit" value="Valider"
									class="btn btn-primary btn-lg btn-block" />
							</div>

						</form>
					</div>
				</div>
				<hr>
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Liste des
							differentes bibliothèque du reseau :</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
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
								<thead>
									<tr>
										<th>Id des bibliothèque</th>
										<th>Noms des bibliothèque</th>
										<th>Ville</th>
										<th>Détails</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bibliotheques}" var="bibliotheques">
										<tr>
											<td><c:out value="${bibliotheques.getId_Bibliotheque()}" /></td>
											<td><c:out
													value="${bibliotheques.getNom_Bibliotheque()}" /></td>
											<td><c:out
													value="${bibliotheques.getVille_Bibliotheque()}" /></td>
											<td><a
												href="detailbibliotheque?id_Bibliotheque=${bibliotheques.getId_Bibliotheque()}">Detail</a></td>
											<td><a
												href="modifierbibliotheque?id_Bibliotheque=${bibliotheques.getId_Bibliotheque()}">Modifier</a></td>
											<td><a
												href="supprimer?id_Bibliotheque=${bibliotheques.getId_Bibliotheque()}">Supprimer</a></td>

										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<%@include file="../../includes/footer.html"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#datatable').DataTable({
				order : [ [ 0, 'desc' ] ]
			});
		});
	</script>

</body>

</html>
