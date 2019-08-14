<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
 <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">

  <!-- Link Swiper's CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/swiper.min.css">
  <script src="${pageContext.request.contextPath}/view/js/swiper.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/css/index.css">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">


  <!-- Demo styles -->

</head>

<body>

  <nav class="navbar navbar-defaul">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#" style="background-image: url(${pageContext.request.contextPath}/view/img/icon.PNG);background-size: cover"> </a>

      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="#">HIRES BUS</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">CONTACT</a>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/QuanLyBus/view/login.jsp" onclick="document.getElementById('id01').style.display='block'"
              style="width:auto;"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>
          <li><a href="/QuanLyBus/view/register.jsp" onclick="document.getElementById('id02').style.display='block'"
              style="width:auto;"><span class="glyphicon glyphicon-pencil"></span> REGISTER</a></li>
        </ul>
      </div>
    </div>
  </nav>


  <br>
  <div class="jumbotron">
    <!--------------------------header img containing Booking ticket form-------------------------------->


    <div class="container text-center" id="brand-img"
      style="background-image: url(${pageContext.request.contextPath}/view/img/brand-img.PNG);background-position: center;background-repeat: no-repeat;background-size: cover;">
      <br>
      <h1>Wellcome To HBUS</h1>
      <h2>Lets Begin!</h2>


       <!---------------------------Booking ticket form -------------------------------------------------->
      <div id="header-img" class="container">
        <div id="diemkhoihanh">
          <label for="diemkhoihanh"><b>Điểm Khởi Hành :</b></label>
          <br>
          <input list="start-input" class="input-start" name="start-input">
          <datalist id="start-input">
            <option value="Bến Xe Miền Đông">
            <option value="Ngã ba">
            <option value="Ngã tư">
            <option value="Ngã 5">
            <option value="Ngã 6">
          </datalist>
        </div>
        <div id="diemden">
          <label for="diemden"><b>Điểm đến :</b></label>
          <br>
          <input list="start-end" class="input-end" name="start-end">
          <datalist id="start-end">
            <option value="Đà Lạt">
            <option value="Nha Trang">
            <option value="Đà Nẵng">
            <option value="Ngã 5">
            <option value="Ngã 6">
          </datalist>
        </div>
        <div id="ngaykhoihanh">
          <label for="ngaykhoihanh"><b>Ngày Khởi Hành :</b></label>
          <br>
          <input class="input-date" type="date" name="bday">
        </div>
        <div class="submit-button">
          <br>
          <button type="submit" class="btn submit">
            <span>
              Booking Ticket
            </span>
          </button>
        </div>
      </div>
      <!--------Booking ticket form end here------>
    </div>

  </div>
  </div>

  <br>

  <!---------------------Welcome Fomr with icons------------------------->
  <div id="services" class="container-fluid text-center">
    <h2>Welcome to HBUS </h2>
    <h4>We bring convenience to your trip</h4>
    <br>
    <div class="row slideanim">
      <div class="col-sm-4">
        <span class="glyphicon glyphicon-road logo-small"></span>
        <h4>SAFE</h4>
        <p>Ensure safety on each trip</p>
      </div>
      <div class="col-sm-4">
        <span class="glyphicon glyphicon-time logo-small"></span>
        <h4>FAST</h4>
        <p>Quick ticket booking</p>
      </div>
      <div class="col-sm-4">
        <span class="glyphicon glyphicon-lock logo-small"></span>
        <h4>Profession</h4>
        <p>Professional working style</p>
      </div>
    </div>
    <br><br>
    <div class="row slideanim">
      <div class="col-sm-4">
        <span class="glyphicon glyphicon-usd logo-small"></span>
        <h4>Saving</h4>
        <p>Save more with affordable fares</p>
      </div>
      <div class="col-sm-4">
        <span class="glyphicon glyphicon-thumbs-up logo-small"></span>
        <h4>High Quality</h4>
        <p> \Provide high-class cars with high quality</p>
      </div>
      <div class="col-sm-4">
        <span class="glyphicon glyphicon-cutlery logo-small"></span>
        <h4 style="color:#303030;">Service</h4>
        <p>The service comes perfectly</p>
      </div>
    </div>
  </div>
<!------------------Welcome Fomr with icons end here------------------------>

  <br>
  <div class="jumbotron" id="TopDes">
    <div style="background: #74A600;height: 200px;">
      <h2>Top destinations </h2>
      <p>Do you want to be inspired to travel? We have selected for you the destinations below.</p>
    </div>
  </div>

