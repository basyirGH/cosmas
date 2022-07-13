<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>Edit Course</title>
<link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Add-New-Course.css" media="screen">
<script class="u-script" type="text/javascript" src="nicepage.js"
	defer=""></script>
<script class="u-script" type="text/javascript" src="cosmas.js" defer=""></script>
<script class="u-script" type="text/javascript"
	src="attribute-8-mapping.js" defer=""></script>
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
<meta name="theme-color" content="#478ac9">
<meta property="og:title" content="Add New Course">
<meta property="og:type" content="website">
<style>
.attribute-8-table {
	table-layout: auto;
	column-width: 100%;
	display: block;
	overflow-x: auto;
	white-space: nowrap;
	background-color: grey;
}

.first-columns-attribute8 {
	padding: 5px;
}
</style>
</head>
<body onload="getEverythingAndSave()" class="u-body">
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
					<span style="color: black"> > Courses > Edit Course
						${course.courseName} </span>
				</h5>
			</form>
			<div class="u-list u-list-1">
				<div class="u-repeater u-repeater-1">
					<div
						class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-container-style u-hover-feature u-list-item u-repeater-item u-shape-rectangle u-list-item-1">
						<div
							class="u-container-layout u-similar-container u-container-layout-1">
							<a
								href="${request.contextPath}/COSMAS/course?command=goToFileChooser&fromCommand=saveEdit"
								class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"><span
								class="u-file-icon u-icon u-icon-1"><img
									src="images/29111922.png" alt=""></span>&nbsp;<br>Extract&nbsp;<br>from
								Excel </a>
						</div>
					</div>
					<div
						class="u-align-center u-container-style u-hover-feature u-list-item u-repeater-item u-shape-rectangle u-list-item-2">
						<div
							class="u-container-layout u-similar-container u-container-layout-2">
							<a href="Courses.html" data-page-id="14932833"
								class="u-align-center u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-2"><span
								class="u-file-icon u-icon u-icon-2"><img
									src="images/18286652.png" alt=""></span>&nbsp;<br>Clear
								Unsaved Changes&nbsp;<br>and Exit </a>
						</div>
					</div>
				</div>
			</div>
			<div class="u-form u-form-1">
				<form action="${request.contextPath}/COSMAS/course" method="POST"
					class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form"
					source="custom" name="form" style="padding: 10px;">
					<div class="u-form-group u-form-name u-label-left">
						<label for="name-2b64" class="u-label u-spacing-75 u-label-1">Course
							Name</label> <input value="${course.courseName}" type="text"
							id="name-2b64" name="courseName"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">
					</div>
					<div class="u-form-email u-form-group u-label-left u-form-group-2">
						<label for="email-2b64" class="u-label u-spacing-75 u-label-2">Course
							Code</label> <input value="${course.courseCode}" type="text"
							id="email-2b64" name="courseCode"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">
					</div>
					<div class="u-form-group u-label-left">
						<label for="message-2b64" class="u-label u-spacing-75 u-label-3">Course
							Classification</label> <input value="${course.courseClassification}"
							type="text" id="message-2b64" name="courseClassification"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">
					</div>
					<div
						class="u-form-group u-form-message u-label-left u-form-group-4">
						<label for="text-46f2" class="u-label u-spacing-75 u-label-4">Synopsis</label>
						<textarea placeholder="" id="text-46f2" name="courseSynopsis"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white u-input-4">${course.courseSynopsis}</textarea>
					</div>
					<div
						class="u-form-group u-form-textarea u-label-left u-form-group-5">
						<label for="textarea-377c" class="u-label u-spacing-75 u-label-5">Academic
							Staff(s)</label>
						<textarea rows="4" cols="50" id="textarea-377c"
							name="courseAcadStaff"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white"
							required="">${course.courseAcadStaff}</textarea>
					</div>
					<div class="u-form-group u-label-left u-form-group-6">
						<label for="text-f70c" class="u-label u-spacing-75 u-label-6">Semester
							and Year Offered</label> <input value="${course.courseSemYearOffered}"
							type="text" placeholder="" id="text-f70c"
							name="courseSemYearOffered"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-7">
						<label for="text-2b51" class="u-label u-spacing-75 u-label-7">Credit
							Value</label> <input value="${course.courseCredit}" type="text"
							placeholder="" id="text-2b51" name="courseCredit"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-8">
						<label for="text-7fdf" class="u-label u-spacing-75 u-label-8">Pre-requisite/co-requisite
							(if any)</label> <input value="${course.coursePrerequisite}" type="text"
							placeholder="" id="text-7fdf" name="coursePrerequisite"
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
						<label for="table-attr-8" class="u-label u-spacing-75 u-label-8">Mapping
							of the Course Learning Outcomes to Program Learning Outcomes,
							Teaching Methods and Assessment Methods</label>
						<table id="table-attr-8" class="attribute-8-table">
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
								<td class="first-columns-attribute8">CLO1</td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO01" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO02" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO03" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO04" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO05" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO06" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO07" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO08" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO09" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO10" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO1forPLO11" /></td>
								<td><textarea name="TeachingMethodsForCLO1" id=""> ${course.teachingMethodsForCLO1} </textarea>
								</td>
								<td><textarea name="AssessmentMethodsForCLO1" id=""> ${course.assessmentMethodsForCLO1} </textarea>
								</td>
							</tr>
							<tr>
								<td class="first-columns-attribute8">CLO2</td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO01" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO02" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO03" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO04" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO05" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO06" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO07" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO08" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO09" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO10" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO2forPLO11" /></td>
								<td><textarea name="TeachingMethodsForCLO2" id=""> ${course.teachingMethodsForCLO2} </textarea>
								</td>
								<td><textarea name="AssessmentMethodsForCLO2" id=""> ${course.assessmentMethodsForCLO2} </textarea>
								</td>
							</tr>
							<tr>
								<td class="first-columns-attribute8">CLO3</td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO01" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO02" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO03" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO04" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO05" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO06" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO07" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO08" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO09" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO10" /></td>
								<td><input type="checkbox" name="mainMappingTable"
									id="CLO3forPLO11" size="10" /></td>
								<td><textarea name="TeachingMethodsForCLO3" id=""> ${course.teachingMethodsForCLO3}  </textarea>
								</td>
								<td><textarea name="AssessmentMethodsForCLO3" id=""> ${course.assessmentMethodsForCLO3} </textarea>
								</td>
							</tr>
							<tr>
								<td class="first-columns-attribute8">Mapping with MQF
									Cluster <br> of Learning Outcomes
								</td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO1" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO2" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO3" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO4" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO5" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO6" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO7" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO8" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO9" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO10" size="4" /></td>
								<td><input type="text" name="MQFLOforPLOMapping"
									id="MQFLOforPLO11" size="4" /></td>
							</tr>
							<tr>
								<td><input type="hidden" id="MQFLOforPLOTestReceive"></td>
							</tr>

						</table>

					</div>
					<div class="u-form-group u-label-left u-form-group-10">
						<label for="text-32c5" class="u-label u-spacing-75 u-label-10">Transferrable
							Skills</label> <input value="${course.courseTransSkills}" type="text"
							placeholder="" id="text-32c5" name="courseTransSkills"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-11">
						<label for="text-c8be" class="u-label u-spacing-75 u-label-11">SLT
							Distribution</label> <input value="${course.courseSLTDist}" type="text"
							placeholder="" id="text-c8be" name="courseSLTDist"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-12">
						<label for="text-47cc" class="u-label u-spacing-75 u-label-12">Special
							Requirements</label> <input value="${course.courseSpecialReq}"
							type="text" placeholder="" id="text-47cc" name="courseSpecialReq"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white u-input-12">
					</div>
					<div class="u-form-group u-label-left u-form-group-13">
						<label for="text-fb22" class="u-label u-spacing-75 u-label-13">References</label>
						<textarea rows="10" placeholder="" id="text-fb22"
							name="courseReferences"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">${course.courseReferences}</textarea>
					</div>
					<div class="u-form-group u-label-left u-form-group-14">
						<label for="text-fc68" class="u-label u-spacing-75 u-label-14">Other
							info</label> <input value="${course.courseOtherInfo}" type="text"
							id="text-fc68" name="courseOtherInfo"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>
					<div class="u-form-group u-label-left u-form-group-15">
						<label for="text-e410" class="u-label u-spacing-75 u-label-15">Dates
							of Approval</label> <input value="${course.courseDatesApproval}"
							type="text" id="text-e410" name="courseDatesApproval"
							class="u-border-3 u-border-grey-30 u-input u-input-rectangle u-white">
					</div>

					<!-- submit -->

					<div class="u-align-left u-form-group u-form-submit">
						<input type="hidden" value="${course.courseCLOPLOMapping}"
							name="allCheckedTrue" id="allCheckedTrue" /> <input type="hidden"
							value="${course.MQFLOforPLO}" name="allFilledMQFLOforPLO"
							id="allFilledMQFLOforPLO" /> <input type="hidden"
							name="MQFLOforPLOArray" id="MQFLOforPLOArray" /> <input
							type="hidden" name="checkedTrueCLOPLOArray"
							id="checkedTrueCLOPLOArray" /> <input type="hidden"
							name="allChecked" id="allChecked" /> <input type="hidden"
							name="checkedTrue" id="checkedTrue" /> <input
							id="edit-course-submit" type="submit" value="Save Edit"
							name="command" class="u-btn u-btn-submit u-button-style">
						<input type="button" value="Clear Unsaved Changes and Exit"
							class="u-btn u-btn-submit u-button-style"> <input
							type="hidden" value="${courseCodeOld}" name="courseCodeOld">
					</div>
					<div id="edit-course-ok"
						class="u-form-send-message u-form-send-success">Edit saved
						successfully.</div>
					<div class="u-form-send-error u-form-send-message">Unable to
						send your message. Please fix errors then try again.</div>
					<input type="hidden" value="" name="recaptchaResponse">
				</form>
			</div>
		</div>

	</section>

	<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer"
		id="sec-835c">
		<div class="u-clearfix u-sheet u-sheet-1">
			<p class="u-small-text u-text u-text-default u-text-variant u-text-1">MOHAMAD
				BASYIR BIN ZAINUDDIN</p>
		</div>
	</footer>

</body>
</html>