<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Login User SDS ISLAM AS SA'ADAH</title>
<!-- Favicon-->
<link rel="icon" href="assets/favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:600"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link href="assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="assets/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="assets/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- Custom Css -->
<link href="assets/css/style.css" rel="stylesheet">
</head>

<body class="login-page"
	style="background-image: url(assets/images/university.jpg);">
	<c:choose>
		<c:when test="${mode=='MODE_LOGIN'}">
			<div class="login-box">
				<div class="logo">
					<a>SD ISLAM AS SA'ADAH</a> <small>Pondok Kelapa, Duren Sawit, Jakarta Timur</small>
				</div>
				<div class="card">
					<div class="body">
						<form action="/dashboard" id="sign_in" id="jquery-validation"
							method="POST">

							<div class="msg">Sign in to start your session</div>
							<c:if test="${not empty error}">
								<div class="alert alert-danger">
									<c:out value="${error}"></c:out>
								</div>
							</c:if>

							<div class="input-group">
								<span class="input-group-addon"> <i
									class="material-icons">person</i>
								</span>
								<div class="form-line">
									<input type="text" class="form-control" name="username"
										placeholder="Username" value="${login.username}" required
										autofocus>
								</div>
							</div>
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="material-icons">lock</i>
								</span>
								<div class="form-line">
									<input type="password" class="form-control" name="password"
										placeholder="Password" value="${login.password}" required>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-8 p-t-5"></div>
								<div class="col-xs-4">
									<button class="btn btn-block bg-pink waves-effect">SIGN
										IN</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>

	<!-- Jquery Core Js -->
	<script src="assets/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="assets/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="assets/plugins/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script src="assets/plugins/jquery-validation/jquery.validate.js"></script>


	<script src="assets/js/pages/forms/form-validation.js"></script>

	<!-- Custom Js -->
	<script src="assets/js/admin.js"></script>
	<script src="assets/js/pages/examples/sign-in.js"></script>
</body>

</html>