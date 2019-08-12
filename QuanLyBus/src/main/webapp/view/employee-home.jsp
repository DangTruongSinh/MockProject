<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/view/js/jquery.twbsPagination.js"
	type="text/javascript"></script>
</head>
<body>
<<<<<<< HEAD
	<h1>employee wellcome</h1>
	<a href="/QuanLyBus/dang-nhap?action=logout">Logout</a>
=======
	<div class="container">
		<a href="/QuanLyBus/dang-nhap?action=logout">logout</a>
		<h2>Basic Table</h2>
		<p>The .table class adds basic styling (light padding and only
			horizontal dividers) to a table:</p>
		<form action="/QuanLyBus/employee-account" id="formSearch">
			<input type="hidden" name="action" value="search"> 
			<input type="text" name="username" id="inputtext">
		</form>
		<form action="/QuanLyBus/employee-account" id="formSubmit">
			<table class="table">
				<thead>
					<tr>
						<th>idTicket</th>
						<th>idBus</th>
						<th>idSeat</th>
						<th>idUser</th>
						<th>status</th>
						<th>price</th>
						<th>fullName</th>
						<th>phone</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty tickets}">
						<c:forEach var="item" items="${tickets}">
							<tr>
								<td>${item.idTicket}</td>
								<td>${item.idBus}</td>
								<td>${item.idSeat}</td>
								<td>${item.idUser}</td>
								<td>${item.status}</td>
								<td>${item.price}</td>
								<td>${item.accModel.password}</td>
								<td>${item.accModel.phone}</td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>
			</table>
			<input type="hidden" id="curentPage" name="curentPage" value="">
		</form>
		<nav aria-label="Page navigation">
			<ul class="pagination" id="pagination"></ul>
		</nav>
	</div>
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
>>>>>>> 1bc7e8fd9f2061528c191756f69baaeeae3c93b1
</body>
</html>