<!--------------------------destinations-------------------------------->
  <div id="portfolio" class="container-fluid text-center bg-grey">
    <div class="row text-center slideanim">
      <div class="col-sm-4">
        <div class="thumbnail">
          <img src="${pageContext.request.contextPath}/view/img/img1.png" alt="Paris" width="400" height="300">
          <div class="centered">
          <h3><strong>Đà Lạt</strong></h3>
          </div>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
          <img src="${pageContext.request.contextPath}/view/img/img2.png" alt="New York" width="400" height="300">
          <div class="centered">
          <h3><strong>Nha Trang</strong><h3>
          </div>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
          <img src="${pageContext.request.contextPath}/view/img/img3.jfif" alt="San Francisco" width="400" height="300">
          <div class="centered">
          <h3><strong>Đà Nẵng</strong></h3>
        </div>
        </div>
      </div>
    </div>
  </div>
    <div id="portfolio" class="container-fluid text-center bg-grey">
      <div class="row text-center slideanim">
        <div class="col-sm-4">
          <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/view/img/img4.png" alt="Paris" width="400" height="300">
            <div class="centered">
            <h3><strong>Ninh Bình</strong></h3>
            </div>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/view/img/img5.png" alt="New York" width="400" height="300">
            <div class="centered">
            <h3><strong>Phan Thiết</strong></h3>
            </div>
          </div>
        </div>
        <div class="col-sm-4">
          <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/view/img/img6.png" alt="San Francisco" width="400" height="300">
            <div class="centered">
            <h3><strong>Hội An</strong></h3>
            </div>
          </div>
        </div>
      </div>
    </div>
<!------------destinations end here----------------->



  <div class="jumbotron" id="TopDes">
    <div style="background: #9A4542;height: 200px;">
      <h2>High quality car staging </h2>
      <p>Ensuring comfort , safety and comfort for customers</p>
    </div>
  </div>



  <!------------------------slideshow-------------------------------->
  <div class="jumbotron" id="slideshow">
    <div class="swiper-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath}/view/img/imgslide3.png)"></div>
        <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath}/view/img/imgslide1.png)"></div>
        <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath}/view/img/imgslide2.png)"></div>
        <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath}/view/img/imgslide.png)"></div>
        <div class="swiper-slide" style="background-image:url(${pageContext.request.contextPath}/view/img/imgslide4.png)"></div>
      </div>
      <div class="swiper-pagination"></div>
    </div>
    <p>   Draw To View </p>
  </div>
    <!------------------------slideshow end here---------------------->
  <br>
  <br>

</body>
<footer class="page-footer font-small teal pt-4">

  <!-- Footer Text -->
  <div class="container-fluid text-center text-md-left">

    <!-- Grid row -->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-4 mt-md-0 mt-4 " >

        <!-- Content -->
        <h5 class="text-uppercase font-weight-bold "><strong>THÔNG TIN</strong></h5>
        <p>Về Chúng Tôi</p>
        <p>Danh sách nhà vận chuyển</p>
        <p>Trợ giúp</p>
        <p>Blog</p>

      </div>
      <!-- Grid column -->
      <div class="col-md-2 mb-md-0 mb-4">

        <!-- Content -->
        <h5 class="text-uppercase font-weight-bold"><strong>THEO DÕI CHÚNG TÔI</strong></h5>
        <p><a>FaceBook</a></p>
        <p><a>Instagram</a></p>
        <p><a>Twitter</a></p>
      </div>
      <div class="col-md-6 mt-md-0 mt-4 " >
        <div class="icon-footer"></div>
        <br>
        <h5  class="font-weight-bold ">Your pleasure is our happiness</h5>
      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Text -->



</footer>
<!-- Swiper JS -->


<!-- Initialize Swiper -->
<script>
  var swiper = new Swiper('.swiper-container', {
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: 'auto',
    coverflowEffect: {
      rotate: 50,
      stretch: 0,
      depth: 100,
      modifier: 1,
      slideShadows: true,
    },
    pagination: {
      el: '.swiper-pagination',
    },
  });
</script>
<!-- Fadein jquery + js -->
<script>
  $(document).ready(function () {
    $(window).scroll(function () {
      $('.fadein').each(function (i) {

        var bottom_of_element = $(this).offset().top + $(this).outerHeight();
        var bottom_of_window = $(window).scrollTop() + $(window).height();

        if (bottom_of_window > bottom_of_element) {
          $(this).animate({ 'opacity': '1' }, 1000);
        }

      });
    });
  });
  $(window).scroll(function () {
    $(".slideanim").each(function () {
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
      if (pos < winTop + 600) {
        $(this).addClass("slide");
      }
    });
  });
</script>




<!---------->
</html>