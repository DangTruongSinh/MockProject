<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Ticket Seller</title>
<!-- paging for this template -->
<script src="/mockproject/view/js/Employeejquery.min.js"></script>
<script src="/mockproject/view/js/Employeebootstrap.min.js"></script>
<script src="/mockproject/view/js/Employeejquery.twbsPagination.js"></script>
<link href="/mockproject/view/css/Employeebootstrap.min.css"
	rel="stylesheet" type="text/css">

<!-- Custom fonts for this template -->
<link href="/mockproject/view/css/Employeeall.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS -->
<link href="/mockproject/view/css/EmployeedataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/mockproject/view/css/Employeesb-admin.css" rel="stylesheet">
<link href="/mockproject/view/css/EmployeeMyStyle.css" rel="stylesheet">
</head>
<body id="page-top">


	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="#">Ticket Seller</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">				
				<div class="input-group-append">
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item"
						href="/mockproject/view/employee-UpdateProfile.jsp">Settings</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="/mockproject/employee-ticket"> <i
					class="fas fa-fw fa-table"></i> <span>Tickets</span></a></li>
			<li class="nav-item active"><a class="nav-link"
				href="/mockproject/employee-seat"> <i class="fas fa-fw fa-table"></i>
					<span>Seats</span>
			</a></li>
		</ul>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item active">Tickets</li>
				</ol>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> View all tickets
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<!-- Search for UserName -->
							<select id = "selectlicensePlate">
								<c:forEach var="item" items="${licensePlates}">
									<option>${item}</option>
								</c:forEach>
							</select>
							<select id = "selectDateDepart">
								<c:forEach var="item" items="${dateDeparts}">
									<option>${item}</option>
								</c:forEach>
							</select>
							<select id = "selectOption">
								<option>All</option>
								<option>UnPay</option>
								<option>Payed</option>
							</select>
							<div class="mainInput">
								<div class="input-group">
									<input type="text" name="username" class="form-control"
											id="inputtext" placeholder="Search for UserName">
									<div class="input-group-append">
										<button class="btn btn-secondary" type="submit"
											form="formSearch">
											<i class="fa fa-search"></i>
											</button>
									</div>
								</div>
							</div>
							<!-- --- -->
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>LicensePlate</th>
											<th>Seat Number</th>
											<th>UserName</th>
											<th>FullName</th>
											<th>Phone</th>
											<th>Price</th>
											<th>Booking Date</th>
											<th>Route</th>
											<th>TimeDepart</th>
											<th>Status</th>
											<th>Cancel</th>
										</tr>
									</thead>
									<tbody id ="tableBody">
										<c:forEach begin="1" end = "${pageModel.maxPageItem}">
											<tr>
												<c:forEach begin="1" end = "11">
													<td/>
												</c:forEach>
											</tr>
										</c:forEach>
											

									</tbody>
								</table>
							<form id="formSubmit">
									<input type="hidden" id="curentPage" name="curentPage" value="">
							</form>	
						</div>
						<!-- paging -->
						<div class="container" id="pagingdiv" style="margin-top: 20px">
							<nav aria-label="Page navigation" id="navPagination">
								<ul class="pagination" id="pagination"></ul>
							</nav>
						</div>
						<!-- ---- -->
					</div>
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


	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary"
						href="/mockproject/dang-nhap?action=logout">Logout</a>
				</div>
			</div>
		</div>
	</div>


	<!-- paging script -->
