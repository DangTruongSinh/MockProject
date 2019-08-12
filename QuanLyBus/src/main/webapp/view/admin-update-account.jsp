<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="contaner">
		<form action="/QuanLyBus/admin-account?action=update" method="post">
			<div class="row">
				<p>username</p>
				<p>${account.userName}</p>
			</div>
			<div class="row">
				<p>fullName</p>
				<input type="text" name = "fullName" value="${account.fullName}">
			</div>
			<div class="row">
				<p>Password</p>
				<input type="text" name = "password" value="${account.password}">
			</div>
			<div class="row">
				<p>role</p>
				<select title="Pick a number" class="select">
					<c:forEach var="role" items="${roles}">
						<c:if test="${role.idRole == account.idRole}">
							<option selected="selected">${role.name}</option>
						</c:if>
						<c:if test="${role.idRole != account.idRole}">
							<option>${role.name}</option>
						</c:if>
					</c:forEach>
				</select>
				<input type="hidden" name = "idRole" id = "roleSelect" value = "${account.idRole}">
			</div>
			
			<div class="row">
				<p>Phone</p>
				<input type="text" name = "phone" value="${account.phone}">
			</div>
			<div class="row">
				<p>DateBirth</p>
				<input type="date" name = "dateBirth" value="${account.getStringDateBirth()}">
			</div>
			<input type="hidden" name = "idUser" value="${account.idUser}">
			<button type="submit">update</button>
		</form>
	</div>
</body>
<script>
	$('.select').change(function(e) {
		var optionSelected = $("option:selected", this);
		var valueSelected = optionSelected.index() + 1;
		$("#roleSelect").val(valueSelected);
	});
</script>
</html>