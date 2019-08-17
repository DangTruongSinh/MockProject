<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="utf-8">

  <!-- Link Swiper's CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/swiper.min.css">
 <head>
  <meta charset="utf-8">

  <!-- Link Swiper's CSS -->
  <link rel="stylesheet" href="css/swiper.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="BookingTicket.css">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">


  <!-- Demo styles -->

</head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/BookingTicket.css">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <!-- Demo styles -->
</head>

<body>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#" style="background-image: url(${pageContext.request.contextPath}/view/img/icon.png);background-size: cover"> </a>

      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="/mockproject/customer-home">HOME</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/mockproject/customer-ticket?action=viewTicked">See BookedTicket</a>
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
  <!--Slideshow-->
  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <table>
          <div class="cockpit">
            <h1>Select seat</h1>
          </div>
           <!-- Thông báo đã đặt đu số vé -->
           <c:if test="${slvedadat == 5}">
              <div class="alert alert-danger" style="font-size: 18px; text-align: center;">
            <strong>Chú ý:</strong> Bạn đã đặt đủ 5 vé!
        </div>
           </c:if>
          <tbody>
            <div class="plane">
              <ol class="cabin fuselage">
                <li class="row row--1">
                  <ol class="seats" type="A">
                    <li class="seat">
                      <input type="checkbox" name="1" id="1" value=100/>
                      <label for="1">01</label>
                    </li>
                    <li class="seat">
                      <input type="checkbox" name="2" id="2" value=100/>
                      <label for="2">02</label>
                    </li>
                    <li class="seat">
                      <input type="checkbox" id="3" name="3" value=100/>
                      <label for="3">03</label>
                    </li>
                    <li class="seat">
                      <input type="checkbox" id="4" value=100 name="4"/>
                      <label for="4">04</label>
                    </li>
                  </ol>
                </li>
                <li class="row row--2">
                  <ol class="seats" type="A">
                    <li class="seat">
                      <input type="checkbox" id="5" value=100 name="5"/>
                      <label for="5">05</label>
                    </li>
                    <li class="seat">
                      <input type="checkbox" id="6" value=100 name="6"/>
                      <label for="6">06</label>
                    </li>
                    <li class="seat">
                      <input type="checkbox" id="7" value=100 name="7"/>
                      <label for="7">07</label>
                    </li>
                    <li class="seat">
                      <input type="checkbox" id="8" value=100 name="8"/>
                      <label for="8">08</label>
                    </li>

                </li>
              </ol>
              </li>
              <li class="row row--3">
                <ol class="seats" type="A">
                  <li class="seat">
                    <input type="checkbox" id="9" value=100 name="9"/>
                    <label for="9">09</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="10" value=100 name="10"/>
                    <label for="10">10</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="11" value=100 name="11"/>
                    <label for="11">11</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="12" value=100 name="12"/>
                    <label for="12">12</label>
                  </li>
                  <!-- Chu thich-->
                  <li class="seat" style="margin-left: 20px;">
                    <input type="checkbox" checked = false/>
                    <label></label>
                  </li>
                  <span style="margin-top: 10px;">Book</span>
                  <!-- End Chu thich-->
              </li>
              </ol>
              </li>
              <li class="row row--4">
                <ol class="seats" type="A">
                  <li class="seat">
                    <input type="checkbox" id="13" value=100 name="13"/>
                    <label for="13">13</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="14" value=100 name="14"/>
                    <label for="14">14</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="15" value=100 name="15"/>
                    <label for="15">15</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="16" value=100 name="16"/>
                    <label for="16">16</label>
                  </li>
                  <!-- Chu thich-->
                  <li class="seat" style="margin-left: 20px;">
                    <input type="checkbox"/>
                    <label></label>
                  </li>
                  <span style="margin-top: 10px;">Empty</span>
                  <!-- End Chu thich-->
              </li>
              </ol>
              </li>
              <li class="row row--5">
                <ol class="seats" type="A">
                  <li class="seat">
                    <input type="checkbox" id="17" value=100 name="17"/>
                    <label for="17">17</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="18" value=100 name="18"/>
                    <label for="18">18</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="19" value=100 name="19"/>
                    <label for="19">19</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="20" value=100 name="20"/>
                    <label for="20">20</label>
                  </li>
        <!-- Chu thich-->
                  <li class="seat" style="margin-left: 20px;">
                    <input type="checkbox" disabled="disabled"/>
                    <label></label>
                  </li>
                  <span style="margin-top: 10px;">Booked</span>
                  <!-- End Chu thich-->
              </li>
              </ol>
              </li>
              <li class="row row--6">
                <ol class="seats" type="A">
                  <li class="seat">
                    <input type="checkbox" id="21" value=100 name="21"/>
                    <label for="21">21</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="22" value=100 name="22"/>
                    <label for="22">22</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="23" value=100 name="23"/>
                    <label for="23">23</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="24" value=100 name="24"/>
                    <label for="24">24</label>
                  </li>

              </li>
              </ol>
              </li>
              <li class="row row--7">
                <ol class="seats" type="A">
                  <li class="seat">
                    <input type="checkbox" id="25" value=100 name="25"/>
                    <label for="25">25</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="26" value=100 name="26"/>
                    <label for="26">26</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="27" value=100 name="27"/>
                    <label for="27">27</label>
                  </li>
                  <li class="seat">
                    <input type="checkbox" id="28" class="checking" name="28"/>
                    <label for="28">28</label>
                  </li>

              </li>
              </ol>
              </li>
            </div>
      </div>
      </tbody>
      </table>
    </div>
    <div class="col-sm-8">
      <div class="well">
        <p>Tuyến xe</p>
        <input type="text" style="color: red" disabled value ="${startPlace} - ${stopPlace}">
        <p>Ngày khởi hành</p>
        <input class="input-start" disabled type="text" name="time-input" value="${date}">
        <p>Giờ khởi hành - Giờ tới bến</p>
        <input class="input-start" disabled type="text" name="time-input" value="${timeStart} - ${timeEnd}">
        <datalist id="start-input">
          <option value="Thủ Đức:798 XLHN ,P.Hiệp Phú ,Q9 , TpHCM">
          <option value="Hàng Xanh :486H-486J , Điện Biên Phủ ,P.21, P. Bình Thạnh">
        </datalist>
        <p>Giá Tiền</p>
        <span id="giatien"></span>
        <br>
        <c:url var="urlBack" value="/customer-ticket">
          <c:param name="action" value = "ticket"/>
        <c:param name="request" value="listbus"/>
        <c:param name="startPlace" value="${startPlace}"/>
        <c:param name="endPlace" value="${stopPlace}"/>
        <c:param name="date" value="${date}"/>
        >
        </c:url>
        <div style="display: flex;">
          <a href="${urlBack}"><button class="btn btn-success">Quay lại</button></a>
          <form action="/mockproject/customer-ticket" id = "formDat">
            <input type = "hidden" name="action" value = "ticket">
            <input type = "hidden" name="request" value="book"/>
            <input type = "hidden" name ="idbus" value = "${idbus}">
            <input type = "hidden" name ="listBookedSeat" id = "listBookedSeat">
            <input type="hidden" name = "price" value = "${bus.place.price}">
            <input type="hidden" name="date" value = "${date}">
            <button type="submit" class="btn btn-primary" id = "btnBook" style="margin-left: 20px">Đặt vé</button>
          </form>
        </div>        
      </div>

    </div>
  </div>
  <hr>
  </div>


