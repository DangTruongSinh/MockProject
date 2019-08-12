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
	<div class="container">
		<a href="/QuanLyBus/dang-nhap?action=logout">logout</a>
		<a href="/QuanLyBus/view/admin-create-account.jsp">Create account</a>
		<h2>Basic Table</h2>
		<p>The .table class adds basic styling (light padding and only
			horizontal dividers) to a table:</p>
		<form action="/QuanLyBus/admin-account" id="formSearch">
			<input type="hidden" name="action" value="search"> 
			<input type="text" name="username" id="inputtext">
		</form>
		<form action="/QuanLyBus/admin-account" id="formSubmit">
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
</body>
</html>