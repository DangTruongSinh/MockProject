<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">

  <!-- Link Swiper's CSS -->
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/swiper.min.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/css/index.css">

  <!-- Demo styles -->

</head>

<body>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#" style="background-image: url(img/icon.png);background-size: cover"> </a>

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
  <div class="jumbotron" id="slideshow">
      <div>
          <a type="button" id="sectionBtn" href="#sec1">Booking Ticket Now</a>
      </div>
    <div class="swiper-container">
      <div class="swiper-wrapper">
        <div id="slide"  class="swiper-slide" ></div>
        <div id="slide1" class="swiper-slide" ></div>
        <div id="slide2" class="swiper-slide" ></div>
        <div id="slide3" class="swiper-slide" ></div>
        <div id="slide4" class="swiper-slide" ></div>
      </div>
      <div class="swiper-pagination"></div>
    </div>
    <div id="sec1"></div>

  </div>
  <br>
  <br>
  <div id="ScrollImg" class="container section-1">
    <div id="Img-background" class="container text-center">
      <form action = "/QuanLyBus/customer-ticket">
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
        <div id="soluongve">
          <label class="soluongve"><b>Số Lượng Vé :</b></label>
          <br>
          <input class="input-TicketNumber" placeholder="1">
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
      </form>
    </div>
  </div>

  <br>
  <div id="Routes" class="jumbotron text-center ">
      <div></div>
      <div class="row fadein">
      <h2>Favorite Car Routes </h2>
        <div class="column">
          <p><a>Hồ Chí Minh city to Đà Lạt</a></p>
          <p><a>Hồ Chí Minh city to Nha Trang</a></p>
          <p><a>Hồ Chí Minh city to Cần Thơ</a></p>
          <p><a>Hồ Chí Minh city to Qui Nhơn</a></p>
          <p><a>Hồ Chí Minh city to Quảng Ngãi</a></p>
        </div>
        <div class="column">
          <p><a>Hồ Chí Minh city to Đà Nẵng</a></p>
          <p><a>Hồ Chí Minh city to Phan Thiết</a></p>
          <p><a>Hồ Chí Minh city to Vũng Tàu</a></p>
          <p><a>Hồ Chí Minh city to Hà Nội</a></p>
          <p><a>Hồ Chí Minh city to Huế</a></p>
        </div>
  
      </div>
   
    <div></div>
    <div class="row fadein">
        <h2>Famous Tourist Destination</h2>
      <div id="columnImg1" class="column">
        <p>Đà Lạt</p>
      </div>
      <div id="ImgRow" class="column">
        <p>Quảng Trường Lâm Viên nằm kế bên Hồ Xuân Hương, nơi đây thường là chỗ tụ tập của các
           bạn trẻ đến vui chơi, ăn uống. Đặc biệt, 2 công trình nghệ thuật ấn tượng nhất ở đây
           chính là khối hoa và búp hoa Dã Quỳ khổng lỗ giữa Quảng Trường.</p>
      </div>
    </div>

    <hr>
    
    <div class="row fadein">
        <div id="ImgRow" class="column">
            <p>Suối Đổ là một trong những con suối đẹp nhất ở Nha Trang. Nơi đây có bầu không khí 
              trong lành, mát mẻ, thích hợp với những du khách muốn tận hưởng không gian yên tĩnh 
              trong chuyến du lịch của mình.</p>
          </div>
        <div id="columnImg2" class="column">
          <p>Đà Lạt</p>
        </div>
      </div>

      <hr>
      
      <div class="row fadein">
          <div id="columnImg3" class="column">
            <p>Đà Lạt</p>
          </div>
          <div id="ImgRow" class="column">
            <p>"Hai bàn tay bằng đá khổng lồ vươn ra từ dãy núi ở miền trung Việt Nam trông có vẻ già 
              nua và giống như một tàn tích từ thời cổ đại. Nhưng bạn đừng bị đánh lừa. Đó là mạng lưới 
              dây kim loại và sợi thủy tinh được dùng để hỗ trợ cho một cây cầu đi bộ đáng kinh ngạc vừa 
              mới được khánh thành...", tạp chí Mỹ viết.</p>
          </div>
        </div>
  </div>

    <!-- Swiper JS -->
    <script src="view/js/swiper.min.js"></script>

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
</html>>