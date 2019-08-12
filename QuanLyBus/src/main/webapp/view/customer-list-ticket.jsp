<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Basic Table</h2>
		<p>The .table class adds basic styling (light padding and only
			horizontal dividers) to a table:</p>
		<table class="table">
			<thead>
				<tr>
					<th>licensePlate</th>
					<th>Seat</th>
					<th>PlaceStart</th>
					<th>PlaceEnd</th>
					<th>TimeStart</th>
					<th>TimeEnd</th>
					<th>DateBook</th>
					<th>Price</th>
					<th>Status</th>
					<th>Cancel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${tickets}">
					<tr>
						<td>${item.bus.licensePlate}</td>
						<td>${item.seat.name}</td>
						<td>${item.bus.placeStart}</td>
						<td>${item.bus.placeEnd}</td>
						<td>${item.bus.timeStart}</td>
						<td>${item.bus.timeEnd}</td>
						<td>${item.dateCreate}</td>
						<td>${item.price}</td>
						<c:choose>
							<c:when test="${item.status == false}">
								<td>Unpaid</td>
							</c:when>
							<c:otherwise>
								<td>Paided</td>
							</c:otherwise>
						</c:choose>
						<td><c:url var="editURL" value="/admin-account">
								<c:param name="action" value="edit" />
								<c:param name="username" value="" />
							</c:url> <a class="btn btn-sm btn-primary btn-edit" href="${editURL}">Cancel</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>