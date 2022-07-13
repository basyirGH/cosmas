<!DOCTYPE html>
<html>
<head>
<style>
#married-form {
	display: none;
}
</style>
</head>
<body>

	<h1>Display Radio Buttons</h1>



	<p>Please select your favorite Web language:</p>
	 
	<div id="html-div">
		<input type="radio" id="html" name="fav_language" value="HTML">
		  <label for="html">HTML</label>
	</div>


	<br>  

	<div id="married-form">
		<form action="" method="post">
			<label> nama spouse: </label> <input type="text">
		</form>
	</div>
	<script>
		document.getElementById("html").addEventListener("click", showMyForm);

		function showMyForm() {
			document.getElementById("married-form").style.display = "block";
		}
	</script>



</body>
</html>
