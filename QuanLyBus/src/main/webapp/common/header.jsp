<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  
</head>
<body>
 <nav class="navbar navbar-inverse" style="background: #202020">
    <div class="container-fluid">
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="/QuanLyBus/customer-home">Home</a></li>
          <li class="nav-item">
            <a href="/QuanLyBus/customer-ticket?action=viewTicked">see book ticket</a>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/QuanLyBus/customer-home?action=update">Hello ${account.userName}</a></li>
          <li><a href="/QuanLyBus/dang-nhap?action=logout">Logout</a></li>
        </ul>
      </div>
    </div>
  </nav>	
</body>
</html>