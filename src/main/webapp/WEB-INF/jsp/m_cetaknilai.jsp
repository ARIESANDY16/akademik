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
<title>SD ISLAM AS SA'ADAH</title>
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
<body onload="hasil();">
	<center>
		<h1>Laporan Nilai SD ISLAM AS SA'ADAH</h1>
	</center>
	<br>
	<sql:setDataSource var="pjiuniversity"
		url="jdbc:mysql://localhost/pji_university"
		driver="com.mysql.jdbc.Driver" user="root" password="" />
	<c:set var="id_mhs" value="${sessionScope.id_mhs}" />

	<sql:query var="sqlresult"
		sql="select * from trx_akademik a join md_dosen b on a.id_dosen = b.id_dosen join md_matkul c on a.id_matkul = c.id_matkul where id_mhs = '${id_mhs}'"
		dataSource="${pjiuniversity}">

	</sql:query>

	<table style="font-size: 20px;">
		<thead>
			<th>
				<div class="row clearfix">
					<div class="col-md-6">NPM : ${sessionScope.npm_mhs}</div>
					<div class="col-md-6">Nama Lengkap : ${sessionScope.nama_mhs}

					</div>
				</div>
			</th>
			<?php
                }
            ?>
		</thead>
	</table>
	<br>
	<br>
	<table id="mytable" border="1px" style="width: 100%; font-size: 18px;">
		<thead>
			<th style="text-align: center"><div style="margin-left: 5px;">No.</div></th>
			<th style="text-align: center"><div style="margin-left: 5px;">Mata
					Pelajaran</div></th>
			<th style="text-align: center"><div style="margin-left: 5px;">SKS</div></th>
			<th style="text-align: center"><div style="margin-left: 5px;">Quiz</div></th>
			<th style="text-align: center"><div style="margin-left: 5px;">UTS</div></th>
			<th style="text-align: center"><div style="margin-left: 5px;">UAS</div></th>
			<th style="text-align: center"><div style="margin-left: 5px;">Nilai</div></th>

		</thead>
		<%
			int i = 1;
		%>
		<c:forEach var="row" items="${sqlresult.rows}">
			<tbody>
				<tr>
					<td style="text-align: center"><div style="margin-left: 5px;"><%=i%>
							<%
								i++;
							%>
						</div></td>
					<td style="text-align: left"><div style="margin-left: 5px;">
							<c:out value="${row.nama_matkul}" />
						</div></td>
					<td style="text-align: center"><input readonly id="sks" style="margin-left: 5px;" value="<c:out value="${row.sks}" />"></td>
					<td style="text-align: center"><div style="margin-left: 5px;">
							<c:out value="${row.quiz}" />
						</div></td>
					<td style="text-align: center"><div style="margin-left: 5px;">
							<c:out value="${row.uts}" />
						</div></td>
					<td style="text-align: center"><div style="margin-left: 5px;">
							<c:out value="${row.uas}" />
						</div></td>
					<td style="text-align: center"><input readonly id="grade" style="margin-left: 5px;" value="<c:out value="${row.grade}"/>">
							</td>
				</tr>
			</tbody>
		</c:forEach>
		<tfoot>
			<tr>
				<td colspan="6"><div style="margin-left: 5px;">
						<b><center>IPK</center></b>
					</div></td>
					<td colspan="1" style="text-align: center"><div style="margin-center: 5px;">
						<b><div id="hasil"></div></b>
					</div></td>
			</tr>
		</tfoot>
	</table>
	<br>
	<br>

	<script>
	function hasil(){
	var table = document.getElementById('mytable');
	var grade = document.getElementById('grade').value;
	var sks = document.getElementById('sks').value;
	var nilai = 0;
	var totalnilai = 0;
	var total = 0;
	var totalsks = 0;
	var hasil = 0;
	for(var i=0; i<8; i++) {
		if (grade = "A") {
			nilai = 4;
		} else if (grade = "B") {
			nilai = 3;
		} else if (grade = "C") {
			nilai = 2;
		} else if (grade = "D") {
			nilai = 1;
		} else {
			nilai = 0;
		}
		totalnilai = nilai*sks;
		total = total + totalnilai;
		totalsks = totalsks + sks;
	}
	
	hasil = ((total / totalsks)*1000000).toFixed(2);
	document.getElementById('hasil').innerHTML=hasil;
	}
		window.print();
	</script>
</html>