<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
</head>
<body>
	<br>
	<h5>
		Courses And SLTs Matrix <a
			href="${request.contextPath}/COSMAS/analysis?type=download-slt-matrix">Download</a>
	</h5>
	<table class="table table-bordered">
		<tr>
			<td>Course Code</td>
			<td>Course Name</td>
			<td>Credit Value</td>
			<td>PHYSICAL (LECTURE)</td>
			<td>PHYSICAL (TUTORIAL)</td>
			<td>PHYSICAL (PRACTICAL)</td>
			<td>PHYSICAL (OTHERS)</td>
			<td>ONLINE (LECTURE)</td>
			<td>ONLINE (TUTORIAL)</td>
			<td>ONLINE (PRACTICAL)</td>
			<td>ONLINE (OTHERS)</td>
			<td>NON F2F</td>
			<td>CONTINOUS ASSESSMENT (PHYSICAL)</td>
			<td>CONTINOUS ASSESSMENT (ONLINE)</td>
			<td>CONTINOUS ASSESSMENT (NF2F)</td>
			<td>FINAL ASSESSMENT (PHYSICAL)</td>
			<td>FINAL ASSESSMENT (ONLINE)</td>
			<td>FINAL ASSESSMENT (NF2F)</td>
			<td>TOTAL STUDENT LEARNING TIME</td>
		</tr>
	
	</table>
</body>
</html>