<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>Course Analysis</title>
<link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Courses.css" media="screen">
<script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
<script class="u-script" type="text/javascript" src="cosmas.js" defer=""></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<meta name="generator" content="Nicepage 4.2.6, nicepage.com">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">

<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/templogo2.jpg"
}</script>

<style>
.vis-picker {
	border: 1px solid black;
	border-radius: 20px;
	padding-left: 25px;
	padding-right: 25px;
}

#notAllowedMessage {
	color: orange;
}

.iframe-container {
	overflow: hidden;
	padding-top: 56.25%; /* 16:9 */
	position: relative;
}

.iframe-container iframe {
	position: absolute;
	top: 0;
	left: 0;
	border: 0;
	width: 100%;
	height: 100%;
}
</style>

<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="Courses">
<meta property="og:type" content="website">
</head>
<body class="u-body">

	<header class="u-clearfix u-header u-header" id="sec-2657">
		<div class="u-clearfix u-sheet u-sheet-1">
			<a href="https://nicepage.com" class="u-image u-logo u-image-1"
				data-image-width="294" data-image-height="103"> <img
				src="images/templogo2.jpg" class="u-logo-image u-logo-image-1">
			</a>
			<nav
				class="u-align-right u-menu u-menu-dropdown u-offcanvas u-menu-1">
				<div class="menu-collapse u-custom-font u-font-open-sans"
					style="font-size: 1rem; letter-spacing: 0px; font-weight: 700; text-transform: uppercase;">
					<a
						class="u-button-style u-custom-active-border-color u-custom-active-color u-custom-border u-custom-border-color u-custom-borders u-custom-hover-border-color u-custom-hover-color u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
						href="#"> <svg viewBox="0 0 24 24">
							<use xmlns:xlink="http://www.w3.org/1999/xlink"
								xlink:href="#menu-hamburger"></use></svg> <svg version="1.1"
							xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<defs>
							<symbol id="menu-hamburger" viewBox="0 0 16 16"
								style="width: 16px; height: 16px;">
							<rect y="1" width="16" height="2"></rect>
							<rect y="7" width="16" height="2"></rect>
							<rect y="13" width="16" height="2"></rect>
</symbol>
</defs></svg>
					</a>
				</div>
				<div class="u-custom-menu u-nav-container">
					<ul
						class="u-custom-font u-font-open-sans u-nav u-spacing-30 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-border-2 u-border-active-palette-1-base u-border-hover-palette-1-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
							href="Home.html" style="padding: 10px 0px;">Home</a></li>
						<li class="u-nav-item"><a
							class="u-border-2 u-border-active-palette-1-base u-border-hover-palette-1-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
							href="About.html" style="padding: 10px 0px;">About</a></li>
						<li class="u-nav-item"><a
							class="u-border-2 u-border-active-palette-1-base u-border-hover-palette-1-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
							href="Contact.html" style="padding: 10px 0px;">Contact</a></li>
					</ul>
				</div>
				<div class="u-custom-menu u-nav-container-collapse">
					<div
						class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
						<div class="u-inner-container-layout u-sidenav-overflow">
							<div class="u-menu-close"></div>
							<ul
								class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="Home.html" style="padding: 10px 0px;">Home</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="About.html" style="padding: 10px 0px;">About</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="Contact.html" style="padding: 10px 0px;">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
				</div>
			</nav>
		</div>
	</header>
	<section class="u-align-center u-clearfix u-section-1" id="sec-5ad4">
		<div class="u-clearfix u-sheet u-sheet-1">
			<form action="${request.contextPath}/COSMAS/user" method="post">
				<h5 style="color: #5085BA" class="u-text u-text-default u-text-1">
					<a><input type="submit" name="command" value="Home"
						class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"></a>
					<span style="color: black"> > Analysis </span>
				</h5>
			</form>
			<h4 class="u-text u-text-default u-text-2">Course Analysis</h4>


			<table style="width: 100%">
				<tr style="text-align: left; padding-top: 0%;">
					<td style="width: 30%; vertical-align: top">

						<div class="vis-picker">
							<p class="u-text u-text-default u-text-2">Choose one to view.</p>
							<br>
							<div class="form-check">
								<input onclick="getPLOCountChartView()" class="form-check-input"
									type="radio" name="flexRadioDefault" id="flexRadioDefault1">
								<label class="form-check-label" for="flexRadioDefault1">
									PLOs Count Chart </label>
							</div>

							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault3"> <label
									class="form-check-label" for="flexRadioDefault3">
									Student Learning Time Distribution By Topic and Mode For Course
									<select style="width: 200px;">
										<option>select a course</option>
										<c:forEach items="${courseList}" var="course">
											<option onclick="getTosletChartView('${course.courseCode}')"
												value="${course.courseCode}">${course.courseCode}-
												${course.courseName}</option>
										</c:forEach>
								</select>
								</label>
							</div>

							<div class="form-check">
								<input onclick="getCAPMatrixView()" class="form-check-input"
									type="radio" name="flexRadioDefault" id="flexRadioDefault2">
								<label class="form-check-label" for="flexRadioDefault2">
									Courses And PLOs Matrix </label>
							</div>

							<div class="form-check">
								<input onclick="getSLTMatrixView()" class="form-check-input"
									type="radio" name="flexRadioDefault" id="flexRadioDefault4">
								<label class="form-check-label" for="flexRadioDefault4">
									Courses And SLTs Matrix </label>
							</div>



							<br>
						</div>
						<div class="vis-picker">
							<p id="current-vis-desc">The different proportions of all eleven Program Learning Outcomes 
							across all courses registered in COSMAS are displayed. From the chart, you can easily identify what most courses
							have as their respective PLOs.</p>
						</div>
					</td>
					<td style="width: 70%">
						<div class="vis-picker">
							<div class="iframe-container">
								<iframe id="chart-container"> </iframe>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</section>

	<script>
		function getPLOCountChartView() {
			document.getElementById("chart-container").src = "${request.contextPath}/COSMAS/analysis?type=plo-count-chart";
		}

		function getCAPMatrixView() {
			document.getElementById("chart-container").src = "${request.contextPath}/COSMAS/analysis?type=cap-matrix";
		}

		function getTosletChartView(courseCode) {
			document.getElementById("chart-container").src = "${request.contextPath}/COSMAS/analysis?type=toslet-chart&courseCode="
					+ courseCode;
			document.getElementById("flexRadioDefault3").checked = true;
		}
		
		function getSLTMatrixView() {
			document.getElementById("chart-container").src = "${request.contextPath}/COSMAS/analysis?type=slt-matrix";
		}
	</script>



	<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer"
		id="sec-835c">
		<div class="u-clearfix u-sheet u-sheet-1">
			<p class="u-small-text u-text u-text-default u-text-variant u-text-1">MOHAMAD
				BASYIR BIN ZAINUDDIN</p>
		</div>
	</footer>



	<style class="u-block-2a9b-30 u-state-style">
