<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form method="post" action="/QuanLyBus/admin-account?action=register">
		<input placeholder="Enter your username" name="username"> 
		<input placeholder="Enter your password" type="password" name="password">
		<input placeholder="Repeat your password" type="password">
		<input placeholder="Enter your fullName" type="text" name = "fullname">
		<input placeholder="Enter your phone" type="text" name = "phone">
		<input type="date" id="dfb" value="dd/mm/yyyy" name="ngaysinh">
		<button type="submit">create</button>
	</form>
	</div>
</body>
</html>