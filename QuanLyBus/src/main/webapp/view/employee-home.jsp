<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Ticket Seller</title>
<!-- paging for this template -->
<script src="/QuanLyBus/view/js/jquery.min.js"></script>
<script src="/QuanLyBus/view/js/bootstrap.min.js"></script>
<script src="/QuanLyBus/view/js/jquery.twbsPagination.js"></script>
<link href="/QuanLyBus/view/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom fonts for this template -->
<link href="/QuanLyBus/view/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS -->
<link href="/QuanLyBus/view/css/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/QuanLyBus/view/css/sb-admin.css" rel="stylesheet">
<link href="/QuanLyBus/view/css/MyStyle.css" rel="stylesheet">
</head>
<body id="page-top">


	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="#">Ticket Seller</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="ticket.html"> <i class="fas fa-fw fa-table"></i> <span>Tickets</span></a>
			</li>
			<li class="nav-item active"><a class="nav-link" href="seat.html">
					<i class="fas fa-fw fa-table"></i> <span>Seats</span>
			</a></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Tickets</li>
				</ol>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> View all tickets
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<!-- Search for UserName -->
							<div class="mainInput">
								<div class="input-group">
									<form action="/QuanLyBus/employee-account" id="formSearch">
										<input type="hidden" name="action" value="search"> <input
											type="text" name="username" class="form-control"
											id="inputtext" placeholder="Search for UserName">
									</form>
									<div class="input-group-append">
										<button class="btn btn-secondary" type="submit"
											form="formSearch">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
							<!-- --- -->
							<form action="/QuanLyBus/employee-account" id="formSubmit">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>IdTicket</th>
											<th>IdBus</th>
											<th>Seat Number</th>
											<th>UserName</th>
											<th>FullName</th>
											<th>Phone</th>
											<th>Price</th>
											<th>Status</th>
											<th>Edit</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty tickets}">
											<c:forEach var="item" items="${tickets}">
												<tr>
													<td>${item.idTicket}</td>
													<td>${item.idBus}</td>
													<td>${item.seat.name}</td>
													<td>${item.accModel.userName}</td>
													<td>${item.accModel.fullName}</td>
													<td>${item.accModel.phone}</td>
													<td>${item.price}</td>
													<td>${item.status}</td>
													<td><c:url var="editURL" value="/employee-account">
															<c:param name="action" value="edit" />
															<c:param name="username"
																value="${item.accModel.userName}" />
															<c:param name="IDTICKET" value="${item.idTicket}" />
														</c:url> <a class="btn btn-sm btn-primary btn-edit"
														href="${editURL}">Edit</a></td>
												</tr>
											</c:forEach>
										</c:if>

									</tbody>
								</table>
								<input type="hidden" id="curentPage" name="curentPage" value="">
							</form>

						</div>
						<!-- paging -->
						<div class="container" id="pagingdiv" style="margin-top: 20px">
							<nav aria-label="Page navigation" id="navPagination">
								<ul class="pagination" id="pagination"></ul>
							</nav>
						</div>
						<!-- ---- -->
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Java50team</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- paging script -->
	<script type="text/javascript">
		var limit = 2;
		var curentPage = ${pageModel.curentPage};
		var totalPage = ${pageModel.totalPage};
		$(function() {
			console.log(totalPage);
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : curentPage,
				onPageClick : function(event, page) {
					if (curentPage != page) {
						$('#curentPage').val(page);
						$('#formSubmit').submit();
					}
				}
			})
		});
		$("#inputtext").keyup(function(event) {
			if (event.keyCode == 13) {
				$("#pagination").hide();
				$("#formSearch").submit("search");
			}
		});
	</script>

	<!-- Bootstrap core JavaScript-->
	<script src="/QuanLyBus/view/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript  -->
	<script src="/QuanLyBus/view/js/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="/QuanLyBus/view/js/jquery.dataTables.js"></script>
	<script src="/QuanLyBus/view/js/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/QuanLyBus/view/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="/QuanLyBus/view/js/datatables-demo.js"></script>
</body>
</html>