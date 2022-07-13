<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Add-New-Course.css" media="screen">
<title>Insert title here</title>
</head>
<body>
	<form action="${request.contextPath}/COSMAS/user" method="post">
		<h5 style="color: #5085BA" class="u-text u-text-default u-text-1">
			<a><input type="submit" name="command" value="Home"
				class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-palette-1-base u-btn-1"></a>
			<span style="color: black"> > Add New Course </span>
		</h5>
	</form>

</body>
</html>