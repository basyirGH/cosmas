<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>Courses</title>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
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
	<h5 class="u-text u-text-default u-text-2">PLOs Count For All Courses </h5>
	<div id="chart"></div>
	<script>
		var options = {
			series : [ ${PLO1}, ${PLO2}, ${PLO3}, ${PLO4}, ${PLO5}, ${PLO6}, ${PLO7}, ${PLO8}, ${PLO9}, ${PLO10}, ${PLO11} ],
			chart : {
				width : 700,
				type : 'pie',
			},
			labels : [ 
				'PLO1-Knowledge & Understanding', 
				'PLO2-Practical Skills', 
				'PLO3-Cognitive Skill', 
				'PLO4-Communication Skills', 
				'PLO5-Interpersonal Skills',
				'PLO6-Ethics & Professionalism',
				'PLO7-Personal Skills',
				'PLO8-Entrepreneurial Skills',
				'PLO9-Leadership, Autonomy & Responsibility',
				'PLO10-Digital Skills',
				'PLO11-Numeracy Skills'],
			responsive : [ {
				breakpoint : 480,
				options : {
					chart : {
						width : 200
					},
					legend : {
						position : 'bottom'
					}
				}
			} ]
		};

		var chart = new ApexCharts(document.querySelector("#chart"), options);
		chart.render();
	</script>
	</section>
</body>
</html>

