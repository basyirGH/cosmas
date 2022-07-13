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
<body class="u-body">

	<br>
	<h5 class="u-text u-text-default u-text-2">Student Learning Time
		Distribution By Topic and Mode For Course ${courseCode} - ${courseName} </h5>
	<div id="chart"></div>
	<script>
	
		var options = {
			series : [ {
				name : 'PHYSICAL - LECTURE',
				data : ${pl_hours}
			}, {
				name : 'PHYSICAL - TUTORIAL',
				data : ${pt_hours}
			}, {
				name : 'PHYSICAL - PRACTICAL',
				data : ${pp_hours}
			}, {
				name : 'PHYSICAL - OTHERS',
				data : ${po_hours}
			}, {
				name : 'ONLINE - LECTURE',
				data : ${oo_hours}
			}, {
				name : 'ONLINE - TUTORIAL',
				data : ${oo_hours}
			}, {
				name : 'ONLINE - PRACTICAL',
				data : ${oo_hours}
			}, {
				name : 'ONLINE - OTHERS',
				data : ${oo_hours}
			} ],
			chart : {
				type : 'bar',
				height : 300,
				stacked : true,
				toolbar : {
					show : true
				},
				zoom : {
					enabled : true
				}
			},
			responsive : [ {
				breakpoint : 480,
				options : {
					legend : {
						position : 'bottom',
						offsetX : -10,
						offsetY : 0
					}
				}
			} ],
			plotOptions : {
				bar : {
					horizontal : false,
					borderRadius : 10
				},
			},
			xaxis : {
				type : 'category',
				categories : [${topics}],
			},
			legend : {
				position : 'right',
				offsetY : 40
			},
			fill : {
				opacity : 1
			}
		};

		var chart = new ApexCharts(document.querySelector("#chart"), options);
		chart.render();
	</script>
</body>
</html>
