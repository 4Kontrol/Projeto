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
	$(document).ready(function() {
		$("#listarVeiculos").click(function() {
			$("#conteudo").empty();
			$("#conteudo").load("exibeCarros.html");
		});

		$("#cadastrarVeiculos").click(function() {
			$("#conteudo").empty();
			$("#conteudo").submit("/abrirCadastroConcessionarias");
		});
	});
	$(function() {
		$.material.init();

	});

	$(document).ready(function() {
		$('#preco').maskMoney({
			showSymbol : true,
			symbol : "R$",
			decimal : ",",
			thousands : "."
		});
	});
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
								<li><a href="/pi4-app/abrirConcessionarias"
									id="listarConcessionarias">Listar concession�rias
										cadastrados</a></li>
								<li><a href="/pi4-app/abrirCadastroConcessionarias"
									id="cadastrarConcessionarias">Cadastrar concession�ria</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0)"
									id="outrasOpcoesConcessionarias">Outras op��es</a></li>
							</ul></li>
						<li class="dropdown"><a href="javascript:void(0)"
							class="dropdown-toggle" data-toggle="dropdown" role="button">Acess�rios<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)" id="listarAcessorios">Listar
										Acess�rios</a></li>
								<li><a href="javascript:void(0)" id="cadastrarAcessorios">Cadastrar
										Acess�rios</a></li>
								<li class="divider"></li>
								<li><a href="javascript:void(0)" id="listarKits">Listar
										Kits</a></li>
								<li><a href="javascript:void(0)" id="cadastrarKits">Cadastrar
										Kits</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Buscar...">
						</div>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="javascript:void(0)">Relat�rios</a></li>
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
		<div class="jumbotron">
			<div class="row">
				<div class="text-center">
					<h3>Concession�rias</h3>
				</div>
				<div class="conteudo">
					<div class="col-md-3"></div>
					<div class="tabela col-md-6">
						<table class="table table-bordered table-responsive text-center">
							<tr>
								<th>N�mero</th>
								<th>Nome</th>
								<th>A��es</th>
							</tr>
							<c:forEach var="concessionaria" items="${concessionarias}" varStatus="id">
								<tr>
								<td>${id.count}</td>
								<td>${concessionaria.nome}</td>
								<td><a href="">Editar</a>&nbsp &nbsp &nbsp <a href="">Excluir</a></td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>



		<div class="col-md-12" id="barra-rodape">
			<nav class="navbar navbar navbar-fixed-bottom ">
			<div class="container"></div>
			</nav>
		</div>
	</div>

</body>
</html>