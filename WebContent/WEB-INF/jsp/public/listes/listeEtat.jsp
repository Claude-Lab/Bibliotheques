<%@page import="fr.lusseau.claude.bibliotheques.bo.Etat"%>
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
				<h1 class="h3 mb-2 text-gray-800">Etat</h1>
				<p class="mb-4">Liste des états possibles des livres.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des Etats</h6>
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
										<th>Types des états</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${etats}" var="etats">
										<tr>
											<td><c:out value="${etats.getId_Etat()}" /></td>
											<td><c:out value="${etats.getUsage_Etat()}" /></td>
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
