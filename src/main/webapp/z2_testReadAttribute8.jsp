<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table, th, td {
  	border: 1px solid black;
}
</style>
</head>

<body onload="getEverything()">
	<a href="z_testCreateAttribute8.jsp"><h1>Create CLO PLO Mapping</h1></a>
	
	<h1>Read CLO PLO Mapping for ${course.courseCode} </h1>
	<form action="${request.contextPath}/COSMAS/ControllerCourse" method="post">
		<input type="radio" id="radio1" name="courseCode" value="COURSE01"/>
		<label for="radio1">COURSE01</label>
		<input type="radio" id="radio2" name="courseCode" value="COURSE02"/>
		<label for="radio2">COURSE02</label><br/>
		<input type="radio" id="radio3" name="courseCode" value="COURSE03"/>
		<label for="radio3">COURSE03</label><br/>
		<input type="radio" id="radio4" name="courseCode" value="COURSE04"/>
		<label for="radio4">COURSE04</label><br/>
		<input type="radio" id="radio5" name="courseCode" value="COURSE08"/>
		<label for="radio5">COURSE08</label><br/>
		<input type="radio" id="radio6" name="courseCode" value="COURSE12"/>
		<label for="radio6">COURSE12</label><br/>
		<input type="radio" id="radio7" name="courseCode" value="COURSE13"/>
		<label for="radio7">COURSE13</label><br/>
		
		
		<input type="submit" name="command" value="readMapping8"/>
		<table>
			<tr> 
				
				<th> </th>
				<th> PLO1 </th>
				<th> PLO2  </th>
				<th> PLO3  </th>
				<td> Teaching Methods </td>
				<td> Assessment Methods </td>
			
			</tr>
			
			<tr>
				<td> CLO1 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO1" disabled="disabled" /> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO2" disabled="disabled"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO3" disabled="disabled"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO1" value="${course.teachingMethodsForCLO1}" readonly/>  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO1" value="${course.assessmentMethodsForCLO1}" readonly/>  </td>
			</tr>
			<tr>
				<td> CLO2 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO1" disabled="disabled"/> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO2" disabled="disabled"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO3" disabled="disabled"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO2" value="${course.teachingMethodsForCLO2}" readonly/>  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO2" value="${course.assessmentMethodsForCLO2}" readonly/>  </td>
			</tr>
			<tr>
				<td> CLO3 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO1" disabled="disabled"/> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO2" disabled="disabled"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO3" disabled="disabled"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO3" value="${course.teachingMethodsForCLO3}" readonly/>  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO3" value="${course.assessmentMethodsForCLO3}" readonly/>  </td>
			</tr>
			<tr>
				<td> Mapping with MQF Cluster of Learning Outcomes </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO1" readonly/> </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO2" readonly/> </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO3" readonly/> </td>
			</tr>
		</table>
		<input type="submit" name="command" value="getPageForUpdateMapping8"/>
	</form>
	
	
	all checked array: <p id="allChecked"> </p>
	<p id="MQFLOforPLOMapping">  </p>
	
	<script>
		var delimiter = ',';
		var openBracket = '[';
		var closeBracket = ']';
		var temp = '';
	
		function getEverything() {
			getChecked();
			getFilled();
		}
		
		function getChecked(){
			let allCheckedTrue = '${course.courseCLOPLOMapping}';
			let allCheckedTrueArray = [];
			let collectionOfMappingCheckBoxes = document.getElementsByName('mainMappingTable');
			
			for (let i=0; i<allCheckedTrue.length; i++) {
				let c = allCheckedTrue[i];
				
				if (c != delimiter && c != ' ' && c != openBracket && c != closeBracket) {
					temp = temp + c;
				}
				
				if (c == delimiter || i == allCheckedTrue.length-2) {
					allCheckedTrueArray.push(temp);
					temp = "";
				}
			}
			
			document.getElementById('allChecked').innerHTML = allCheckedTrueArray.toString();
			
			for (let i=0; i<collectionOfMappingCheckBoxes.length; i++) {
				for (let j=0; j<allCheckedTrueArray.length; j++) {
					let currentCheckBoxId = collectionOfMappingCheckBoxes[i].id;
					let currentCheckedTrueId = allCheckedTrueArray[j];
					
					if (currentCheckBoxId == currentCheckedTrueId) {
						document.getElementById(currentCheckBoxId).checked = true;
					}
				}
			}
		}
		
		function getFilled() {
			let allFilledMQFLOforPLO = '${course.MQFLOforPLO}';
			let allFilledMQFLOforPLOArray = [];
			let collectionOfMQFLOforPLOTextfields = document.getElementsByName('MQFLOforPLOMapping');
			
			for (let i=0; i<allFilledMQFLOforPLO.length; i++) {
				let c = allFilledMQFLOforPLO[i];
				
				if (c != delimiter && c != ' ' && c != openBracket && c != closeBracket) {
					temp = temp + c;
				}
				
				if (c == delimiter || i == allFilledMQFLOforPLO.length-2) {
					allFilledMQFLOforPLOArray.push(temp);
					temp = "";
				}
			}
			
			document.getElementById('MQFLOforPLOMapping').innerHTML = allFilledMQFLOforPLOArray.toString();
			
			for (let i=0; i<collectionOfMQFLOforPLOTextfields.length; i++) {
				let currentTextFieldId = collectionOfMQFLOforPLOTextfields[i].id;
				document.getElementById(currentTextFieldId).value = allFilledMQFLOforPLOArray[i];
			}
		}
		
		
	</script>
	
		
</body>
</html>