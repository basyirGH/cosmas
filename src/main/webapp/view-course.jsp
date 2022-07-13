<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>View Course</title>
<link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="View-Course.css" media="screen">
<link rel="stylesheet" href="modal-styling.css" media="screen">
<script class="u-script" type="text/javascript" src="nicepage.js"
	defer=""></script>
<script class="u-script" type="text/javascript" src="cosmas.js" defer=""></script>
<script class="u-script" type="text/javascript"
	src="attribute-8-mapping.js" defer=""></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
}
</script>

<style>
.attribute-8-9-table {
	table-layout: auto;
	column-width: 100%;
	display: block;
	overflow-x: auto;
	white-space: nowrap;
	background-color: grey;
}

.first-columns-attribute {
	padding: 5px;
}

.toslet-collapsable, .cas-collapsable, .fas-collapsable {
	display: none;
	#
	notAllowedMessage
	{
	color
	:
	orange;
}

@charset "ISO-8859-1";

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>


<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="View Course">
<meta property="og:type" content="website">

</head>
<body onload="getEverything()" class="u-body">
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
	<section style="background-color: #ffffff"
		class="u-align-left u-clearfix u-grey-15 u-section-1" id="sec-5959">
		<div class="u-clearfix u-sheet u-sheet-1">
			<form action="${request.contextPath}/COSMAS/user" method="post">
				<h5 style="color: #5085BA" class="u-text u-text-default u-text-1">
					<a><input type="submit" name="command" value="Home"
						class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"></a>
					<span style="color: black"> > Courses > View Course
						${course.courseName} </span>
				</h5>
			</form>
			<div class="u-expanded-width-xs u-list u-list-1">
				<div class="u-repeater u-repeater-1">
					<div
						class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-container-style u-hover-feature u-list-item u-repeater-item u-list-item-1"
						data-href="Edit-Course.html" data-page-id="50076841">
						<div
							class="u-container-layout u-similar-container u-container-layout-1">
							<form id="edit-course"
								action="${request.contextPath}/COSMAS/course">
								<input type="hidden" value="${course.courseCode}"
									name="courseCode"> <input type="hidden"
									value="${courseCodeOld}" name="courseCodeOld"> <a
									onclick="checkUserRole()"
									class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1">
									<span class="u-file-icon u-icon u-icon-1"><img
										src="images/18279331.png" alt=""></span>&nbsp;<br> <input
									id="editButton"
									class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"
									type="submit" value="Edit" name="command">
								</a>
							</form>
						</div>
					</div>
					<div
						class="u-align-center u-container-style u-hover-feature u-list-item u-repeater-item u-list-item-2">
						<div
							class="u-container-layout u-similar-container u-container-layout-2">
							<form id="delete-course"
								action="${request.contextPath}/COSMAS/course">
								<input type="hidden" value="${course.courseCode}"
									name="courseCode"> <a onclick="checkUserRole()"
									class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-2"><span
									class="u-file-icon u-icon u-icon-2"><img
										src="images/72205.png" alt=""></span>&nbsp; <input
									class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"
									type="submit" value="Delete" name="command"> </a>
							</form>
						</div>
					</div>
					<div
						class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-container-style u-hover-feature u-list-item u-repeater-item u-list-item-3">
						<div
							class="u-container-layout u-similar-container u-container-layout-3">
							<a href="https://nicepage.com/website-builder"
								class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-3"><span
								class="u-custom-item u-file-icon u-icon u-icon-3"><img
									src="images/7249331.png" alt=""></span>&nbsp;<br>Download<br>
								<br> </a>
						</div>
					</div>
					<div
						class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-container-style u-hover-feature u-list-item u-repeater-item u-list-item-4">
						<div
							class="u-container-layout u-similar-container u-container-layout-4">
							<a href="https://nicepage.com/website-builder"
								class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-4"><span
								class="u-custom-item u-file-icon u-icon u-icon-4"><img
									src="images/1621635.png" alt=""></span>&nbsp;<br>Duplicate
							</a>
						</div>
					</div>
					<div
						class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-container-style u-hover-feature u-list-item u-repeater-item u-list-item-5"
						data-href="Courses.html" data-page-id="14932833">
						<div
							class="u-container-layout u-similar-container u-container-layout-5">
							<a href="https://nicepage.com/website-builder"
								class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-5"><span
								class="u-file-icon u-icon u-icon-5"><img
									src="images/61343.png" alt=""></span>&nbsp;<br>Done </a>
						</div>
					</div>
				</div>
			</div>
			<p class="u-text u-text-default u-text-2" id="notAllowedMessage"></p>
			<div class="u-form u-form-1">
				<form action="${request.contextPath}/COSMAS/course" method="POST"
					class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form"
					source="custom" name="form" style="padding: 10px;">
					<div class="u-form-group u-form-name u-label-left">
						<label for="name-2b64" class="u-label u-spacing-75 u-label-1">Course
							Name</label> <input readonly value="${course.courseName}" type="text"
							id="name-2b64" name="name"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">
					</div>
					<div class="u-form-email u-form-group u-label-left u-form-group-2">
						<label for="email-2b64" class="u-label u-spacing-75 u-label-2">Course
							Code</label> <input readonly value="${course.courseCode}" type="email"
							id="email-2b64" name="email"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">
					</div>
					<div class="u-form-group u-label-left">
						<label for="message-2b64" class="u-label u-spacing-75 u-label-3">Course
							Classification</label> <input readonly
							value="${course.courseClassification}" rows="4" cols="50"
							id="message-2b64" name="message"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="required" type="text">
					</div>
					<div
						class="u-form-group u-form-message u-label-left u-form-group-4">
						<label for="text-46f2" class="u-label u-spacing-75 u-label-4">Synopsis</label>
						<textarea readonly placeholder="" id="text-46f2" name="text"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white u-input-4">${course.courseSynopsis}</textarea>
					</div>
					<div
						class="u-form-group u-form-textarea u-label-left u-form-group-5">
						<label for="textarea-377c" class="u-label u-spacing-75 u-label-5">Academic
							Staff(s)</label>
						<textarea readonly rows="4" cols="50" id="textarea-377c"
							name="textarea"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">${course.courseAcadStaff}</textarea>
					</div>
					<div class="u-form-group u-label-left u-form-group-6">
						<label for="text-f70c" class="u-label u-spacing-75 u-label-6">Semester
							and Year Offered</label> <input readonly
							value="${course.courseSemYearOffered}" type="text" placeholder=""
							id="text-f70c" name="text-1"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-7">
						<label for="text-2b51" class="u-label u-spacing-75 u-label-7">Credit
							Value</label> <input readonly value="${course.courseCredit}" type="text"
							placeholder="" id="text-2b51" name="text-2"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-8">
						<label for="text-7fdf" class="u-label u-spacing-75 u-label-8">Pre-requisite/co-requisite
							(if any)</label> <input readonly value="${course.coursePrerequisite}"
							type="text" placeholder="" id="text-7fdf" name="text-3"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white u-input-8">
					</div>
					<div class="u-form-group u-label-left u-form-group-8">
						<label for="textarea-378" class="u-label u-spacing-75 u-label-8">
							Course Learning Outcomes (CLO) </label>
						<textarea placeholder="" id="textarea-378"
							name="courseLearningOutcomes"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white u-input-8">${course.courseLearningOutcomes}</textarea>
					</div>
					<div class="u-form-group u-label-left u-form-group-8">
						<label for="attr-8-value" class="u-label u-spacing-75 u-label-8">Mapping
							of the Course Learning Outcomes to Program Learning Outcomes,
							Teaching Methods and Assessment Methods</label>
						<table id="attr-8-value" class="attribute-8-9-table">
							<colgroup>
								<col width="200%" span="16" style="background-color: #eaeaea" />
							</colgroup>
							<tr>
								<th></th>
								<th>PLO1</th>
								<th>PLO2</th>
								<th>PLO3</th>
								<th>PLO4</th>
								<th>PLO5</th>
								<th>PLO6</th>
								<th>PLO7</th>
								<th>PLO8</th>
								<th>PLO9</th>
								<th>PLO10</th>
								<th>PLO11</th>
								<th>Teaching Methods</th>
								<th>Assessment Methods</th>
							</tr>
							<tr>
								<td class="first-columns-attribute">CLO1</td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO01" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO02" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO03" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO04" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO05" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO06" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO07" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO08" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO09" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO10" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO11" disabled="disabled" /></td>
								<td><textarea name="TeachingMethodsForCLO1" id="" readonly> ${course.teachingMethodsForCLO1} </textarea>
								</td>
								<td><textarea name="AssessmentMethodsForCLO1" id=""
										readonly> ${course.assessmentMethodsForCLO1} </textarea></td>
							</tr>
							<tr>
								<td class="first-columns-attribute">CLO2</td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO01" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO02" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO03" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO04" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO05" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO06" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO07" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO08" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO09" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO10" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO11" disabled="disabled" /></td>
								<td><textarea name="TeachingMethodsForCLO2" id="" readonly> ${course.teachingMethodsForCLO2} </textarea>
								</td>
								<td><textarea name="AssessmentMethodsForCLO2" id=""
										readonly> ${course.assessmentMethodsForCLO2} </textarea></td>
							</tr>
							<tr>
								<td class="first-columns-attribute">CLO3</td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO01" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO02" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO03" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO04" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO05" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO06" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO07" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO08" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO09" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO10" disabled="disabled" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO11" size="10" disabled="disabled" /></td>
								<td><textarea name="TeachingMethodsForCLO3" id="" readonly> ${course.teachingMethodsForCLO3} </textarea>
								</td>
								<td><textarea name="AssessmentMethodsForCLO3" id=""
										readonly> ${course.assessmentMethodsForCLO3} </textarea></td>
							</tr>
							<tr>
								<td class="first-columns-attribute">Mapping with MQF
									Cluster <br> of Learning Outcomes
								</td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO1" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO2" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO3" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO4" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO5" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO6" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO7" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO8" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO9" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO10" size="4" readonly /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO11" size="4" readonly /></td>
							</tr>
							<tr>
								<td id="MQFLOforPLOTestReceive"></td>
							</tr>
						</table>

					</div>
					<div class="u-form-group u-label-left u-form-group-10">
						<label for="text-32c5" class="u-label u-spacing-75 u-label-10">Transferrable
							Skills</label> <input readonly value="${course.courseTransSkills}"
							type="text" placeholder="" id="text-32c5" name="text-5"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>

					<div class="u-form-group u-label-left u-form-group-11">
						<label for="text-c8be" class="u-label u-spacing-75 u-label-11">SLT
							Distribution</label> <input value="${course.courseSLTDist}" type="hidden"
							id="text-c8be" name="text-6">
						<table id="slt-dist-table" class="attribute-8-9-table">
							<colgroup>
								<col width="200%" span="16" style="background-color: #eaeaea" />
							</colgroup>
							<tr>
								<td class="first-columns-attribute" rowspan='4' colspan='2'>Course
									Content <br> Outline and Subtopics <br> <br> <a
									id="hideOrShowRows"
									href="javascript:collapseExpandTosletRows()">Show/Hide All
								</a>
								</td>
								<td class="first-columns-attribute" rowspan='4' colspan='1'>CLO*</td>
								<td class="first-columns-attribute" rowspan='1' colspan='9'>Learning
									and Teaching Activities**</td>
								<td class="first-columns-attribute" rowspan='4' colspan='1'>Total
									SLT</td>
							</tr>
							<tr>
								<td rowspan='1' colspan='8'>Face-To-Face (F2F)</td>
								<td rowspan='3' colspan='1'>Non Face-To-Face <br>
									(NF2F) <br> (Asynchronous)
								</td>
							</tr>
							<tr>
								<td rowspan='1' colspan='4'>Physical</td>
								<td rowspan='1' colspan='4'>Online/Technology <br>
									mediated (Synchronous)
								</td>
							</tr>
							<tr>
								<td>L</td>
								<td>T</td>
								<td>P</td>
								<td>O</td>
								<td>L</td>
								<td>T</td>
								<td>P</td>
								<td>O</td>
							</tr>
							<c:set var="i" value="1" />
							<c:forEach items="${course.courseSLTDist2}" var="toslet">
								<tr class="toslet-collapsable">
									<td colspan="2"><textarea readonly
											class="sltdist-topic" name="outline${i}"
											oninput="auto_grow(this)" placeholder="${i})"
											id="outline-topic${i}">${toslet.outline}</textarea></td>
									<td><input readonly value="${toslet.clo}" type="text"
										name="clo${i}" size="3"></td>
									<td><input readonly value="${toslet.plhour}" type="number"
										name="pl-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.pthour}" type="number"
										name="pt-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.pphour}" type="number"
										name="pp-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.pohour}" type="number"
										name="po-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.olhour}" type="number"
										name="ol-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.othour}" type="number"
										name="ot-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.ophour}" type="number"
										name="op-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.oohour}" type="number"
										name="oo-hour${i}" size="3"></td>
									<td><input readonly value="${toslet.nf2fhour}"
										type="number" name="nf2f-hour${i}" size="12"></td>
								</tr>
								<c:set var="i" target="i" value="${i+1}" />
							</c:forEach>
							<tr>
								<td style="text-align: right" colspan="12">Subtotal SLT:</td>
								<td> <c:out value="${course.totalToslet}"/> </td>
							</tr>

							<!--[COLUMNS] CONTINOUS ASSESSMENT AND SLT ROWS -->
							<tr>
								<td class="first-columns-attribute" rowspan='2' colspan='2'>Continous
									<br> Assessments <br> <br> <a
									id="hideOrShowRows" href="javascript:collapseExpandCasRows()">Show/Hide
										All </a>
								</td>
								<td class="first-columns-attribute" rowspan='2' colspan='1'>%</td>
								<td class="first-columns-attribute" rowspan='1' colspan='8'>Face-to-Face(F2F)</td>
								<td class="first-columns-attribute" rowspan='2' colspan='1'>NF2F</td>
							</tr>
							<tr>
								<td class="first-columns-attribute" colspan='4'>Physical</td>
								<td class="first-columns-attribute" colspan='4'>Online/Technology
									Mediated</td>
							</tr>

							<!--[VALUES] CONTINOUS ASSESSMENT AND SLT ROWS -->
							
							<c:set var="i" value="1"/>
							<c:forEach items="${course.courseCasletDist}" var="caslet">
								<tr class="cas-collapsable">
									<td colspan="2"><input readonly type="text"
										name="cas${i}" value="${caslet.asst}"><input readonly name="cas${i}" type="hidden"
										value="${caslet.asstId}"></td>
									<td><input readonly type="number" name="cas${i}" value="${caslet.weightage}"></td>
									<td colspan="4"><input readonly type="number" name="cas${i}" value="${caslet.phour}"></td>
									<td colspan="4"><input readonly type="number" name="cas${i}" value="${caslet.ohour}"></td>
									<td><input readonly type="number" name="cas${i}" value="${caslet.nf2fhour}"></td>
								</tr>
								<c:set var="i" target="i" value="${i+1}" />
							</c:forEach>

							<tr>
								<td style="text-align: right" colspan="12">Subtotal SLT:</td>
								<td> <c:out value="${course.totalCaslet}"/> </td>
							</tr>

							<!--[COLUMNS] FINAL ASSESSMENT AND SLT ROWS -->
							<tr>
								<td class="first-columns-attribute" rowspan='2' colspan='2'>Final
									<br> Assessments <br> <br> <a
									id="hideOrShowRows" href="javascript:collapseExpandFasRows()">Show/Hide
										All </a>
								</td>
								<td class="first-columns-attribute" rowspan='2' colspan='1'>%</td>
								<td class="first-columns-attribute" rowspan='1' colspan='8'>Face-to-Face(F2F)</td>
								<td class="first-columns-attribute" rowspan='2' colspan='1'>NF2F</td>
							</tr>
							<tr>
								<td class="first-columns-attribute" colspan='4'>Physical</td>
								<td class="first-columns-attribute" colspan='4'>Online/Technology
									Mediated</td>
							</tr>
							<!-- [VALUES] FINAL ASSESSMENT AND SLT ROWS -->
							<c:set var="i" value="1"/>
							<c:forEach items="${course.courseFasletDist}" var="faslet">
								<tr class="fas-collapsable">
									<td colspan="2"><input readonly placeholder="${i})" type="text"
										name="fas${i}" value="${faslet.asst}"><input readonly name="fas${i}" type="hidden"
										value="${faslet.asstId}"></td>
									<td><input readonly type="number" name="fas${i}" value="${faslet.weightage}"></td>
									<td colspan="4"><input readonly type="number" name="fas${i}" value="${faslet.phour}"></td>
									<td colspan="4"><input readonly type="number" name="fas${i}" value="${faslet.ohour}"></td>
									<td><input readonly type="number" name="fas${i}" value="${faslet.nf2fhour}"></td>
								</tr>
								<c:set var="i" target="i" value="${i+1}" />
							</c:forEach>
							<tr>
								<td style="text-align: right" colspan="12"> Subtotal SLT: </td>
								<td> <c:out value="${course.totalFaslet}"/> </td>
							</tr>
							<tr>
								<td style="text-align: right" colspan="12"> Grand Total SLT: </td>
								<td> <c:out value="${course.grandTotalSLT}"/> </td>
							</tr>


						</table>
					</div>
					<div class="u-form-group u-label-left u-form-group-12">
						<label for="text-47cc" class="u-label u-spacing-75 u-label-12">Special
							Requirements</label> <input readonly value="${course.courseSpecialReq}"
							type="text" placeholder="" id="text-47cc" name="text-7"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white u-input-12">
					</div>
					<div class="u-form-group u-label-left u-form-group-13">
						<label for="text-fb22" class="u-label u-spacing-75 u-label-13">References</label>
						<textarea rows="10" readonly placeholder="" id="text-fb22"
							name="text-8"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">${course.courseReferences}</textarea>
					</div>
					<div class="u-form-group u-label-left u-form-group-14">
						<label for="text-fc68" class="u-label u-spacing-75 u-label-14">Other
							info</label> <input readonly value="${course.courseOtherInfo}"
							type="text" id="text-fc68" name="text-9"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-15">
						<label for="text-e410" class="u-label u-spacing-75 u-label-15">Dates
							of Approval</label> <input readonly value="${course.courseDatesApproval}"
							type="text" id="text-e410" name="text-10"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>

					<!-- submit -->

					<div class="u-align-left u-form-group u-form-submit">
						<input type="hidden" value="${course.courseCLOPLOMapping}"
							name="allCheckedTrue" id="allCheckedTrue" /> <input
							type="hidden" value="${course.MQFLOforPLO}"
							name="allFilledMQFLOforPLO" id="allFilledMQFLOforPLO" /> <input
							type="hidden" name="allChecked" id="allChecked" /> <input
							type="hidden" value="${course.courseCode}" name="courseCodeOld">
						<input type="submit" value="Save Course Edit"
							class="u-btn u-btn-submit u-button-style" style="display: none">
						<input type="button" value="Clear Unsaved Changes and Exit"
							class="u-btn u-btn-submit u-button-style" style="display: none">

					</div>
					<div class="u-form-send-message u-form-send-success">Thank
						you! Your message has been sent.</div>
					<div class="u-form-send-error u-form-send-message">Unable to
						send your message. Please fix errors then try again.</div>
					<input type="hidden" value="" name="recaptchaResponse">
				</form>
			</div>
		</div>

	</section>

	<!-- The Permission Modal -->
	<div id="permission-modal" class="modal">

		<!-- Permission Modal content -->

		<div class="modal-content">
			<span class="close">&times;</span>

			<h5 class="u-text u-text-default u-text-2">Modifying Course
				Information</h5>
			<hr>
			<p class="u-text u-text-default u-text-2" id="">
				You have Permission after a Head of Programme had approved a request
				you made before. <span><a
					href="javascript:showCreateRequest();">Create a new request </a> to
					modify the information of this course, or, </span>
			</p>
			<p class="u-text u-text-default u-text-2">
				Choose a Permission for <i>${course.courseName}</i> that you have.
			</p>
			<form action="${request.contextPath}/COSMAS/request" method="post">
				<input type="hidden" value="${course.courseCode}" name="courseCode">
				<input type="hidden" value="${courseCodeOld}" name="courseCodeOld">

				<select name="permission">
					<option>Select One</option>
					<c:forEach items="${requestList}" var="req">
						<option value="${req.requestId}">[${req.requestId}]
							${req.requestAction} ${req.courseCode} by ${req.userId}</option>
					</c:forEach>
				</select> <br> <br>
				<button type="submit" name="command" value="use-permission">Next</button>
			</form>
		</div>

	</div>

	<!-- The Create Request Modal -->
	<div id="create-request-modal" class="modal">

		<!-- Create Request Modal content -->

		<div class="modal-content">
			<span class="close">&times;</span>

			<h5 class="u-text u-text-default u-text-2">Create New Request</h5>
			<hr>
			<div class="u-form u-form-1">
				<form action="${request.contextPath}/COSMAS/request">

					<table>

						<tr>
							<td><label for="course-code">Course: </label></td>
							<td><p id="course-code">${course.courseCode}
									${course.courseName}</p></td>
						</tr>
						<tr>
							<td><label for="request-action">Action: </label></td>
							<td><select id="request-action" name="requestAction">
									<option value="edit">EDIT</option>
									<option value="delete">DELETE</option>
							</select></td>
						</tr>

						<tr>
							<td><label for="request-message">Message: </label></td>
							<td><textarea id="request-message" name="requestMessage"></textarea></td>
						</tr>

					</table>
					<br> <input type="reset"> <input type="submit"
						name="command" value="Submit"> <br> <input
						id="request-date" name="requestMadeOn" type="hidden" value="now">

				</form>
			</div>

		</div>

	</div>

	<script>
		//Get the modal
		var permissionModal = document.getElementById("permission-modal");
		var createRequestModal = document
				.getElementById("create-request-modal");
		var span = document.querySelectorAll(".close");

		function showPermission() {
			permissionModal.style.display = "block";
		}

		function hidePermission() {
			permissionModal.style.display = "none";
		}

		function checkUserRole() {
			var userRole = "${loggedIn.userRole}"
			var message = "&#9888; Only a Head of Programme is allowed for this action. <span><a href='javascript:showPermission();'>I have Permission.</a></span>";
			var messageTimeout;

			if (userRole != "Head of Programme") {
				document.getElementById("notAllowedMessage").innerHTML = message;
				event.preventDefault();

			}
		}

		function showCreateRequest() {
			hidePermission();
			createRequestModal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span[0].onclick = function() {
			permissionModal.style.display = "none";
		}

		span[1].onclick = function() {
			createRequestModal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == permissionModal
					|| event.target == createRequestModal) {
				permissionModal.style.display = "none";
				createRequestModal.style.display = "none";
			}
		}

		function retrieveRequestList() {
			$
					.get(
							'${request.contextPath}/COSMAS/request?command=getRequests',
							function(data) {
								alert("Response " + data);
							});

		}
		
	</script>

	<script>
		
		var i = 1;
		var j = 1;
		var k = 1;
		function auto_grow(element) {
			element.style.height = "5px";
			element.style.height = (element.scrollHeight) + "px";
		}
		
		function collapseExpandTosletRows() {
			if (i%2 != 0) {
				document.querySelectorAll(".toslet-collapsable").forEach(a=>a.style.display = "table-row");
				i = i+1;
			}
			else {
				document.querySelectorAll(".toslet-collapsable").forEach(a=>a.style.display = "none");
				i = i-1;
			}
		}
		
		function collapseExpandCasRows() {
			if (j%2 != 0) {
				document.querySelectorAll(".cas-collapsable").forEach(a=>a.style.display = "table-row");
				j = j+1;
			}
			else {
				document.querySelectorAll(".cas-collapsable").forEach(a=>a.style.display = "none");
				j = j-1;
			}
		}
		
		function collapseExpandFasRows() {
			if (k%2 != 0) {
				document.querySelectorAll(".fas-collapsable").forEach(a=>a.style.display = "table-row");
				k = k+1;
			}
			else {
				document.querySelectorAll(".fas-collapsable").forEach(a=>a.style.display = "none");
				k = k-1;
			}
		}
	</script>





	<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer"
		id="sec-835c">
		<div class="u-clearfix u-sheet u-sheet-1">
			<p class="u-small-text u-text u-text-default u-text-variant u-text-1">MOHAMAD
				BASYIR BIN ZAINUDDIN</p>
		</div>
	</footer>

</body>
</html>