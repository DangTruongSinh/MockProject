<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Admin Mangerment</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <script
  src="${pageContext.request.contextPath}/view/js/jquery.twbsPagination.js"
  type="text/javascript"></script>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/view/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/view/css/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/view/css/sb-admin.css" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/Admin.css"/>

</head>

<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
    <img src="view/img/brand-icon.PNG">
    <a class="navbar-brand mr-1" href="/mockproject/view/login.jsp">Bus Admin</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
      <div class="input-group">
       <form action="/mockproject/admin-account" id="formSearch">
        <input type="text" class="form-control" name="username" id="inputtext" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
        <div class="input-group-append">
          <input type="hidden" name="action" value="search">
          <button  class="btn btn-success btn-xs">Search</button>
        </div>
      </form>
    </div>
  </form>

  <!-- Navbar -->
  <ul class="navbar-nav ml-auto ml-md-0">
    <li class="nav-item dropdown no-arrow">
      <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-user-circle fa-fw"></i>
      </a>
      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
        <a class="dropdown-item" href="#">Settings</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
      </div>
    </li>
  </ul>

</nav>

<div id="wrapper">

  <!-- Sidebar -->
  <ul class="sidebar navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/mockproject/view/login.jsp">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Admin Manger</span>
      </a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-fw fa-folder"></i>
        <span>Account</span>
      </a>
      <div class="dropdown-menu" aria-labelledby="pagesDropdown">
        <h6 class="dropdown-header">Account Manger:</h6>
        <a class="dropdown-item" href="/mockproject/view/login.jsp">View all account</a>
        <a class="dropdown-item" href="/mockproject/view/admin-create-account.jsp">Create account</a>
      </div>
    </li>
  </ul>

  <div id="content-wrapper">

    <div class="container-fluid">

      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="/mockproject/view/login.jsp">Home</a>
        </li>
        <li class="breadcrumb-item active">Update Form</li>
      </ol>

      <!-- DataTables Example -->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fas fa-table"></i>
        Form </div>
        <div class="card-body">
          <form  class="form-horizontal" action="/mockproject/admin-account?action=update" method="post">
            <fieldset>
              <div id="legend">
                <legend class="">Information</legend>
              </div>
              <div class="content-table">
                <div class="control-group">
                  <!-- Username -->
                  <label class="control-label"  for="username">Username</label>
                  <div class="controls">
                    <input type="text" id="username" name="username" value="${account.userName}" class="form-control">
                  </div>
                </div>

                <div class="control-group">

                  <label class="control-label" for="password">Password</label>
                  <div class="controls">
                   
                    <input type="password" id="psw" name="password" class="form-control" value="${account.password}" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
                  </div>
                </div>

                <div class="control-group">
                  <!-- Password-->
                  <label class="control-label" for="password">Re-Password</label>
                  <div class="controls">
                   <input type="password" id="repsw" name="re-password" value = "${account.password}" class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
                   <div id="message">
                    <h3>Password must contain the following:</h3>
                    <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
                    <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
                    <p id="number" class="invalid">A <b>number</b></p>
                    <p id="length" class="invalid">Minimum <b>8 characters</b></p>
                  </div>
                </div>
              </div>

              <div class="control-group">

                <label class="control-label"  for="fullname">Full Name</label>
                <div class="controls">
                  <input type="text" id="fullname" name="fullName" value="${account.fullName}" class="form-control">
                </div>
              </div>

              <div class="control-group">

                <label class="control-label"  for="phone">Phone</label>
                <div class="controls">
                  <input type="tel" id="phone" name="phone" placeholder="" class="form-control" pattern="^\d{10}$" title="Must contain 10 numbers" required value = "${account.phone}">
                </div>
              </div>

              <div class="control-group">

                <label class="control-label"  for="daybirth">Date of Birth</label>
                <div class="controls">
                  <input type="date" id="daybirth" name="dateBirth" value="${account.getStringDateBirth()}" class="form-control">
                </div>
              </div>

              <div class="control-group">

                <label class="control-label">Role</label>
                <div class="controls">
                  <select  class="select">
                    <c:forEach var="role" items="${roles}">
                    <c:if test="${role.idRole == account.idRole}">
                    <option selected="selected">${role.name}</option>
                  </c:if>
                  <c:if test="${role.idRole != account.idRole}">
                  <option>${role.name}</option>
                </c:if>
              </c:forEach>
            </select>
            <input type="hidden" name = "idUser"  value = "${account.idUser}">
            <input type="hidden" name = "idRole" id = "roleSelect" value = "${account.idRole}">
          </div>
        </div>
        <div class="control-group">
          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success" type="submit">Update</button>
          </div>
        </div>
      </div>
    </fieldset>
  </form>
</div>
</div>

<!-- /.container-fluid -->

<!-- Sticky Footer -->
<footer class="sticky-footer">
  <div class="container my-auto">
  
    <div class="copyright text-center my-auto">
      <span>Copyright © Java50team</span>
    </div>
  </div>
</footer>

</div>
<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="/mockproject/dang-nhap?action=logout">Logout</a>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/view/js/jquery.min.js"></script>
<script src="/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/view/js/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="${pageContext.request.contextPath}/view/js/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/view/js/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/view/js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="${pageContext.request.contextPath}/view/js/datatables-demo.js"></script>
</body>

<script>
  var myInput = document.getElementById("psw");
  var letter = document.getElementById("letter");
  var letter = document.getElementById("letter");
  var capital = document.getElementById("capital");
  var number = document.getElementById("number");
  var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>
<script>
  var password = document.getElementById("psw")
  , confirm_password = document.getElementById("repsw");

  function validatePassword(){
    if(password.value != confirm_password.value) {
      confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
      confirm_password.setCustomValidity('');
    }
  }

  password.onchange = validatePassword;
  confirm_password.onkeyup = validatePassword;
</script>
<script>
  $('.select').change(function(e) {
    var optionSelected = $("option:selected", this);
    var valueSelected = optionSelected.index() + 1;
    $("#roleSelect").val(valueSelected);
  });
</script>
</html>