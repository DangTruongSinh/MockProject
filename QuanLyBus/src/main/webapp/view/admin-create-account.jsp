<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
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
<body>
<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a href="/QuanLyBus/admin-account">Home</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <form method="post" action="/QuanLyBus/admin-account?action=create">
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="first_name">
                                    <h4>User Name</h4>
                                </label>
                                <input type="text" class="form-control" name="username" placeholder="Enter username">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone">
                                    <h4>Phone</h4>
                                </label>
                                <input type="text" class="form-control" name="phone" placeholder="enter phone">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="last_name">
                                    <h4>PassWord</h4>
                                </label>
                                <input type="text" class="form-control" name="password" placeholder="PassWord">
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile">
                                    <h4>Date Of Birth</h4>
                                </label>
                                <input type="date" class="form-control" name="ngaysinh" value="dd/mm/yyyy">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="email">
                                    <h4>Full Name</h4>
                                </label>
                                <input type="text" class="form-control" name="fullname" placeholder="Enter your fullname">
                            </div>
                        </div>
                        <div class="form-group select">
                            <div class="col-xs-6">
                                <label for="email">
                                    <h4>Role</h4>
                                </label>
                                <select class="form-control">
                                    <option>admin</option>
                                    <option>employee</option>
                                    <option>customer</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i> Create</button>
                            </div>
                        </div>
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
</body>
<script>
    $('.select').change(function(e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = optionSelected.index() + 1;
            console.log(valueSelected);
        $("#roleSelect").val(valueSelected);
    });
</script>
</html>