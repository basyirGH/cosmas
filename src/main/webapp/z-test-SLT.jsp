<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.sltdist-thead-tr>th, .sltdist-tr1>th {
	text-align: left;
}

.sltdist-topic {
	resize: none;
	overflow: hidden;
	max-height: 200px;
}
</style>
</head>
<body>

	<form>
		<table id="slt-dist">
			<thead>
				<tr class="sltdist-thead-tr">
					<th></th>
					<th></th>
					<th colspan="4">Physical</th>
					<th colspan="4">Online</th>
					<th>Asynchronous</th>
				</tr>


				<tr class="sltdist-tr1">
					<th>Topic</th>
					<th>CLO</th>
					<th>L</th>
					<th>T</th>
					<th>P</th>
					<th>O</th>
					<th>L</th>
					<th>T</th>
					<th>P</th>
					<th>O</th>
				</tr>
			</thead>
			<tr>
				<td><textarea class="sltdist-topic" id="sltdist-topic-0"
						oninput="auto_grow(this)"></textarea></td>
				<td><input id="sltdist-clo-0" type="number" size="7"></td>
				<td><input id="sltdist-phy-lect-0" type="number" size="7"></td>
				<td><input id="sltdist-phy-tuto-0" type="number" size="7"></td>
				<td><input id="sltdist-phy-prac-0" type="number" size="7"></td>
				<td><input id="sltdist-phy-others-0" type="number" size="7"></td>
				<td><input id="sltdist-onl-lect-0" type="number" size="7"></td>
				<td><input id="sltdist-onl-tuto-0" type="number" size="7"></td>
				<td><input id="sltdist-onl-prac-0" type="number" size="7"></td>
				<td><input id="sltdist-onl-others-0" type="number" size="7"></td>
				<td><input type="number"></td>
				<td><button id="sltdist-new-topic" onclick="addRow()">+</button>
			</tr>
		</table>
	</form>

	<script>
				
		function auto_grow(element) {
			element.style.height = "5px";
			element.style.height = (element.scrollHeight) + "px";
		}
		
	</script>
</body>
</html>