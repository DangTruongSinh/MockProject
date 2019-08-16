<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%> 
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
     <h1>List Bus</h1>
	<div class="container">
		<table class="table " >
			<thead class="tbl-header"  cellpadding="0" cellspacing="0" >
				<tr>
			        <th>LicensePlate</th>
			        <th>PlaceStart</th>
			        <th>PlaceEnd</th>
			        <th>Date</th>
			        <th>TimeStart</th>
			        <th>TimeEnd</th>
			  		<th>EmptySeat</th>
			  		<th>Book</th>
      		</tr>
			</thead>
			<tbody class="tbl-content"> 
				<c:forEach var="item" items="${buss}">
   			<tr>
   				<td>${item.licensePlate}</td>
	   			<td>${item.place.startPlace}</td>
	   			<td>${item.place.stopPlace}</td>
	   			<td>${date}</td>
	   			<td>${item.place.getTimeStart()}</td>
	   			<td>${item.place.getTimeEnd()}</td>
	   			<td>${item.getNumberEmptySeat()}</td>
	   			<td>
	   			<c:if test="${item.getNumberEmptySeat() > 0}">
	   				<c:url var="book" value="/customer-ticket">
	   					<c:param name="action" value = "ticket"/>
	   					<c:param name="request" value="listseat" />
	   					<c:param name="startPlace" value="${item.place.startPlace}"></c:param>
	   					<c:param name="stopPlace" value="${item.place.stopPlace}"></c:param>
	   					<c:param name="timeStart" value ="${item.place.getTimeStart()}"></c:param>
	   					<c:param name="timeEnd" value ="${item.place.getTimeEnd()}"></c:param>
	   					<c:param name="idbus" value="${item.idBus}"/>
	   					<c:param name="date" value="${date}" />
	   				</c:url>
	   				<a class="btn btn-sm btn-primary btn-edit" href="${book}">Book</a>
	   			</c:if>
	   			</td>	
   			</tr>
   		</c:forEach>

			</tbody>
		</table>
	</div>
</body>
<script>
    $(window).on("load resize ", function() {
      var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
      $('.tbl-header').css({'padding-right':scrollWidth});
    }).resize();
    </script>
</html>

