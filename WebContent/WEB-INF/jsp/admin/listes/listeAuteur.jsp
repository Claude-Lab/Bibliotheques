<%@page import="fr.lusseau.claude.bibliotheques.bo.Livre"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Auteur"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Bibliotheque"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Editeur"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Etat"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Ecrit"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>

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
				<h1 class="h3 mb-2 text-gray-800">Livres</h1>
				<p class="mb-4">Liste des livres enregistr�s.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des Livres</h6>
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
								<br />
								<thead>
									<tr>
										<th>id</th>
										<th>Titre</th>
										<th>Auteur</th>
										<th>N� ISBN</th>
										<th>Editeur</th>
										<th>Biblioth�que</th>
										<th>Etat</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${auteurs}" var="auteurs">
										<tr>
											<td><c:out value="${auteurs.getId_Auteur()}" /></td>
											<td><c:out value="${auteurs.getNom_Auteur()}" /></td>
											<td><c:out value="${auteurs.getPrenom_Auteur()}" /></td>
											<td><a
												href="modifierauteur?id_Auteur=${auteurs.getId_Auteur()}">Modifier</a></td>
										</tr>
									</c:forEach>
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
