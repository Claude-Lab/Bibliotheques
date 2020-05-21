<%@page import="fr.lusseau.claude.bibliotheques.bo.Cotisation"%>
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

			<%@include file="../../includes/topbar.html"%>

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Cotisations</h1>
				<p class="mb-4">Gestions des cotisations.</p>

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
										<c:out value="${form.resultat}"></c:out>
									</p>
								</c:if>
								<c:if test="${empty cotisations}">
								<p style="color: red">Il n'y a aucun éditeur à afficher !
												</p>>
								</c:if>
								<thead>
									<tr>
										<th>Id des cotisations</th>
										<th>Valeurs des cotisations</th>
										<th>Nombre d'emprunt(s) possible(s)</th>
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
