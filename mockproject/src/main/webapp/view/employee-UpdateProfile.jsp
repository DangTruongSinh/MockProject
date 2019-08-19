<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/ProfileCss.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  	<style type="text/css">
  		body{
		    background-image: url(${pageContext.request.contextPath}/view/img/backpack.png);
		    background-size: cover;
		    background-repeat: no-repeat;
		    font-family: 'Roboto', sans-serif;
    	}
    	
		.navbar{
		    margin-bottom: 0;
		    padding: 0 50px 0 50px ;
		    background-color: #fff;
		    font-family: nexa_rust_sansblack, helvetica, arial, sans-serif;
		    height: 70px;
		    border: unset;
		  }
		  @media (min-width: 768px){
		  .navbar-nav>li>a {
		    margin-top:15px;
		  }
		  }
		  .navbar-brand{
		  padding :35px;
		  }
		  .container{
		    background-color:  rgba(56, 57, 59, 0.6);
		    color: #fff;
		    margin-top: 50px;
		  }
		  .col-sm-9 li a{
		    color: #fff;
		  }
		  .col-sm-9 li a:hover{
		    color: #000;
		  }
  	</style>
</head>
<body id = "bo">
	<h1 style="text-align: center;">Welcome ${account.fullName}</h1>
    <div class="container bootstrap snippet">
        <div class="row">
            <div class="col-sm-2">
                <!--left col-->
                </hr><br>

			
            </div>
            <!--/col-3-->
            <div class="col-sm-9">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#home">Home</a></li> 
                </ul>


                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <hr>
                        <form class="form" action="/mockproject/employee-account?action=update" method="post" id="registrationForm">

                            <div class="form-group">
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email">
                                            <h4>Email</h4>
                                        </label>
                                      <input type="email" class="form-control" name="email" id="email"
                                       value = "${account.userName}" placeholder="you@email.com" title="enter your email." disabled >
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <label for="last_name">
                                        <h4>Full Name</h4>
                                    </label>
                                    <input type="text" class="form-control" name="fullName" id="last_name"
                                        placeholder="last name" title="enter your last name if any." value="${account.fullName}">
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="phone">
                                        <h4>Phone</h4>
                                    </label>
                                    <input type="text" class="form-control" name="phone" id="phone"
                                        placeholder="enter phone" title="enter your phone number if any." value="${account.phone}">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="mobile">
                                        <h4>Day Of Birth</h4>
                                    </label>
                                    <input type="date" class="form-control" name="dateBirth" id="mobile"
                                        placeholder="enter mobile number" title="enter your mobile number if any."
                                        value="${account.getStringDateBirth()}">
                                </div>
                            </div>
                            <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="password">
                                            <h4>Password</h4>
                                        </label>
                                        <input type="password" class="form-control" name="password" id="password" value = "${account.password}"
                                            placeholder="password" title="enter your password." pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"> 
                                    </div>
                            </div>

                        <hr>

                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save</button>

                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            href="${pageContext.request.contextPath}/employee-ticket" class="glyphicon glyphicon-ok-sign"></i> Back</button>

                                </div>
                            </div>
                            <input type="hidden" name = "idUser" value="${account.idUser}">
                        </form>
						

                    </div>
        
            </div>
            <!--/tab-content-->

        </div>
        <!--/col-9-->
    </div>
    <!--/row-->
</body>
<script>
    $(document).ready(function () {


        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('.avatar').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }


        $(".file-upload").on('change', function () {
            readURL(this);
        });
    });
</script>

</html>