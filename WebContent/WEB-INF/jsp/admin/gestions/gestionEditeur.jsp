<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h1 class="h3 mb-2 text-gray-800">Editeurs</h1>
				<p class="mb-4">Gerer les differents éditeurs.</p>

				<!-- DataTales Example -->

				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Ajouter un
							éditeur.</h6>
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

						<form method="post" class="user" action="gestionediteur">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="nom_Editeur"></label> <input type="text"
										class="form-control form-control-user" name="nom_Editeur"
										id="nom_Editeur" placeholder="Nom de l'éditeur..."
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">${request.getNomEditeur()}</c:if>"
										required="required" pattern="[-[:alpha:] ]{2,30}">
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="adresse_Editeur"></label> <input type="text"
										class="form-control form-control-user" name="adresse_Editeur"
										id="adresse_Editeur" placeholder="Adresse de l'éditeur..."
										title="chiffre et signe spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">${request.getAdresse_Editeur()}</c:if>"
										required="required" pattern="[-[:alpha:] ]{2,30}">
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="cp_Editeur"></label> <input type="text"
										class="form-control form-control-user" id="cp_Editeur"
										name="cp_Editeur" placeholder="Code Postal de l'éditeur"
										required pattern="[0-9]{5}" minlength="5" maxlength="5"
										title="5 chiffres pour le CP"
										value="<c:if test ="${!empty listeCodesErreur }">${request.getCp_Editeur}</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="ville_Editeur"></label> <input type="text"
										class="form-control form-control-user" id="ville_Editeur"
										name="ville_Editeur" placeholder="Ville..." required
										pattern="[-[:alpha:] ]{2,30}"
										title="chiffre et signes spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">${request.getVille_Editeur}</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="mail_Editeur"></label> <input type="mail"
										class="form-control form-control-user" id="mail_Editeur"
										name="mail_Editeur" placeholder="eMail..." required
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
										title="truc@machin.com"
										value="<c:if test ="${!empty listeCodesErreur }">${request.getMail_Editeur}</c:if>">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="pays_Editeur"></label> <input type="text"
										class="form-control form-control-user" id="pays_Editeur"
										name="pays_Editeur" placeholder="Pays..." required
										pattern="[-[:alpha:] ]{2,30}"
										title="chiffre et signes spéciaux interdit"
										value="<c:if test ="${!empty listeCodesErreur }">${request.getPays_Editeur}</c:if>">
								</div>
							</div>
							<br />
							<div class="col-sm-12 mb-3 mb-sm-0">
								<input type="submit" value="VALIDER"
									class="btn btn-primary btn-lg btn-block" />
							</div>


						</form>
					</div>
				</div>
				<hr>
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Liste des éditeurs</h6>
					</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<c:if test="${!empty form}">
								<p style="color: red";>
									<c:out value="${form.resultat}"></c:out>
								</p>
							</c:if>
							<c:if test="${empty editeurs}">
								<p style="color: red">Il n'y a aucun éditeur à afficher !</p>
							</c:if>
							<thead>
								<tr>
									<th>id</th>
									<th>Noms</th>
									<th>Pays</th>
									<th>eMail</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${editeurs}" var="editeurs">
									<tr>
										<td><c:out value="${editeurs.getId_Editeur()}" /></td>
										<td><c:out value="${editeurs.getNom_Editeur()}" /></td>
										<td><c:out value="${editeurs.getPays_Editeur()}" /></td>
										<td><c:out value="${editeurs.getMail_Editeur()}" /></td>
										<td><a
											href="detailbibliotheque?id_Editeur=${bibliotheques.getId_Editeur()}">Detail</a></td>
										<td><a
											href="modifierbibliotheque?id_Editeur=${bibliotheques.getId_Editeur()}">Modifier</a></td>
										<td><a
											href="supprimer?id_Editeur=${bibliotheques.getId_Editeur()}">Supprimer</a></td>

									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>
			</div>



		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	</div>
	<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<%@include file="../../includes/footer.html"%>
</body>

</html>
