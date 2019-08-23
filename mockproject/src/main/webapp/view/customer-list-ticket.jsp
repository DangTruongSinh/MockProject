<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-ticket"/>
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
					<th>DepartDate</th>
					<th>TimeStart</th>
					<th>TimeEnd</th>
					<th>DateBook</th>
					<th>Price</th>
					<th>Status</th>
					<th>Pay</th>
					<th>Cancel</th>
				</tr>
			</thead>
			<tbody id="cha">
				<c:forEach var="item" items="${tickets}">
					<tr id = "${item.idTicket}">
						<td>${item.bus.licensePlate}</td>
						<td>${item.seat.name}</td>
						<td>${item.place.startPlace}</td>
						<td>${item.place.stopPlace}</td>
						<td>${item.departDate}</td>
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
							<td>
								<button class="btn btn-sm btn-primary btn-edit btnPay" data-idTicket ="${item.idTicket}">Pay</button>
							</td>
						</c:if>
						<c:if test="${item.status == true}">
							<td></td>
						</c:if>
						<td>
							<button class="btn btn-sm btn-primary btn-edit btnDelete" data-idTicket ="${item.idTicket}">Cancel</button>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<form>
		<input type="hidden" name = "idTicket">
	</form>
</body>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded",function()
	{
		var btnDeletes = document.getElementsByClassName("btnDelete");
		var btnPays = document.getElementsByClassName("btnPay");
		console.log(btnPays);
		for(var i = 0;i < btnPays.length;i++)
		{
			btnPays[i].onclick = function()
			{
				var id = this.getAttribute("data-idTicket");
				var data = {};
				var nut = this;
				data[""+"idTicket"+""] = id;
				$.ajax({
	                url: '${APIurl}',
	                type: 'put',
	                contentType: 'application/json',
	                data: JSON.stringify(data),
	                dataType: 'json',
	                success: function (result) {
	                    console.log(result);
	             		if(result.idTicket != -1)
	             		{
	             			nut.style.visibility = "hidden";
	             			var row = document.getElementById(result.idTicket).children;
	             			row[9].innerText = "Paided";
	             		}
	                },
	                error: function (error) {
	                    console.log(error);
	                }
	            });
			}
		}
		for(var i = 0;i < btnDeletes.length;i++)
		{
			btnDeletes[i].onclick = function()
			{
				var id = this.getAttribute("data-idTicket");
				var data = {};
				data[""+"idTicket"+""] = id;
				$.ajax({
	                url: '${APIurl}',
	                type: 'delete',
	                contentType: 'application/json',
	                data: JSON.stringify(data),
	                dataType: 'json',
	                success: function (result) {
	                    console.log(result);
	             		if(result.idTicket != -1)
	             		{
	             			var parent = document.getElementById("cha");
		                	var row = document.getElementById(result.idTicket);
		                	parent.removeChild(row);
	             		}	
	                },
	                error: function (error) {
	                    console.log(error);
	                }
	            });
			}
		}
		
				
	},false)
</script>
</html>