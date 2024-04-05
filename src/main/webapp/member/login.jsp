<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>JSP 실습</title>
	<!-- Bootstrap core CSS -->
	<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="/css/simple-sidebar.css" rel="stylesheet">
</head>

<body>
	<section class="position-relative">
		<div class="bg-pattern text-primary text-opacity-50 opacity-25 w-100 h-100 start-0 top-0 position-absolute">
		</div>
		<div class="container pt-11 pt-lg-14 pb-9 pb-lg-11 position-relative z-1">
			<div class="row align-items-center justify-content-center">
				<div class="col-xl-4 col-lg-5 col-md-6 col-sm-8 z-2">

					<h2 class="mb-1 mt-5 display-6">
						Welcome Login In!
					</h2>
					<p class="mb-4 text-body-secondary">
						Please Sign In with details...
					</p>

					<p class="mb-4 text-body-secondary text-danger">
						${message}
					</p>

					<div class="position-relative">
						<div>
							<form class="needs-validation" action="#" method="post">
								<div class="input-icon-group mb-3">
									<span class="input-icon">
										<i class="bx bx-envelope"></i>
									</span>
									<input type="text" name="loginid" class="form-control" autofocus placeholder="Userid">
								</div>
								<div class="input-icon-group mb-3">
									<span class="input-icon">
										<i class="bx bx-lock-open"></i>
									</span>
									<input type="password" name="loginpw" class="form-control" placeholder="Password">
								</div>
								<div class="mb-3 d-flex justify-content-between">
									<div class="form-check">
										<input class="form-check-input" type="checkbox" name="saveid"  id="flexCheckDefault">
										<label class="form-check-label" for="flexCheckDefault">
											Remember ID
										</label>
									</div>
									<div>
										<label class="text-end d-block small mb-0"><a href="#" class="link-decoration">Forget
												Password?</a></label>
									</div>
								</div>

								<div class="d-grid">
									<button class="btn btn-primary" type="submit"> Login </button>
								</div>
							</form>

							<!---->
							<p class="pt-4 small text-body-secondary">
								Don’t have an account yet? <a href="#.html" class="ms-2 fw-semibold link-underline">Sign Up</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

</html>