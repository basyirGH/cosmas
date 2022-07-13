<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<style>
</style>
</head>
<body>
	<br>
	<h5>Courses And PLOs Matrix <a 
		href="${request.contextPath}/COSMAS/analysis?type=download-cap-matrix">Download</a></h5>
	<table class="table table-bordered">
		<tr>
			<td>Course Code</td>
			<td>Course Name</td>
			<td>Credit Value</td>
			<td>PLO1</td>
			<td>PLO2</td>
			<td>PLO3</td>
			<td>PLO4</td>
			<td>PLO5</td>
			<td>PLO6</td>
			<td>PLO7</td>
			<td>PLO8</td>
			<td>PLO9</td>
			<td>PLO10</td>
			<td>PLO11</td>
		</tr>
		<c:forEach items="${capList}" var="cap">
			<tr>
				<td>${cap.courseCode}</td>
				<td>${cap.courseName}</td>
				<td>${cap.courseCredit}</td>
				<td>${cap.plo1}</td>
				<td>${cap.plo2}</td>
				<td>${cap.plo3}</td>
				<td>${cap.plo4}</td>
				<td>${cap.plo5}</td>
				<td>${cap.plo6}</td>
				<td>${cap.plo7}</td>
				<td>${cap.plo8}</td>
				<td>${cap.plo9}</td>
				<td>${cap.plo10}</td>
				<td>${cap.plo11}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>