.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]),
	.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):before
	{
	transition-property: fill, color, background-color, stroke-width,
		border-style, border-width, box-shadow, text-shadow, opacity,
		border-radius, stroke, border-color, font-size, font-style,
		font-weight, text-decoration, letter-spacing, transform,
		background-image, background-size, background-position
}

.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):hover
	{
	box-shadow: 2px 2px 8px 0 rgba(var(- -grey-50-r), var(- -grey-50-g),
		var(- -grey-50-b), 1) !important
}

.u-block-2a9b-30.u-block-2a9b-30.u-block-2a9b-30.hover {
	box-shadow: 2px 2px 8px 0 rgba(var(- -grey-50-r), var(- -grey-50-g),
		var(- -grey-50-b), 1) !important
}
</style>
	<style class="u-btn-2 u-state-style">
.u-section-9 .u-btn-2, .u-section-9 .u-btn-2:before {
	transition-property: fill, color, background-color, stroke-width,
		border-style, border-width, box-shadow, text-shadow, opacity,
		border-radius, stroke, border-color, font-size, font-style,
		font-weight, text-decoration, letter-spacing, transform,
		background-image, background-size, background-position
}

.u-section-9 .u-btn-2.u-btn-2.u-btn-2:hover {
	box-shadow: 2px 2px 8px 0 rgba(var(- -grey-50-r), var(- -grey-50-g),
		var(- -grey-50-b), 1) !important
}

.u-section-9 .u-btn-2.u-btn-2.u-btn-2.hover {
	box-shadow: 2px 2px 8px 0 rgba(var(- -grey-50-r), var(- -grey-50-g),
		var(- -grey-50-b), 1) !important
}
</style>
	<style class="u-block-2a9b-31 u-state-style">
.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]),
	.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):before
	{
	transition-property: fill, color, background-color, stroke-width,
		border-style, border-width, box-shadow, text-shadow, opacity,
		border-radius, stroke, border-color, font-size, font-style,
		font-weight, text-decoration, letter-spacing, transform,
		background-image, background-size, background-position
}

.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):hover
	{
	box-shadow: 2px 2px 8px 0 rgba(var(- -grey-50-r), var(- -grey-50-g),
		var(- -grey-50-b), 1) !important
}

.u-block-2a9b-31.u-block-2a9b-31.u-block-2a9b-31.hover {
	box-shadow: 2px 2px 8px 0 rgba(var(- -grey-50-r), var(- -grey-50-g),
		var(- -grey-50-b), 1) !important
}
</style>
	</section>
	<style>
.u-section-9 {
	min-height: 840px;
}

.u-section-9 .u-dialog-1 {
	width: 800px;
	min-height: 512px;
	margin: 30px auto 60px;
}

.u-section-9 .u-container-layout-1 {
	padding: 0;
}

.u-section-9 .u-text-1 {
	margin: 34px auto 0 30px;
}

.u-section-9 .u-form-1 {
	height: 352px;
	width: 740px;
	margin: 18px auto 0;
}

.u-section-9 .u-label-1 {
	width: 141px;
}

.u-section-9 .u-input-1 {
	background-image: none;
}

.u-section-9 .u-label-2 {
	width: 141px;
}

.u-section-9 .u-input-2 {
	background-image: none;
}

