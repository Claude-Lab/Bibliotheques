<%@page import="fr.lusseau.claude.bibliotheques.bo.Cotisation"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.CotisationManager"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="../includes/header.html"%>

<body id="page-top">

	<%@include file="../includes/sidebarAdmin.html"%>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<%@include file="../includes/topbar.html"%>

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Cotisations</h1>
				<p class="mb-4">Gestions des cotisations.</p>



				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Ajouter une
							cotisation</h6>
					</div>

					<div class="card-body">
						<c:if test="${!empty form }">
							<p>
								<c:out value="${salary}" />
							<p>
						</c:if>
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
						
						<form method="post" class="user" action="gestioncotisation">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="valeurs"> Indiquer une valeur de cotisation
										: </label> <input type="number" class="form-control form-control-user"
										name="valeurs" id="valeurs"
										placeholder="Valeur de la cotisation..."
										value="<c:if test ="${!empty listeCodesErreur }" >
																			${request.getValeurs_Caution}
																		</c:if>"
										required="required">
								</div>

							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-4">
									<label for="nbrEmprunts"> Indiquez le nombre de livres
										qu'il sera possible d'emprunter avec la valeur de la
										cotisation choisie : </label> <input type="number"
										class="form-control form-control-user" name="nbrEmprunts"
										id="nbrEmprunts" placeholder="Nombre de livres..."
										value="<c:if test ="${!empty listeCodesErreur }">
																			${request.getNbrEmprunts_Caution}
																		</c:if>"
										required="required">
								</div>

							</div>
							<input type="submit" value="ENTREZ LA NOUVELLE COTISATION"
								class="btn btn-primary btn-user " />

							<hr>

						</form>

					</div>
				</div>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Liste des
							differentes cotisations possibles</h6>
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
								<c:if test="${empty form}">
									<p style="color: red";>
										<c:out value="${form.resultatInsert}"></c:out>
									</p>
								</c:if>
								



								<thead>
									<tr>
										<th>Id des cotisations</th>
										<th>Valeurs des cotisations</th>
										<th>Nombre d'emprunt(s) possible(s)</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cotisations}" var="cotisations">
										<tr>
											<td><c:out value="${cotisations.getId_Caution()}" /></td>
											<td><c:out value="${cotisations.getValeurs_Caution()}" />
												€</td>
											<td><c:out
													value="${cotisations.getNbrEmprunts_Caution()}" />
												livre(s)</td>
											<td><a
												href="modifier?id_Cotisation=${cotisations.getId_Caution()}">Modifier</a></td>
											<td><a
												href="supprimer?id_Cotisation=${cotisations.getId_Caution()}">Supprimer</a></td>
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
	<%@include file="../includes/footer.html"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#datatable').DataTable({
				order : [ [ 0, 'desc' ] ]
			});
		});
	</script>

</body>

</html>
