<%@page import="fr.lusseau.claude.bibliotheques.bo.Editeur"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
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
				<h1 class="h3 mb-2 text-gray-800">Editeurs</h1>
				<p class="mb-4">Liste des Editeurs enregistrés.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des
							Editeurs</h6>
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
										<th>Détails</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${editeurs}" var="editeurs">
										<tr>
											<td><c:out value="${editeurs.getId_Editeur()}" /></td>
											<td><c:out value="${editeurs.getNom_Editeur()}" /></td>
											<td><c:out value="${editeurs.getPays_Editeur()}" /></td>
											<td><c:out value="${editeurs.getMail_Editeur()}" /></td>
											<td><a href="detailediteur?id_Editeur=${editeurs.getId_Editeur()}">Plus de détails</a></td>
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
