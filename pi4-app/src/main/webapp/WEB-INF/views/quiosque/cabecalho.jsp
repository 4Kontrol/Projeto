<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>: : : 4Kontrol : : :</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"
	user-scalable="no">
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-2.1.1.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/material.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/ripples.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/roboto.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/material-fullpalette.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-switch-modificado.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-switch.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrao_antigo.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/material.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/ripples.min.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/my_style.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/maskMoney.js"/>">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.nouislider.min.js"/>"></script>

<script>
	$(function() {
		$.material.init();
	});

	//         $(document).ready(function(){
	//             $('#preco').maskMoney({showSymbol:true, symbol:"R$", decimal:",",thousands:"."});
	//         });
</script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">4Kontrol</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-left" role="search">
					<input type="text" class="form-control" placeholder="Search">
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>