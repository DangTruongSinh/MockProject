<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="../../common/header.jsp"%>
	<div class="container">
  <h2>List Bus</h2>         
  <table class="table">
    <thead>
      <tr>
        <th>LicensePlate</th>
        <th>PlaceStart</th>
        <th>PlaceEnd</th>
        <th>TimeStart</th>
  		<th>EmptySeat</th>
  		<th>Book</th>
      </tr>
    </thead>
    <tbody>
   		<c:forEach var="item" items="${buss}">
   			<tr>
   				<td>${item.licensePlate}</td>
	   			<td>${item.placeStart}</td>
	   			<td>${item.placeEnd}</td>
	   			<td>${item.getGioBatDau()}</td>
	   			<td>${item.getNumberEmptySeat()}</td>
	   			<td>
	   				<c:if test="${item.getNumberEmptySeat() > 0 && item.getGioBatDau() ne ''
	   				&& item.placeStart ne '' && item.placeEnd ne ''}">
	   					<c:url var="book" value="/customer-ticket">
	   						<c:param name="action" value = "ticket"/>
	   						<c:param name="request" value="listseat" />
	   						<c:param name="idbus" value="${item.idBus}" />
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
</html>