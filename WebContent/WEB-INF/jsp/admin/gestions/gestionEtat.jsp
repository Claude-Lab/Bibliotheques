<%@page import="fr.lusseau.claude.bibliotheques.bo.Etat"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.EtatManager"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="../../includes/header.html"%>

<body id="page-top">

	<%@include file="../../includes/sidebar.html"%>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<%@include file="../../includes/topbar.jsp"%>

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Etats</h1>
				<p class="mb-4">Gerer les differents états possibles.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des Etats</h6>
					</div>

					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter un
								état</h6>
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

							<form method="post" class="user" action="gestionetat">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<label for="usage_Etat"> Indiquer un nom pour le
											nouvel état : </label> <input type="text"
											class="form-control form-control-user" name="usage_Etat"
											id="usage_Etat" placeholder="Nom de l'état..."
											value="<c:if test ="${!empty listeCodesErreur }" >
																			${request.getUsage_Etat()}
																		</c:if>"
											required="required">
									</div>

								</div>

								<input type="submit" value="VALIDER"
									class="btn btn-primary btn-user " />

								<hr>

							</form>

						</div>
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
								<thead>
									<tr>
										<th>Id des états</th>
										<th>Types des état</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${etats}" var="etats">
										<tr>
											<td><c:out value="${etats.getId_Etat()}" /></td>
											<td><c:out value="${etats.getUsage_Etat()}" /></td>
											<td><a href="modifier?id_Etat=${etats.getId_Etat()}">Modifier</a></td>
											<td><a href="supprimer?id_Etat=${etats.getId_Etat()}">Supprimer</a></td>
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
