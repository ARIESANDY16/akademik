<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
					class="navbar-brand"><font size="6px;">Studentsite | SD ISLAM AS SA'ADAH</font></a>
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
												<h4>${sessionScope.nama_mhs}</h4>
												<p>
                                                    ${sessionScope.npm_mhs} | Student
                                                </p>
											</div>
									</a></li>
									<li><a href="/logout">
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
			<!-- Menu -->
			<!-- #Top Bar -->
			<div class="menu">
				<ul class="list">
					<li class="header">MAIN NAVIGATION</li>
					<li><a href="m_dashboard"> <i class="material-icons">dashboard</i>
							<span>Dashboard</span>
					</a></li>
					<li><a href="/data-mhs"> <i class="material-icons">person</i>
							<span>Data Siswa</span>
					</a></li>
					<li class="active"><a href="/nilai-mhs"> <i
							class="material-icons">person</i> <span>Data Nilai</span>
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
				<li><a href="javascript:void(0);"><i class="material-icons">dashboard</i>
						Dashboard</a></li>
			</ol>
		</div>
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="body">
						<div class="container text-center">
							<h2>Nilai Akademik</h2>
							<hr>
						</div>
						<h5>Nama Mahasiswa : ${sessionScope.nama_mhs}</h5>
						<h5>NPM : ${sessionScope.npm_mhs}</h5>
						<div class="table-responsive">
							<sql:setDataSource var="pjiuniversity"
								url="jdbc:mysql://localhost/pji_university"
								driver="com.mysql.jdbc.Driver" user="root" password="" />
							<c:set var="id_mhs" value="${sessionScope.id_mhs}" />

							<sql:query var="sqlresult"
								sql="select * from trx_akademik a join md_dosen b on a.id_dosen = b.id_dosen join md_matkul c on a.id_matkul = c.id_matkul where id_mhs = '${id_mhs}'"
								dataSource="${pjiuniversity}">
							</sql:query>
							<table
								class="table table-bordered table-striped table-hover dataTable js-basic-example">
								<thead>
									<tr style="text-align: center">
										<th>Mata Pelajaran</th>
										<th>SKS</th>
										<th>Quiz</th>
										<th>UTS</th>
										<th>UAS</th>
										<th>Grade</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="row" items="${sqlresult.rows}">
										<tr>
											<td><c:out value="${row.nama_matkul}" /></td>
											<td><c:out value="${row.sks}" /></td>
											<td><c:out value="${row.quiz}" /></td>
											<td><c:out value="${row.uts}" /></td>
											<td><c:out value="${row.uas}" /></td>
											<td><c:out value="${row.grade}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="row clearfix">
								<div class="col-md-12">
									<a href="/cetak-mhs" class="btn btn-primary waves-effect right">
										<i class="material-icons">print</i> <span>Cetak Modul
											Akademik</span>
									</a>
								</div>
							</div>
						</div>
					</div>
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

	<!-- Waves Effect Plugin Js -->
	<script src="assets/plugins/node-waves/waves.js"></script>

	<!-- Jquery CountTo Plugin Js -->
	<script src="assets/plugins/jquery-countto/jquery.countTo.js"></script>

	<!-- Morris Plugin Js -->
	<script src="assets/plugins/raphael/raphael.min.js"></script>
	<script src="assets/plugins/morrisjs/morris.js"></script>

	<!-- ChartJs -->
	<script src="assets/plugins/chartjs/Chart.bundle.js"></script>

	<!-- Flot Charts Plugin Js -->
	<script src="assets/plugins/flot-charts/jquery.flot.js"></script>
	<script src="assets/plugins/flot-charts/jquery.flot.resize.js"></script>
	<script src="assets/plugins/flot-charts/jquery.flot.pie.js"></script>
	<script src="assets/plugins/flot-charts/jquery.flot.categories.js"></script>
	<script src="assets/plugins/flot-charts/jquery.flot.time.js"></script>

	<!-- Sparkline Chart Plugin Js -->
	<script src="assets/plugins/jquery-sparkline/jquery.sparkline.js"></script>
	<script src="assets/plugins/waitme/waitMe.js"></script>

	<!-- Custom Js -->
	<script src="assets/js/admin.js"></script>
	<script src="assets/js/pages/index.js"></script>
	<script src="assets/js/pages/cards/colored.js"></script>

	<!-- Demo Js -->
	<script src="assets/js/demo.js"></script>
</body>

</html>
