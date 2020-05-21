<%@page import="fr.lusseau.claude.bibliotheques.bo.Role"%>
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
				<h1 class="h3 mb-2 text-gray-800">Roles</h1>
				<p class="mb-4">Liste des Roles.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des Roles</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								
								<thead>
									<tr>
										<th>Id des roles</th>
										<th>Types des roles</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${roles}" var="roles">
										<tr>
											<td><c:out value="${roles.getId_Role()}" /></td>
											<td><c:out value="${roles.getType_Role()}" /></td>
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
