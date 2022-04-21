/**
 * 
 */
 


function addCourseOK(){
	closeCourseFields();
	document.getElementById("add-course-submit").style.display = "none";
	document.getElementById("add-course-OK").style.display = "block";
	setTimeout(hideAddCourseOK, 3000);
}

function hideAddCourseOK(){
	document.getElementById("add-course-OK").style.display = "none";
}

document.getElementById("edit-course-submit").addEventListener("click", 
	function editCourseOK(){
		closeCourseFields();
		document.getElementById("edit-course-submit").style.display = "none";
		document.getElementById("edit-course-ok").style.display = "block";
		setTimeout(hideEditCourseOK, 3000);
	}
);

function hideEditCourseOK(){
	document.getElementById("edit-course-ok").style.display = "none";
}


function closeCourseFields() {
	document.getElementById("name-2b64").setAttribute("readonly", true);
	document.getElementById("email-2b64").setAttribute("readonly", true);
	document.getElementById("message-2b64").setAttribute("readonly", true);
	document.getElementById("text-46f2").setAttribute("readonly", true);
	document.getElementById("textarea-377c").setAttribute("readonly", true);
	document.getElementById("text-f70c").setAttribute("readonly", true);
	document.getElementById("text-2b51").setAttribute("readonly", true);
	document.getElementById("text-7fdf").setAttribute("readonly", true);
	document.getElementById("text-15de").setAttribute("readonly", true);
	document.getElementById("text-32c5").setAttribute("readonly", true);
	document.getElementById("text-c8be").setAttribute("readonly", true);
	document.getElementById("text-47cc").setAttribute("readonly", true);
	document.getElementById("text-fb22").setAttribute("readonly", true);
	document.getElementById("text-fc68").setAttribute("readonly", true);
	document.getElementById("text-e410").setAttribute("readonly", true);
}


