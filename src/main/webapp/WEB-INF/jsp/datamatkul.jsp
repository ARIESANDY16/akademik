<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:600"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<?php echo base_url(); ?>assets/plugins/font-awesome/css/font-awesome.min.css">

<!-- Bootstrap Tagsinput Css -->
<link href="assets/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css"
	rel="stylesheet" />
<!-- noUISlider Css -->
<link href="assets/plugins/nouislider/nouislider.min.css"
	rel="stylesheet" />

<!-- Bootstrap Core Css -->
<link href="assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="assets/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="assets/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- Sweetalert Css -->
<link href="assets/plugins/sweetalert/sweetalert.css" rel="stylesheet" />

<!-- Morris Chart Css-->
<link href="assets/plugins/morrisjs/morris.css" rel="stylesheet" />

<!-- JQuery DataTable Css -->
<link
	href="assets/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css"
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
			<div class="menu">
				<ul class="list">
					<li class="header">MAIN NAVIGATION</li>
					<li><a href="/dashboard"> <i class="material-icons">dashboard</i>
							<span>Dashboard</span>
					</a></li>

					<li><a href="/all-mhs"> <i class="material-icons">person</i>
							<span>Data Pribadi Siswa</span>
					</a></li>

					<li><a href="/all-dosen"> <i class="material-icons">people</i>
							<span>Data Pribadi Guru</span>
					</a></li>
					<li><a href="/all-jurusan"> <i class="material-icons">book</i>
							<span>Jurusan</span>
					</a></li>
					<li class="active"><a href="/all-matkul"> <i
							class="material-icons">library_books</i> <span>Mata Pelajaran</span>
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
				<li><a href="javascript:void(0);"><i class="material-icons">library_books</i>
						Data Mata Pelajaran</a></li>
			</ol>
		</div>
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<c:choose>
						<c:when test="${mode == 'MODE_MATKUL'}">
							<div class="body">
								<div class="container text-center">
									<h2>Data Mata Pelajaran</h2>
									<hr>
								</div>
								<div class="row clearfix">
									<div class="col-md-12">
										<a href="/new-matkul"
											class="btn btn-danger waves-effect right"> <i
											class="material-icons">add</i> <span>Tambah Data</span>
										</a>
									</div>
								</div>
								<div class="table-responsive">
									<table
										class="table table-bordered table-striped table-hover dataTable js-basic-example">
										<thead>
											<tr style="text-align: center">
												<th>ID</th>
												<th>Kode Mata Pelajaran</th>
												<th>Nama Mata Pelajaran</th>
												<th>SKS</th>
												<th>Jurusan</th>
												<th>Kelas</th>
												<th>Guru</th>
												<th>Edit</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="matkul" items="${matkuls}">
												<tr>
													<td>${matkul.id_matkul}</td>
													<td>${matkul.kd_matkul}</td>
													<td>${matkul.nama_matkul}</td>
													<td>${matkul.sks}</td>
													<td>${matkul.jurusan.nama}</td>
													<td>${matkul.kelas.nama_kelas}</td>
													<td>${matkul.dosen.nama_dosen}</td>
													<td style="text-align: center;"><a
														href="update-matkul?id_matkul=${matkul.id_matkul}"><i
															class="material-icons" style="color: blue;">create</i></a> <a
														href="delete-matkul?id_matkul=${matkul.id_matkul}"><i
															class="material-icons" style="color: red;" onclick="return ConfirmDelete();">delete</i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
							<div class="container text-center">
								<h3>Tambah Data Mata Pelajaran</h3>
								<hr>
							</div>

							<form id="form_validation" action="save-matkul" method="post">
								<div class="body">
									<input type="hidden" name="id_matkul"
										value="${matkul.id_matkul}" />
									<div class="row clearfix">
										<div class="col-sm-6">
											<div class="form-group form-float">
												<label class="form-label">Kode Mata Pelajaran</label>
												<div class="form-line">
													<input name="kd_matkul" type="text" class="form-control"
														required maxlength="10" value="${matkul.kd_matkul}">
												</div>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-6">
											<div class="form-group form-float">
												<label class="form-label">Nama Mata Kuliah</label>
												<div class="form-line">
													<input name="nama_matkul" type="text" class="form-control"
														required maxlength="15" value="${matkul.nama_matkul}">
												</div>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-2">
											<div class="form-group form-float">
												<label class="form-label">SKS</label>
												<div class="form-line">
													<input name="sks" type="text" class="form-control" required
														maxlength="1" value="${matkul.sks}">
												</div>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group form-float">
												<label class="form-label">Jurusan</label> <select
													name="jurusan" class="form-control show-tick"
													data-live-search="true" required>
													<c:forEach var="jurusan" items="${jurusans}">
														<option value="${jurusan.id_jurusan}">${jurusan.nama}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group form-float">
												<label class="form-label">Kelas</label> <select name="kelas"
													class="form-control show-tick" data-live-search="true"
													required>
													<c:forEach var="kelas" items="${kelass}">
														<option value="${kelas.id_kelas}">${kelas.nama_kelas}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="row clearfix">
										<div class="col-sm-3">
											<div class="form-group form-float">
												<label class="form-label">Guru</label> <select name="dosen"
													class="form-control show-tick" data-live-search="true" required>
													<c:forEach var="dosen" items="${dosens}">
														<option value="${dosen.id_dosen}">${dosen.nama_dosen}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<input type="submit" class="btn btn-primary" value="Save" />
								</div>
							</form>
						</c:when>
					</c:choose>
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

	<!-- Demo Js -->
	<script src="assets/js/demo.js"></script>
	<script>
		function ConfirmDelete() {
			var x = confirm("Are you sure you want to delete?");
			if (x)
				return true;
			else
				return false;
		}
	</script>
</body>

</html>
