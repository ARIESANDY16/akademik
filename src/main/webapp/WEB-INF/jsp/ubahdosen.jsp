<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>SDS ISLAM AS SA'ADAH</title>
<!-- Favicon-->
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Sweet Alert Css -->
<link href="assets/plugins/sweetalert/sweetalert.css" rel="stylesheet" />

<!-- Bootstrap Core Css -->
<link href="assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="assets/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="assets/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- JQuery DataTable Css -->
<link
	href="assets/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- Multi Select Css -->
<link href="assets/plugins/multi-select/css/multi-select.css"
	rel="stylesheet">

<!-- Bootstrap Tagsinput Css -->
<link href="assets/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css"
	rel="stylesheet">
<link href="assets/plugins/bootstrap-select/css/bootstrap-select.css"
	rel="stylesheet" />
<!-- Custom Css -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href="assets/css/themes/all-themes.css" rel="stylesheet" />
</head>

<body class="theme-indigo">
	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-cyan">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- #END# Page Loader -->
	<!-- Top Bar -->
	<nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="/" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#navbar-collapse" aria-expanded="false"></a> <a
					href="javascript:void(0);" class="bars"></a> <a
					class="navbar-brand"><font size="6px;">Staffsite | SD ISLAM AS SA'ADAH</font></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="javascript:void(0);"
						class="dropdown-toggle" data-toggle="dropdown" role="button">
							<i class="material-icons">more_vert</i>
					</a>
						<ul class="dropdown-menu">
							<li class="header">INFO</li>
							<li class="body">
								<ul class="menu">
									<li><a href="javascript:void(0);">
											<div class="icon-circle bg-cyan">
												<i class="material-icons">person</i>
											</div>
											<div class="menu-info">
												<h4>Administrator</h4>
											</div>
									</a></li>
									<li><a href="/a_logout">
											<div class="icon-circle bg-red">
												<i class="material-icons">power_settings_new</i>
											</div>
											<div class="menu-info">
												<h4>Logout</h4>
											</div>
									</a></li>
								</ul>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- #Top Bar -->
	<section>
		<!-- Left Sidebar -->
		<aside id="leftsidebar" class="sidebar">
			<!-- User Info -->
			<!-- <div class="user-info"
				style="background: 'assets/images/background.jpg');">
				<div class="info-container">
					<div class="name" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Admin</div>
					<div class="btn-group user-helper-dropdown">
						<i class="material-icons" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
						<ul class="dropdown-menu pull-right">
							<li><a href="/a_logout"><i class="material-icons">power_settings_new</i>Sign
									Out</a></li>
						</ul>
					</div>
				</div>
			</div> -->
			<!-- #User Info -->
			<!-- Menu -->
			<!-- #Top Bar -->
			<div class="menu">
				<ul class="list">
					<li class="header">MAIN NAVIGATION</li>
					<li><a href="/dashboard"> <i class="material-icons">dashboard</i>
							<span>Dashboard</span>
					</a></li>

					<li><a href="/all-mhs"> <i class="material-icons">person</i>
							<span>Data Pribadi Siswa</span>
					</a></li>

					<li class="active"><a href="/all-dosen"> <i
							class="material-icons">people</i> <span>Data Pribadi Guru</span>
					</a></li>
					<li><a href="/all-jurusan"> <i class="material-icons">book</i>
							<span>Jurusan</span>
					</a></li>
					<li><a href="/all-matkul"> <i class="material-icons">library_books</i>
							<span>Mata Pelajaran</span>
					</a></li>
					<li><a href="/all-kelas"> <i class="material-icons">local_library</i>
							<span>Kelas</span>
					</a></li>
					<li><a href="all-krs"> <i class="material-icons">credit_card</i>
							<span>Kartu Rencana Studi</span>
					</a></li>
				</ul>

			</div>
			<!-- #Menu -->
			<!-- Footer -->
			<div class="legal">
				<div class="copyright">
					&copy; 2019 <a href="javascript:void(0);">SD ISLAM AS SA'ADAH</a>.
				</div>
				<div class="version">
					<b>Version: </b> 1.0
				</div>
			</div>
			<!-- #Footer -->
		</aside>
		<!-- #END# Left Sidebar -->
	</section>

	<section class="content">
		<div class="body" style="margin-top: -30px;">
			<ol class="breadcrumb breadcrumb-bg-pink">
				<li><a href="javascript:void(0);"><i class="material-icons">people</i>
						Data Guru</a></li>
			</ol>
		</div>
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
				<div class="container text-center">
								<h3>Update Data Guru</h3>
								<hr>
							</div>

							<form id="form_validation" action="save-dosen" method="post">
								<div class="body">
									<input type="hidden" name="id_dosen" value="${dosen.id_dosen}" />
									<div class="row clearfix">
										<div class="col-sm-3">
											<div class="form-group form-float">
												<label class="form-label">NIP</label>
												<div class="form-line">
													<input name="nip" style="background-color:#F5F5F5" type="text" class="form-control" required
														maxlength="8" value="${dosen.nip}" readonly>
												</div>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group form-float">
												<label class="form-label">NIK</label>
												<div class="form-line">
													<input name="nik" type="text" class="form-control" required
														maxlength="16" value="${dosen.nik}">
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group form-float">
												<label class="form-label">Nama Lengkap</label>
												<div class="form-line">
													<input name="nama_dosen" type="text" class="form-control"
														value="${dosen.nama_dosen}" required>

												</div>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-6">
											<div class="form-group form-float">
												<label class="form-label">Tempat Lahir</label>
												<div class="form-line">
													<input name="tl_dosen" type="text" class="form-control"
														value="${dosen.tl_dosen}" required>
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<label class="form-label">Tanggal Lahir</label>
											<div class="input-group">
												<div class="form-line">
													<input name="tgl_dosen" type="date" readonly
														class="form-control date" value="<fmt:formatDate value="${dosen.tgl_dosen}" pattern="yyyy-MM-dd"/>"
														required>
												</div>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-12">
											<div class="form-group form-float">
												<label class="form-label">Alamat</label>
												<div class="form-line">
													<input name="alamat_dosen" type="text" class="form-control"
														value="${dosen.alamat_dosen}" required>
												</div>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-4">
											<div class="form-group form-float">
												<label class="form-label">Agama</label> <select
													name="agama_dosen" class="form-control show-tick" required>
													<option value="${dosen.agama_dosen}">${dosen.agama_dosen}</option>
													<option value="Islam">Islam</option>
													<option value="Katolik">Katolik</option>
													<option value="Kristen">Kristen</option>
													<option value="Hindu">Hindu</option>
													<option value="Buddha">Buddha</option>
													<option value="Konghucu">Konghucu</option>
												</select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-float">
												<label class="form-label">Jenis Kelamin</label> <select
													name="gender" class="form-control show-tick" required>
													<option value="${dosen.gender}">${dosen.gender}</option>
													<option value="L">Laki-Laki</option>
													<option value="P">Perempuan</option>
												</select>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-float">
												<label class="form-label">No Telpon</label>
												<div class="form-line">
													<input name="no_telp" type="text" class="form-control"
														value="${dosen.no_telp}" required maxlength="12">
												</div>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-4">
											<div class="form-group form-float">
												<label class="form-label">Email</label>
												<div class="form-line">
													<input name="email" type="email" class="form-control"
														value="${dosen.email}" required>
												</div>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-float">
												<label class="form-label">Password</label>
												<div class="form-line">
													<input name="password" type="text" class="form-control"
														value="sementara" readonly required maxlength="20">
												</div>
											</div>
										</div>
									</div>
									<input type="submit" class="btn btn-primary" value="Save" />
								</div>
							</form>
				</div>
			</div>
		</div>

	</section>

	<!-- Jquery Core Js -->
	<script src="assets/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="assets/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Select Plugin Js -->
	<script src="assets/plugins/bootstrap-select/js/bootstrap-select.js"></script>

	<!-- Validation Plugin Js -->
	<script src="assets/plugins/jquery-validation/jquery.validate.js"></script>
	<script src="assets/js/pages/forms/form-validation.js"></script>

	<!-- JQuery Steps Plugin Js -->
	<script src="assets/plugins/jquery-steps/jquery.steps.js"></script>

	<!-- Sweet Alert Plugin Js -->
	<script src="assets/plugins/sweetalert/sweetalert.min.js"></script>

	<!-- Slimscroll Plugin Js -->
	<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

	<!-- Dropzone Plugin Js -->
	<script src="assets/plugins/dropzone/dropzone.js"></script>

	<!-- Input Mask Plugin Js -->
	<script
		src="assets/plugins/jquery-inputmask/jquery.inputmask.bundle.js"></script>

	<!-- Multi Select Plugin Js -->
	<script src="assets/plugins/multi-select/js/jquery.multi-select.js"></script>

	<!-- Jquery Spinner Plugin Js -->
	<script src="assets/plugins/jquery-spinner/js/jquery.spinner.js"></script>

	<!-- Bootstrap Tags Input Plugin Js -->
	<script src="assets/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="assets/plugins/node-waves/waves.js"></script>

	<!-- Jquery DataTable Plugin Js -->
	<script src="assets/plugins/jquery-datatable/jquery.dataTables.js"></script>
	<script
		src="assets/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
	<script
		src="assets/plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

	<!-- Custom Js -->
	<script src="assets/js/admin.js"></script>
	<script src="assets/js/pages/tables/jquery-datatable.js"></script>
	<script src="assets/js/pages/forms/advanced-form-elements.js"></script>
	<script src="assets/js/pages/forms/form-validation.js"></script>

	<!-- Demo Js -->
	<script src="assets/js/demo.js"></script>
</body>

</html>
				