.u-section-9 .u-label-3 {
	width: 141px;
}

.u-section-9 .u-input-3 {
	background-image: none;
}

.u-section-9 .u-form-group-4 {
	margin-left: 0;
}

.u-section-9 .u-label-4 {
	width: 141px;
}

.u-section-9 .u-input-4 {
	background-image: none;
}

.u-section-9 .u-form-group-5 {
	margin-left: 0;
}

.u-section-9 .u-label-5 {
	width: 141px;
}

.u-section-9 .u-input-5 {
	background-image: none;
}

.u-section-9 .u-list-1 {
	width: 260px;
	margin: -64px 34px 0 auto;
}

.u-section-9 .u-repeater-1 {
	grid-gap: 0px 0px;
	grid-template-columns: 100%;
	min-height: 115px;
}

.u-section-9 .u-container-layout-2 {
	padding: 10px;
}

.u-section-9 .u-btn-2 {
	border-style: none none solid;
	transition-duration: 0.5s;
	box-shadow: 2px 0 0 0 rgba(0, 0, 0, 0);
	margin: 0 auto;
	padding: 0;
}

.u-section-9 .u-icon-1 {
	font-size: 1.75em;
	color: rgb(0, 0, 0) !important;
	background-image: none;
}

.u-section-9 .u-icon-2 {
	width: 20px;
	height: 20px;
}

@media ( max-width : 1199px) {
	.u-section-9 .u-dialog-1 {
		height: auto;
	}
	.u-section-9 .u-list-1 {
		width: 260px;
		margin-top: -64px;
	}
	.u-section-9 .u-repeater-1 {
		grid-template-columns: 33.3333% 33.3333% 33.3333%;
	}
}

@media ( max-width : 991px) {
	.u-section-9 .u-dialog-1 {
		width: 720px;
	}
	.u-section-9 .u-form-1 {
		width: 720px;
	}
	.u-section-9 .u-list-1 {
		width: 223px;
		margin-right: 12px;
	}
}

@media ( max-width : 767px) {
	.u-section-9 .u-dialog-1 {
		width: 540px;
		margin-top: 213px;
	}
	.u-section-9 .u-container-layout-1 {
		padding-top: 25px;
		padding-bottom: 25px;
	}
	.u-section-9 .u-text-1 {
		margin-top: -2px;
	}
	.u-section-9 .u-form-1 {
		width: 540px;
		margin-top: 11px;
	}
	.u-section-9 .u-list-1 {
		width: 206px;
		margin-top: -70px;
		margin-right: 13px;
	}
}

@media ( max-width : 575px) {
	.u-section-9 .u-dialog-1 {
		width: 340px;
	}
	.u-section-9 .u-text-1 {
		margin-top: 68px;
	}
	.u-section-9 .u-form-1 {
		width: 340px;
		margin-top: -59px;
	}
	.u-section-9 .u-list-1 {
		width: 266px;
		margin-top: 0;
		margin-left: 0;
	}
}

.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]),
	.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):before
	{
	transition-property: fill, color, background-color, stroke-width,
		border-style, border-width, box-shadow, text-shadow, opacity,
		border-radius, stroke, border-color, font-size, font-style,
		font-weight, text-decoration, letter-spacing, transform,
		background-image, background-size, background-position;
}

.u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-30:not([data-block-selected]):not([data-cell-selected]):hover
	{
	box-shadow: 2px 2px 8px 0 rgba(128, 128, 128, 1) !important;
}

.u-block-2a9b-30.u-block-2a9b-30.u-block-2a9b-30.hover {
	box-shadow: 2px 2px 8px 0 rgba(128, 128, 128, 1) !important;
}

.u-section-9 .u-btn-2, .u-section-9 .u-btn-2:before {
	transition-property: fill, color, background-color, stroke-width,
		border-style, border-width, box-shadow, text-shadow, opacity,
		border-radius, stroke, border-color, font-size, font-style,
		font-weight, text-decoration, letter-spacing, transform,
		background-image, background-size, background-position;
}

.u-section-9 .u-btn-2.u-btn-2.u-btn-2:hover {
	box-shadow: 2px 2px 8px 0 rgba(128, 128, 128, 1) !important;
}

.u-section-9 .u-btn-2.u-btn-2.u-btn-2.hover {
	box-shadow: 2px 2px 8px 0 rgba(128, 128, 128, 1) !important;
}

.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]),
	.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):before
	{
	transition-property: fill, color, background-color, stroke-width,
		border-style, border-width, box-shadow, text-shadow, opacity,
		border-radius, stroke, border-color, font-size, font-style,
		font-weight, text-decoration, letter-spacing, transform,
		background-image, background-size, background-position;
}

.u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]).u-block-2a9b-31:not([data-block-selected]):not([data-cell-selected]):hover
	{
	box-shadow: 2px 2px 8px 0 rgba(128, 128, 128, 1) !important;
}

.u-block-2a9b-31.u-block-2a9b-31.u-block-2a9b-31.hover {
	box-shadow: 2px 2px 8px 0 rgba(128, 128, 128, 1) !important;
}
</style>
</body>
</html>