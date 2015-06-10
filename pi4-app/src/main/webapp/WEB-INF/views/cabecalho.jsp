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
	href="<c:url value="/resources/css/material-fullpalette.min."/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-switch-modificado."/>" />
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
		<div id="barra-navega��o" class="">
			<nav class="navbar navbar-default navbar-fixed-top"><!--inicio barra de navega��o -->
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="javascript:void(0)">4Kontrol</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="javascript:void(0)"
							class="dropdown-toggle" data-toggle="dropdown" role="button">Ve�culos<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0) " id="listarVeiculos">Listar
										ve�culos cadastrados</a></li>
								<li><a href="javascript:void(0)" id="cadastrarVeiculos">Cadastrar
										ve�culo</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0)" id="outrasOpcoesVeiculos">Outras
										op��es</a></li>
							</ul></li>
						<li class="active dropdown"><a href="javascript:void(0)"
							class="dropdown-toggle" data-toggle="dropdown" role="button">Concession�rias<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/pi4-app/concessionaria/listarConcessionarias"
									id="listarConcessionarias">Listar concession�rias
										cadastrados</a></li>
								<li><a href="/pi4-app/concessionaria/abrirFormulario"
									id="cadastrarConcessionarias">Cadastrar concession�ria</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0)"
									id="outrasOpcoesConcessionarias">Outras op��es</a></li>
							</ul></li>
						<li class="dropdown"><a href="javascript:void(0)"
							class="dropdown-toggle" data-toggle="dropdown" role="button">Acess�rios<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/pi4-app/acessorio/listar"
									id="listarAcessorios">Listar Acess�rios</a></li>
								<li><a href="/pi4-app/acessorio/abrirFormulario"
									id="cadastrarAcessorios">Cadastrar Acess�rios</a></li>
								<li class="divider"></li>
								<li><a href="/pi4-app/kit/listar" id="listarKits">Listar
										Kits</a></li>
								<li><a href="/pi4-app/kit/abrirFormulario" id="cadastrarKits">Cadastrar
										Kits</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Buscar...">
						</div>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/pi4-app/relatorios/menu">Relat�rios</a></li>
						<li class="dropdown"><a href="javascript:void(0)"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false">Usu�rio<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)">Configura��es de
										usu�rio</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0)">Finalizar</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid --> </nav>
		</div>
		<!--fim da barra de navega??o -->