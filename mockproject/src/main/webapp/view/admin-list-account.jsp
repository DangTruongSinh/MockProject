<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Admin Mangerment</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script
	src="${pageContext.request.contextPath}/view/js/jquery.twbsPagination.js"
	type="text/javascript"></script>

	<!-- Custom fonts for this template-->
	<link href="${pageContext.request.contextPath}/view/css/all.min.css" rel="stylesheet" type="text/css">

	<!-- Page level plugin CSS-->
	<link href="${pageContext.request.contextPath}/view/css/dataTables.bootstrap4.css" rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="${pageContext.request.contextPath}/view/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<img src="view/img/brand-icon.PNG">
		<a class="navbar-brand mr-1" href="/mockproject/view/login.jsp">Bus Admin</a>


		<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<form action="/mockproject/admin-account" id="formSearch">
					<input type="text" class="form-control" name="username" id="inputtext" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
					<div class="input-group-append">
						<input type="hidden" name="action" value="search">
						<button  class="btn btn-success btn-xs">Search</button>
					</div>
				</form>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow">
				<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-user-circle fa-fw"></i>
				</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
				</div>
			</li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="/mockproject/view/login.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Wellcome </span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/mockproject/view/login.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Admin Manger</span>
				</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-fw fa-folder"></i>
					<span>Account</span>
				</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Account Manger:</h6>
					<a class="dropdown-item" href="/mockproject/view/login.jsp">View all account</a>
					<a class="dropdown-item" href="/mockproject/view/admin-create-account.jsp">Create account</a>
				</div>
			</li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="/mockproject/view/login.jsp">Home</a>
					</li>
					<li class="breadcrumb-item active">Acount list</li>
				</ol>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table">Acount Table</i>
					</div>
					<div class="card-body">
						<form action="/mockproject/admin-account" id="formSubmit">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>UserName</th>
											<th>FullName</th>
											<th>Role</th>
											<th>Phone</th>
											<th>DateBirth</th>
											<th>DateCreate</th>
											<th>DateUpdate</th>
											<th>UserCreate</th>
											<th>UserUpdate</th>
											<th>LastTimeLogin</th>
											<th>Edit</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty accounts}">
										<c:forEach var="item" items="${accounts}">
										<tr>
											<td>${item.userName}</td>
											<td>${item.fullName}</td>
											<td>${item.role.name}</td>
											<td>${item.phone}</td>
											<td>${item.getStringDateBirth()}</td>
											<td>${item.dateCreate}</td>
											<td>${item.dateUpdate}</td>
											<td>${item.userCreate}</td>
											<td>${item.userUpdate}</td>
											<td>${item.lastTimeLogin}</td>
											<td>
												<c:url var="editURL" value="/admin-account">
												<c:param name="action" value="edit"/>
												<c:param name="username" value="${item.userName}"/>
											</c:url>
											<a class="btn btn-sm btn-primary btn-edit" href="${editURL}">Edit</a>
										</td>
									</tr>
								</c:forEach>
							</c:if>

						</tbody>
					</table>
					<input type="hidden" id="curentPage" name="curentPage" value="">
				</form>
				<nav aria-label="Page navigation">
					<ul class="pagination" id="pagination">
					</ul>
				</nav>
				<input type="hidden" id="curentPage" name="curentPage" value="">
			</div>
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
<a class="scroll-to-top rounded" href="#page-top">
	<i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="/mockproject/dang-nhap?action=logout">Logout</a>
			</div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/view/js/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="${pageContext.request.contextPath}/view/js/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/view/js/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/view/js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="${pageContext.request.contextPath}/view/js/datatables-demo.js"></script>
</body>
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
		console.log(event.keyCode);
		if (event.keyCode == 13) {
			$("#pagination").hide();
			$("#formSearch").submit("search");
		}
	});
</script>
<script>
  $('.select').change(function(e) {
    var optionSelected = $("option:selected", this);
    var valueSelected = optionSelected.index() + 1;
    console.log(valueSelected);
    $("#roleSelect").val(valueSelected);
  });
</script>
</html>