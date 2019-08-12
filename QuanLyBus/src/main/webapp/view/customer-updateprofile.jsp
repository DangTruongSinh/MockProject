<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/ProfileCss.css">
</head>
<%@include file="../../common/header.jsp"%>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10">
            <h1>Wellcome ${account.userName}</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <!--left col-->


            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                    alt="avatar">
                <h6>Upload a different photo...</h6>
                <input type="file" class="text-center center-block file-upload">
            </div>
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
                    <form class="form" action="/QuanLyBus/customer-home?action=update" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name">
                                    <h4>Full Name</h4>
                                </label>
                                <input type="text" class="form-control"  name = "fullName" value="${account.fullName}" id="first_name"
                                    placeholder="fullName">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone">
                                    <h4>Phone</h4>
                                </label>
                                <input type="text" class="form-control" name = "phone" value="${account.phone}" id="phone"
                                    placeholder="enter phone" title="enter your phone number if any.">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="last_name">
                                    <h4>PassWord</h4>
                                </label>
                                <input type="text" class="form-control" name = "password" value="${account.password}" id="last_name"
                                    placeholder="Pass word" title="enter your last name if any.">
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile">
                                    <h4>Date Of Birth</h4>
                                </label>
                                <input type="date" class="form-control" name = "dateBirth" value="${account.getStringDateBirth()}" id="mobile"
                                    title="enter your mobile number if any.">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i> Save</button>
                            </div>
                        </div>
                        <input type="hidden" name = "idUser" value="${account.idUser}">
                    </form>

                    <hr>

                </div>

            </div>
            <!--/tab-pane-->
        </div>
        <!--/tab-content-->

    </div>
    <!--/col-9-->
</div>
<!--/row-->