</body>
<footer class="page-footer font-small teal pt-4">

  <!-- Footer Text -->
  <div class="container-fluid text-center text-md-left">

    <!-- Grid row -->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-6 mt-md-0 mt-3">

        <!-- Content -->
        <h4 class="text-uppercase font-weight-bold"><strong>About Us</strong></h4>
        <p>FaceBook : Huynhtin</p>
        <p>Gmail: tinanhtom02@gmail.com</p>

      </div>
      <!-- Grid column -->
      <div class="col-md-6 mb-md-0 mb-3">

        <!-- Content -->
        <h4 class="text-uppercase font-weight-bold"><strong></strong></h4>
        <p>© Công ty TNHH Easybook.com 2006-2019. Đã Đăng Ký Bản Quyền</p>
        <p>Giấy phép TA: 02152</p>
        <p>Giấy phép số: KPK/LN:6768</p>
        <p>Địa chỉ IP của bạn: 1.54.57.180</p>
      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Text -->
</footer>
<script>
  var x = ${slvedadat};
  if (x == 5)
    $("#btnBook").hide();
  console.log("so ve con lai:"+x);
  var tien = 0;
  var result = ${bus.getListBookedSeat()};
  var listIdSeat = ${bus.getListIdSeat()};
  console.log(listIdSeat);
  console.log(result);
  var listBookedSeat=[];
  console.log("hhehe :"+listIdSeat);
  for(i = 1; i <= 28;i++)
    {
      document.getElementById(i).value = listIdSeat[i-1];
      listBookedSeat[i] = 0;
    }
  for(i = 0;i < result.length;i++)
  {
     if(result[i] != 0)
     {
       document.getElementById(result[i]).checked = true;
       document.getElementById(result[i]).disabled = "disabled";
     }
   }
  $("input").click(function(event) {
      console.log(this);
      if(this.checked == true)
      {
        if(x < 5) 
        {
          x++;
          tien += ${bus.place.price};
          document.getElementById("giatien").innerHTML = tien+"$";
          listBookedSeat[this.id] = 1;
          console.log(listIdSeat);
        }
        else
         {
          alert("Số vé được đặt tối đa = 5");
          document.getElementById(this.id).checked = false;
         } 
      }
      else
        if(x >= 0) 
        {
          x--;
          tien -= ${bus.place.price} ;
          document.getElementById("giatien").innerHTML = tien+"$";
          listBookedSeat[this.id] = 0;
        } 
  });
 $("#formDat").submit(function(){
  var result="";
  for(i = 1; i <= 28;i++)
  {
    if(listBookedSeat[i] == 1)
      result = result + document.getElementById(i).value + ",";
  }
   $("#listBookedSeat").val(result);
});
</script>
</html>