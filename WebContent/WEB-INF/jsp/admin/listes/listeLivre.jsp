<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Livre"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Auteur"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Bibliotheque"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Editeur"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Etat"%>
<%@page import="fr.lusseau.claude.bibliotheques.bo.Ecrit"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
<%@page import="fr.lusseau.claude.bibliotheques.messages.LecteurMessage"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html lang="fr">

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
				<p class="mb-4">Liste des livres enregistrés.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des Livres</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">


							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>id</th>
										<th>Titre</th>
										<th>Auteur</th>
										<th>N° ISBN</th>
										<th>Editeur</th>
										<th>Bibliothèque</th>
										<th>Etat</th>
									</tr>
								</thead>


								<%
									List<Livre> listeLivres = (List<Livre>) request.getAttribute("listeLivres");
									if (listeLivres != null) {
								%>
								<tbody>
									<%
										for (Livre livre : listeLivres) {
									%>
									<tr>
										<td><%=livre.getId_Livre()%></td>
										<td><%=livre.getTitre_Livre()%></td>
										<td><%=livre.getPrenom_Nom_Auteur()%></td>
										<td><%=livre.getIsbn_Ecrit()%></td>
										<td><%=livre.getNom_Editeur()%></td>
										<td><%=livre.getNom_Bibliotheque()%></td>
										<td><%=livre.getUsage_Etat()%></td>
									</tr>
									<%
										}
									%>
									<%
										} else {
									%>
									<p style="color: red">Il n'y a aucun livre à afficher !
									<P>
										<%
											}
										%>
									
								<tfoot>
									<tr>
										<th>id</th>
										<th>Titre</th>
										<th>Auteur</th>
										<th>N° ISBN</th>
										<th>Editeur</th>
										<th>Bibliothèque</th>
										<th>Etat</th>
									</tr>
								</tfoot>

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
