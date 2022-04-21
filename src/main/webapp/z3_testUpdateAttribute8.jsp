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
	
	<h1>Update CLO PLO Mapping for <c:out value="${course.courseCode}"> </c:out></h1>
	<form action="${request.contextPath}/COSMAS/ControllerCourse" method="post">
		<table>
			<tr> 
				
				<th> </th>
				<th> PLO1 </th>
				<th> PLO2  </th>
				<th> PLO3  </th>
				<td> Teaching Methods </td>
				<td> Assessment Methods</td>
			</tr>
			
			<tr>
				<td> CLO1 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO1" /> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO2" />  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO3" />  </td>
				<td> <input type="text" name="TeachingMethodsForCLO1" value="${course.teachingMethodsForCLO1}" />  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO1" value="${course.assessmentMethodsForCLO1}" />  </td>
			</tr>
			<tr>
				<td> CLO2 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO1"/> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO2"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO3"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO2" value="${course.teachingMethodsForCLO2}" />  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO2" value="${course.assessmentMethodsForCLO2}" />  </td>
			</tr>
			<tr>
				<td> CLO3 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO1"/> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO2"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO3"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO3" value="${course.teachingMethodsForCLO3}" />  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO3" value="${course.assessmentMethodsForCLO3}" />  </td>
			</tr>
			<tr>
				<td> Mapping with MQF Cluster of Learning Outcomes </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO1"/> </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO2"/> </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO3"/> </td>
			</tr>
		</table>
		<input type="hidden" name="courseCode" value="${course.courseCode}"/>
		<input type="hidden" name="checkedTrue" id="checkedTrue"/>
		<input type="hidden" name="MQFLOforPLOArray" id="MQFLOforPLOArray"/>
		<input type="submit" name="command" value="updateMapping8" />
	</form>
	<button onclick="saveAllMapping()">Save (click here first)</button>
	<p id="MQFLOforPLOMapping">  </p>
	
	<script>
		function saveAllMapping() {
			findCLOPLOCheckedTrue();
			findFilledMQFLOforPLO();
		}	
	
		function findCLOPLOCheckedTrue() {
			let allMappingCheckboxes = document.getElementsByName('mainMappingTable');
			let checkedTrue = [];
			
			for (let i=0; i<allMappingCheckboxes.length; i++) {
				
				if (allMappingCheckboxes[i].checked == true) {
					checkedTrue.push(allMappingCheckboxes[i].id);
					document.getElementById("checkedTrue").value = checkedTrue;
					
				}
			}
		}
		
		function findFilledMQFLOforPLO() {
			let allMQFLOforPLOtextfields = document.getElementsByName('MQFLOforPLOMapping');
			let filledMQFLOforPLOtextfields = [];
			
			for (let i=0; i<allMQFLOforPLOtextfields.length; i++) {
				
				if (allMQFLOforPLOtextfields[i].value != '') {
					filledMQFLOforPLOtextfields.push(allMQFLOforPLOtextfields[i].value);
				}
				else if (allMQFLOforPLOtextfields[i].value == '') {
					filledMQFLOforPLOtextfields.push('-');
				}
			}
			document.getElementById("MQFLOforPLOMapping").innerHTML = filledMQFLOforPLOtextfields;
			document.getElementById("MQFLOforPLOArray").value = filledMQFLOforPLOtextfields;
		}
	</script>
	
	
	all checked array: <p id="allChecked"> </p>
	
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