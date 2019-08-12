<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="contaner">
		<form action="/QuanLyBus/customer-home?action=update" method="post">
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
</html>