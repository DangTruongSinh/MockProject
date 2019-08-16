<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>

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
<body style="margin-top: 30px">
	<div class="container bootstrap snippet">
        <!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a href="/QuanLyBus/admin-account">Home</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <form class="form" action="/QuanLyBus/admin-account?action=update" method="post" id="registrationForm">
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="first_name">
                                    <h4>User Name</h4>
                                </label>
                                <span class="form-control">${account.userName}</span>
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone">
                                    <h4>FullName</h4>
                                </label>
                                <input type="text" class="form-control" name = "fullName" value="${account.fullName}"
                  					placeholder="enter your fullName">
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
                                <label for="last_name">
                                    <h4>Role</h4>
                                </label>
                                <select class="select form-control">
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
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="mobile">
                                    <h4>Date Of Birth</h4>
                                </label>
                                <input class="form-control" type="date" name = "dateBirth" value="${account.getStringDateBirth()}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success" type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i> Update</button>
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
</body>
<script>
	$('.select').change(function(e) {
		var optionSelected = $("option:selected", this);
		var valueSelected = optionSelected.index() + 1;
		$("#roleSelect").val(valueSelected);
	});
</script>
</html>