<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/Register.css">

<script src="${pageContext.request.contextPath}/view/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/view/js/Register.js"></script>
</head>
<body>

		<div class="container-fluid bg">
			<div class="row justify-content-center">
				<div class="col-md-3 col-sm-6 col-xs-12 row-container">
					<form method="post" onsubmit="validateForm()"
						action="${pageContext.request.contextPath}/dang-nhap?action=register">
						<c:if test="${not empty message}">
							<div style="font-size: 20px;text-align: center;" class="alert alert-${alert}">${message}</div>
						</c:if>
						<div class="titlelogin">
							<div class="icon" style="background-image: url(${pageContext.request.contextPath}/view/img/icon.png)"></div>
							<h1>
								<strong>Register</strong>
							</h1>
						</div>
						<div class="form-group">
							<input class="form-control" id="email"
								placeholder="Enter your username" name="username">
							<p class="emailError"></p>
						</div>
						<div class="form-group"></div>
						<input name="password" type="password" class="form-control"
							id="password" placeholder="Password"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
						<p class="passwordError"></p>
						<div class="form-group">
							<input type="password" class="form-control" id="repassword"
								placeholder="Repeat Password">
							<p class="repasswordError"></p>
						</div>
						<div class="form-group">
							<input name="fullname" type="text" class="form-control"
								id="fullname" placeholder="Full Name">
							<p class="passwordError"></p>
						</div>
						<div class="form-group">
							<input name="phone" type="tel" class="form-control"
								id="phonenumber" placeholder="Phone Number"
								onkeypress="return keyPhone(event);"
								pattern="^\+?(?:[0-9]??).{5,14}[0-9]$">
							<p class="passwordError"></p>
						</div>
						<div class="form-group">
							<input name="ngaysinh" type="date" class="form-control" id="dfb"
								value="dd/mm/yyyy">
							<p class="passwordError"></p>
						</div>
						<div class="form-group">
							<button type="submit" id="submitbtn"
								class="btn btn-success btn-block">Register</button>
						</div>
					</form>
					<ul class="share">
						<li class="middle">
						<a class="share-icon" href="#"><i
								class="fa fa-share-square-o"></i></a> 
						<a class="facebook" href="#"></a>
						<a class="twitter" href="#"></a>
						</li>

					</ul>
					<div id="backhomeText" >
						<label><a href="${pageContext.request.contextPath}/home-web" class="homeLink">
									Back to Home</a></label>
					</div>
				</div>
			</div>
		</div>


	
	<script src="js/classie.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</body>

</html>