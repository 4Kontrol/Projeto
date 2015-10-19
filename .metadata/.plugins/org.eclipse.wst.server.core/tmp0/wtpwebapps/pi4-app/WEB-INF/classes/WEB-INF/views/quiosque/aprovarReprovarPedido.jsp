<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include>
<div class="jumbotron">
	<div class="row">
		<div class="col-md-12 text-center">
			<h3>
				<strong>Detalhes do pedido</strong>
			</h3>
			<div>
			<strong>Data de Emissão: </strong>			
			</div>
			<div>
				<strong>Cliente: </strong>${cliente.nome}
			</div>	
		</div>
		<div class="col-md-4">
			<img class="img-responsive" src="<c:url value='/resources/img/veiculos/${veiculo.imagem}'/>"
				alt="imagem do carro selecionado" />
		</div>
		<div class="col-md-4" id="detalhes">
			<div class="col-md-12">
				<strong>Marca: </strong>${veiculo.marca}</div>
			<div class="col-md-12">
				<strong>Modelo: </strong>${veiculo.modelo}</div>
			<div class="col-md-12">
				<strong>Ano: </strong>${veiculo.ano}</div>
			<div class="col-md-12">
				<strong>Cor: </strong>${veiculo.cor}</div>
			<div class="col-md-12">
				<strong>Portas: </strong>${veiculo.portas}</div>
			<div class="col-md-12">
				<strong>Combustivel: </strong>${veiculo.combustivel}</div>
			<div class="col-md-12">
				<strong>Potencia: </strong>${veiculo.potencia}</div>
			<div class="col-md-12">
				<strong>Cambio: </strong>${veiculo.cambio}</div>
			<div class="col-md-12">
				<strong>Velocidade máxima: </strong>${veiculo.velocidade}km/s</div>
			<div class="col-md-12">
				<strong>Estofado: </strong>${veiculo.estofado}</div>
			<div class="col-md-12">
				<strong>Som: </strong>${veiculo.som}</div>
			<div class="col-md-12">
				<strong>Capacidade: </strong>${veiculo.capacidade}</div>
			<div class="col-md-12">
				<strong>Preço: R$</strong>${veiculo.preco}</div>
		</div>
		<div class="col-md-4">
			<h4>
				<strong>Kit</strong>
			</h4>

			<strong>${kit.descricao}</strong>
			<ul>
				<c:forEach var="item" items="${kit.itensDoKit}">
					<li>${item.descricao}</li>
				</c:forEach>
			</ul>
			<div>
				<strong>Preço: R$ </strong>${kit.preco}
			</div>
		</div>
		<div></div>
		<div class="col-md-4">
			<h4>
				<strong>Acessórios</strong>
			</h4>
			<table>
				<tr>
					<th>Acessório</th>
					<th>Preço</th>
				</tr>
				
				<c:forEach var="acessorio" items="${acessorios}">
					<tr>
						<td>${acessorio.descricao}</td>
						<td>${acessorio.preco}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-md-4"></div>
		<div class="col-md-4">

			<div class="alert alert-success">
				<label class="">TOTAL: RS</label><strong>${prePedido.preco}</strong>
			</div>
		</div>
		<div class="col-md-4">
			<h4>
				<strong>Concessionária</strong>
			</h4>
			<div>
				<strong>${veiculo.concessionaria.nome }</strong>
				<div>${veiculo.concessionaria.endereco.endereco}</div>
			</div>
		</div>
		
		
		<div class="text-center col-md-12">
			<a href="/pi4-app/quiosque/concessionaria/listarPedidos"><input type="button" class="btn btn-danger" value="Cancelar" /></a>
			<a href="/pi4-app/quiosque/concessionaria/listarPedidos"><input type="button" class="btn btn-inverse" value="Aprovar"/></a>
		</div>
	</div>
</div>

<jsp:include page="rodape.jsp"></jsp:include>
