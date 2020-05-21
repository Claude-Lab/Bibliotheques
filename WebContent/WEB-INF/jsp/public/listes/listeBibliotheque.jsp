<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">

<%@include file="../../includes/header.html"%>

<body id="page-top">

	<%@include file="../../includes/sidebar.html"%>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<%@include file="../../includes/topbar.html"%>

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Bibliothèques</h1>
				<p class="mb-4">Gestions des bibliothèque.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Liste des
							differentes bibliothèque du reseau :</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								
								<thead>
									<tr>
										<th>Id des bibliothèques</th>
										<th>Noms des bibliothèques</th>
										<th>Adresses</th>
										<th>Villes</th>
										<th>Téléphones</th>
										<th>Détails</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bibliotheques}" var="bibliotheques">
										<tr>
											<td><c:out value="${bibliotheques.getId_Bibliotheque()}" /></td>
											<td><c:out
													value="${bibliotheques.getNom_Bibliotheque()}" /></td>
											<td><c:out
													value="${bibliotheques.getAdresse_Bibliotheque()}" /></td>
											<td><c:out
													value="${bibliotheques.getVille_Bibliotheque()}" /></td>
											<td><c:out
													value="${bibliotheques.getTel_Bibliotheque()}" /></td>
											<td><a
												href="detailbibliotheque?id_Bibliotheque=${bibliotheques.getId_Bibliotheque()}">Plus de détails</a></td>


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


</body>

</html>