<script type="text/javascript">
initPagination($("#selectlicensePlate option:selected").text()
			,$("#selectDateDepart option:selected").text(),$("#selectOption option:selected").text(),"");
		$("#inputtext").keyup(function(event) {
			if (event.keyCode == 13) {
				initPagination($("#selectlicensePlate option:selected").text()
						,$("#selectDateDepart option:selected").text(),$("#selectOption option:selected").text(),$(this).val());
			}
		});
		$('#selectlicensePlate').change(function(e) {
		    var optionSelected = $("option:selected", this);
		    var valueSelected = $( "#selectlicensePlate option:selected" ).text();
		    var data = {};
		    data[""+"licensePlate"+""] = valueSelected;
		    console.log(data);
		   
		    $.ajax({
	            url: '/mockproject/api-seat?action=getDate',
	            type: 'post',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	                console.log(result);
	                console.log("index:"+$("#selectDateDepart option:selected").index());
	                $("#selectDateDepart").children('option').remove();
	                console.log("index:"+$("#selectDateDepart option:selected").index());
	                for(i = 0;i < result.length;i++)
	                	{
	                	$('#selectDateDepart')
	                    .append($("<option></option>")
	                    			.attr("selected","selected")
	                               .text(result[i])); 
	                	}
	               		initPagination($("#selectlicensePlate option:selected").text()
	               			,$("#selectDateDepart option:selected").text(),$("#selectOption option:selected").text(),"");
	            },
	            error: function (error) {
	                console.log(error);
	            }
	        });
		    
		});		
		$('#selectDateDepart').change(function(e) {
			console.log("date:hhehe");
		    var optionSelected = $("option:selected", this);
		    var valueSelected = $( "#selectDateDepart option:selected" ).text();
		    console.log(valueSelected);
		    initPagination($("#selectlicensePlate option:selected").text()
           			,$("#selectDateDepart option:selected").text(),$("#selectOption option:selected").text(),"");
		});
		$('#selectOption').change(function(e) {
			console.log("date:hhehe");
		    var optionSelected = $("option:selected", this);
		    var valueSelected = $( "#selectDateDepart option:selected" ).text();
		    initPagination($("#selectlicensePlate option:selected").text()
           			,$("#selectDateDepart option:selected").text(),$("#selectOption option:selected").text(),"");
		});
		function initPagination(valueSelected,date,type,userName)
		{
			$('#pagination').html('');
		    $('#pagination').twbsPagination('destroy');
		    console.log($('#pagination'));
			$('#pagination').html('<ul id="pagination" class="pagination-sm"></ul>');
			console.log("dsadsadsa");
			var limit = 2;
		/*	var x = ${search};
			console.log("x:"+x);*/
			var curentPage = ${pageModel.curentPage};
			var totalPage = ${pageModel.totalPage};
			console.log("total:"+totalPage);
			$(function() {
				console.log(totalPage);
				window.pagObj = $('#pagination').twbsPagination({
					totalPages : totalPage,
					visiblePages : 10,
					startPage : curentPage,
					onPageClick : function(event, page) {
							console.log("page:"+page);
							$('#curentPage').val(page);
							var formData = $('#formSubmit').serializeArray();
						   	var data={};
						   	$.each(formData, function (i, v) {
						   		data[""+v.name+""] = v.value;
						   	});          
						   	console.log(data);
							$.ajax({
										url : '/mockproject/api-ticket?action=getAll&licensePlate='+valueSelected+"&date="
												+date+"&type="+type+"&userName="+userName,
										type : 'post',
										contentType : 'application/json',
										data : JSON.stringify(data),
										dataType : 'json',
										success : function(result) {
											handleSuccess(result);
										},
										error : function(error) {
											console.log(error);
										}
							});						
						
					}
				});
			});
		}
		function clearData()
		{
			var tableBody = document.getElementById("tableBody");
			var arrayTable = tableBody.children;
			for(var i = arrayTable.length - 1; i >= 0 ;i--)
			{
				var z = arrayTable[i].children;
				for(var j = 0; j < z.length; j++)
				{
					z[j].innerText = null;	
				}		
			}
		}
		
		
		
		function handleSuccess(result)
		{
			console.log(result);
			var tableBody = document.getElementById("tableBody");
			console.log(tableBody);
			var arrayTable = tableBody.children;
			clearData();
			
			for(var i = 0 ; i < result.length; i++)
			{
				if(arrayTable[i].children.length == 0)
				{
					for(j = 0; j < 11;j++)
					{
						const x = document.createElement("td");
						arrayTable[i].appendChild(x);
					}
				}
				var arrTd = arrayTable[i].children;
				var element = result[i];
				arrayTable[i].setAttribute("id",element.idTicket);
				console.log(element);
				arrTd[0].innerText = element.bus.licensePlate;
				arrTd[1].innerText = element.seat.name;
				arrTd[2].innerText = element.accModel.userName;
				arrTd[3].innerText = element.accModel.fullName;
				arrTd[4].innerText = element.accModel.phone;
				arrTd[5].innerText = element.price;
				var dateCreate = new Date(element.dateCreate);
				arrTd[6].innerText = dateCreate;
				arrTd[7].innerText = element.place.startPlace + " - " +element.place.stopPlace;
				var timeStart = new Date();
				var timeEnd = new Date();
				
				arrTd[8].innerText = element.place.timeStart +" - " 
				+ element.place.timeEnd;
				var node = document.createElement("a");
				if(arrTd[9].children[0] == null)
				{
					node.classList.add("btnStatus");
					node.classList.add("btn");   
					node.classList.add("btn-sm");
					node.classList.add("btn-primary");
					node.classList.add("btn-edit");
					var att = document.createAttribute("data-idTicket");
					att.value = element.idTicket;
					node.setAttributeNode(att);
					arrTd[9].appendChild(node);
					console.log(node);
				}
				arrTd[9].children[0].innerText = element.status;
				addEventForBtn("btnStatus","put");
				var node1 = document.createElement("a");
				if(arrTd[10].children[0] == null)
				{
					node1.classList.add("btnDelete");
					node1.classList.add("btn");   
					node1.classList.add("btn-sm");
					node1.classList.add("btn-primary");
					node1.classList.add("btn-edit");
					var att = document.createAttribute("data-idTicket");
					att.value = element.idTicket;
					node1.setAttributeNode(att);
					arrTd[10].appendChild(node1);
					console.log(node1);
				}
				arrTd[10].children[0].innerText = "Cancel";
				addEventForBtn("btnDelete","delete");
			}
			
		}
		function addEventForBtn(classNameBtn,method){
			var btnStatus = document.getElementsByClassName(classNameBtn);
			console.log("list:"+btnStatus.length);
			for(var i = 0;i < btnStatus.length;i++)
			{
				btnStatus[i].onclick = function()
				{
					console.log("btnStatus:");
					var id = this.getAttribute("data-idTicket");
					var data = {};
					var nut = this;
					data[""+"idTicket"+""] = id;
					console.log(data);
					$.ajax({
		                url: '/mockproject/api-ticket',
		                type: method,
		                contentType: 'application/json',
		                data: JSON.stringify(data),
		                dataType: 'json',
		                success: function (result) {
		                    console.log("cc:"+result);
		                    if(result == 1)
		                    {
		                    	if(classNameBtn.localeCompare('btnStatus') == 0)
		                    	{
		                    		var z = nut.innerText;
		                    		nut.innerText = true;
		                    	}
		                    	else
		                    	{
		     
				                	var row = document.getElementById(id);
				                	console.log(row);
				                	row.innerHTML = "";
		                    	}	
		                    }
		                    else
		                    {
		                    	
		                    	}
		                    
		             		
		                },
		                error: function (error) {
		                    console.log(error);
		                }
		            });
				}
			}
		}
		
</script>

	<!-- Bootstrap core JavaScript-->
	<script src="/mockproject/view/js/Employeebootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript  -->
	<script src="/mockproject/view/js/Employeejquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="/mockproject/view/js/Employeejquery.dataTables.js"></script>
	<script src="/mockproject/view/js/EmployeedataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/mockproject/view/js/Employeesb-admin.js"></script>

	<!-- Demo scripts for this page-->
	<script src="/mockproject/view/js/Employeedatatables-demo.js"></script>
</body>
</html>