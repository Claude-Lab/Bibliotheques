<%@page import="fr.lusseau.claude.bibliotheques.bll.PersonneManager"%>
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

			<%@include file="../../includes/topbar.html"%>

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
							<a class="navbar-brand" href="listeclient">Clients</a>
							<ul class="navbar-nav ml-auto">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="listeclient"
									id="navbarDropdown" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Clients </a>
									<div
										class="dropdown-menu dropdown-menu-right animated--grow-in"
										aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="listeclient">Clients</a> <a
											class="dropdown-item" href="listesalarie">Salariés</a>
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
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des
							comptes CLIENTS</h6>
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
										<th>Prenom</th>
										<th>Nom</th>
										<th>Ville</th>
										<th>Mail</th>
										<th>Caution</th>
										<th>Détails</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${clients}" var="clients">


										<tr>
											<td><c:out value="${clients.getId_Personne()}" /></td>
											<td><c:out value="${clients.getPrenom_Personne()}" /></td>
											<td><c:out value="${clients.getNom_Personne()}" /></td>
											<td><c:out value="${clients.getVille_Personne()}" /></td>
											<td><c:out value="${clients.getMail_Personne()}" /></td>
											<td><c:out value="${clients.getCotisation_Personne()}" />
												€</td>
											<td><a
												href="detailpersonne?id_Personne=${clients.getId_Personne()}">Plus de détails</a></td>
											
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
	<%@include file="../../includes/footer.html"%>
</body>
</html>
