<%@page import="fr.lusseau.claude.bibliotheques.bo.Role"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.RoleManager"%>
<%@page import="fr.lusseau.claude.bibliotheques.bll.BLLException"%>
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
				<h1 class="h3 mb-2 text-gray-800">Roles</h1>
				<p class="mb-4">Liste des Roles.</p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Base des Roles</h6>
					</div>

					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter un
								rôle</h6>
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

							<form method="post" class="user" action="gestionrole">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<label for="type_Role"> Indiquer un nom pour le
											nouveau rôle : : </label> <input type="text"
											class="form-control form-control-user" name="type_Role"
											id="type_Role" placeholder="Nom du rôle..."
											value="<c:if test ="${!empty listeCodesErreur }" >
																			${request.getType_Role()}
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
										<th>Id des roles</th>
										<th>Types des roles</th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${roles}" var="roles">
										<tr>
											<td><c:out value="${roles.getId_Role()}" /></td>
											<td><c:out value="${roles.getType_Role()}" /></td>
											<td><a href="modifier?id_Role=${roles.getId_Role()}">Modifier</a></td>
											<td><a href="supprimer?id_Role=${roles.getId_Role()}">Supprimer</a></td>
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
	<%@include file="../includes/footer.html"%>
</body>

</html>
