<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<body>
	<h1>Create CLO PLO Mapping</h1>
	<form action="${request.contextPath}/COSMAS/ControllerCourse" method="post">
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
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO1" /> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO2" />  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO1forPLO3" />  </td>
				<td> <input type="text" name="TeachingMethodsForCLO1" id="" />  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO1" id="" />  </td>
			</tr>
			<tr>
				<td> CLO2 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO1"/> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO2"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO2forPLO3"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO2" id="" />  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO2" id="" />  </td>
			</tr>
			<tr>
				<td> CLO3 </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO1"/> </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO2"/>  </td>
				<td> <input type="checkbox" name="mainMappingTable" id="CLO3forPLO3"/>  </td>
				<td> <input type="text" name="TeachingMethodsForCLO3" id="" />  </td>
				<td> <input type="text" name="AssessmentMethodsForCLO3" id="" />  </td>
			</tr>
			<tr>
				<td> Mapping with MQF Cluster of Learning Outcomes </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO1"/> </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO2"/> </td>
				<td> <input type="text" name="MQFLOforPLOMapping" id="MQFLOforPLO3"/> </td>
			</tr>
		</table>
		<input type="hidden" name="CLOPLOcheckedTrue" id="checkedTrueCLOPLOArray"/>
		<input type="hidden" name="MQFLOforPLOArray" id="MQFLOforPLOArray"/>
		<input type="submit" name="command" value="addMapping8" />
		
	</form>
	<button onclick="saveAllMapping()">Save (click here first)</button>
	<p id="MQFLOforPLOMapping">  </p>
	<script>
		
		function saveAllMapping() {
			findCLOPLOCheckedTrue();
			findFilledMQFLOforPLO();
		}
	
		function findCLOPLOCheckedTrue() {
			let allCLOPLOMappingCheckboxes = document.getElementsByName('mainMappingTable');
			let checkedTrue = [];
			
			for (let i=0; i<allCLOPLOMappingCheckboxes.length; i++) {
				
				if (allCLOPLOMappingCheckboxes[i].checked == true) {
					checkedTrue.push(allCLOPLOMappingCheckboxes[i].id);
				}
			}
			document.getElementById("checkedTrueCLOPLOArray").value = checkedTrue;
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
		
		
		/*function findTMforCLO() {
			let allTMforCLOTextFields = document.getElementsByName('TMforCLOMappingTable');
			let filled = [];
			
			for (let i=0; i<allTMforCLOTextFields.length; i++) {
				
				if (allTMforCLOTextFields[i] != "") {
					filled.push(allTMforCLOTextFields[i].value);
					document.getElementById("filledTMCLOArray").value = filled;
					document.getElementById("filledTMCLO").innerHTML = filled;
					//problem with values in the filled array. which element goes to which clo?
				}
			}
		}*/
		
		
	</script>
		
	<h1>Read CLO PLO Mapping</h1>
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
		
	</form>
		
</body>
</html>