<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  
</head>
<body>
	<nav class="navbar navbar-defaul">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#" style="background-image: url(${pageContext.request.contextPath}/view/img/icon.PNG);background-size: cover"></a>

      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="nav-item">
            <li><a href="/mockproject/customer-home">Home</a></li>
          </li>
          <li class="nav-item">
            <a href="/mockproject/customer-ticket?action=viewTicked">See BookedTicket</a>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/mockproject/customer-home?action=update" onclick="document.getElementById('id01').style.display='block'"
              style="width:auto;"><span class="glyphicon glyphicon-log-in"></span> Hello ${account.userName}</a></li>
          <li><a href="/mockproject/dang-nhap?action=logout" onclick="document.getElementById('id02').style.display='block'"
              style="width:auto;"><span class="glyphicon glyphicon-pencil"></span> LOGOUT</a></li>
        </ul>
      </div>
    </div>
  </nav>
</body>
</html>