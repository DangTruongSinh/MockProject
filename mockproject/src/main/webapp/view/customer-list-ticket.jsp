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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/Customer-List-Ticket.css">
<body>
<%@include file="../../common/header.jsp"%>
	<h1>List BookedTicket</h1>
	<div class="container">
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
					<th>Pay</th>
					<th>Cancel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${tickets}">
					<tr>
						<td>${item.bus.licensePlate}</td>
						<td>${item.seat.name}</td>
						<td>${item.place.startPlace}</td>
						<td>${item.place.stopPlace}</td>
						<td>${item.place.getTimeStart()}</td>
						<td>${item.place.getTimeEnd()}</td>
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
						<c:if test="${item.status == false}">
							<td><c:url var="payURL" value="/customer-ticket">
								<c:param name="action" value="pay" />
								<c:param name="idTicket" value="${item.idTicket}" />
							</c:url> <a class="btn btn-sm btn-primary btn-edit" href="${payURL}">Pay</a>
							</td>
						</c:if>
						<c:if test="${item.status == true}">
							<td></td>
						</c:if>
						<td><c:url var="deleteURL" value="/customer-ticket">
								<c:param name="action" value="delete" />
								<c:param name="idTicket" value="${item.idTicket}" />
							</c:url> <a class="btn btn-sm btn-primary btn-edit" href="${deleteURL}">Cancel</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>