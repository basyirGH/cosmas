/**
 * 
 */

var delimiter = ',';
var openBracket = '[';
var closeBracket = ']';
var temp = '';

function getEverythingAndSave() {
	getChecked();
	getFilled();
	setInterval(saveAllMapping, 1000);
}

function getEverything() {
	getChecked();
	getFilled();
	setInterval(saveAllMapping, 1000);
}

function getChecked(){
	let allCheckedTrue = document.getElementById('allCheckedTrue').value;
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
	let allFilledMQFLOforPLO = document.getElementById('allFilledMQFLOforPLO').value;
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
	
	
	for (let i=0; i<collectionOfMQFLOforPLOTextfields.length; i++) {
		let currentTextFieldId = collectionOfMQFLOforPLOTextfields[i].id;
		document.getElementById(currentTextFieldId).value = allFilledMQFLOforPLOArray[i];
	}
}

function initPage() {
	setInterval(saveAllMapping, 1000);
}

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
	document.getElementById("MQFLOforPLOTestReceive").innerHTML = filledMQFLOforPLOtextfields;
	document.getElementById("MQFLOforPLOArray").value = filledMQFLOforPLOtextfields;
}