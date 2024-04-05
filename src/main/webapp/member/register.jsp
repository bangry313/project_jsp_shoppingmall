<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>JSP 실습</title>
  <!-- Bootstrap core CSS -->
  <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="/css/simple-sidebar.css" rel="stylesheet">
</head>

<body>
  
  <div class="d-flex" id="wrapper">
    
    <!-- Sidebar Start -->
    <jsp:include page="/module/sidebar.jsp" />
    <!-- Sidebar End -->

    <!-- Page Content Start -->
    <div id="page-content-wrapper">
      
      <!-- Nav Start -->
      <jsp:include page="/module/nav.jsp" />
      <!-- Nav End -->

      <!-- Contents Start -->
      <div class="container-fluid">

        <div class="bg-pattern text-primary text-opacity-50 opacity-25 w-100 h-100 start-0 top-0 position-absolute">
        </div>
        <div class="bg-gradientwhite flip-y w-50 h-100 start-50 top-0 translate-middle-x position-absolute"></div>
        <div class="container pt-11 pt-lg-14 pb-9 position-relative z-1">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-6 col-sm-8 mt-3">
              <h3>나의 친구가 되어주세요.</h3>
              <p class="mb-2 w-lg-75">
                세부 정보를 입력하여 주세요...
              </p>

              <div class="width-50x pt-1 bg-primary mb-3"></div>

              <div class="position-relative">
                <div>
                  <form name="registerForm" class="needs-validation" novalidate action="#" method="post">
                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-user-pin"></i>
                      </span>
                      <input type="text" class="form-control" required id="id" name="id"  autofocus placeholder="아이디">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-user"></i>
                      </span>
                      <input type="text" class="form-control" required id="uname" name="name" autofocus placeholder="이름">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-envelope"></i>
                      </span>
                      </span>
                      <input type="email" class="form-control" required id="email" name="email" placeholder="이메일">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-lock-open"></i>
                      </span>
                      </span>
                      <input type="password" class="form-control" required id="passwd" name="passwd" placeholder="비밀번호">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-lock-open"></i>
                      </span>
                      </span>
                      <input type="password" class="form-control" required id="re-passwd" name="re-passwd" placeholder="비밀번호 확인">
                    </div>

                    <div class="d-grid">
                      <button class="btn btn-primary" type="submit">가입하기</button>
                    </div>
                  </form>

                  <p class="pt-3 small text-body-tertiary">
                    이미 계정이 있습니까? <a href="/member/login.jsp" class="ms-2 fw-semibold link-underline">로그인</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Contents Start -->

    </div>
  </div>
  <!-- Wrapper End -->

  <!-- Bootstrap core JavaScript -->
  <script src="/vendor/jquery/jquery.min.js"></script>
  <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>
</body>
</html>
