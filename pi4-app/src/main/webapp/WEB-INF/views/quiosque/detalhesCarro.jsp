<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include> 
<div class="jumbotron">
            <div class="row">
            <form action="" method="post">
	            <div class="col-md-12 text-center"><h3><strong>Detalhes do carro</strong></h3></div>
	                <div class="col-md-5 " id="imagem">
	                    <img class="img-responsive" src="<c:url value='/resources/img/veiculos/${veiculo.imagem}'/>" alt=""/>
	                </div>
	                <div class="col-md-7" id="info">
	                    <div class="col-md-12"><strong>Marca: </strong>${veiculo.marca}</div>
	                    <div class="col-md-12"><strong>Modelo: </strong>${veiculo.modelo}</div>
	                    <div class="col-md-12"><strong>Ano: </strong>${veiculo.ano}</div>
	                    <div class="col-md-12"><strong>Cor: </strong>${veiculo.cor}</div>
	                    <div class="col-md-12"><strong>Portas: </strong>${veiculo.portas}</div>
	                    <div class="col-md-12"><strong>Combustivel: </strong>${veiculo.combustivel}</div>
	                    <div class="col-md-12"><strong>Potencia: </strong>${veiculo.potencia}</div>
	                    <div class="col-md-12"><strong>Cambio: </strong>${veiculo.cambio}</div>
	                    <div class="col-md-12"><strong>Velocidade máxima: </strong>${veiculo.velocidade}km/s</div>
	                    <div class="col-md-12"><strong>Estofado: </strong>${veiculo.estofado}</div>
	                    <div class="col-md-12"><strong>Som: </strong>${veiculo.som}</div>
	                    <div class="col-md-12"><strong>Capacidade: </strong>${veiculo.capacidade}</div>
	                    <div class="col-md-12"><strong>Preço: R$</strong>${veiculo.preco}</div>
	                </div>
	            </div>
	            <div class="text-center">
	            
	            <a href="/pi4-app/quiosque/iniciar"><input type="button" class="btn btn-danger" value="Cancelar"/></a>	           
	            <a href="/pi4-app/quiosque/selecaoKit"><input type="button" class="btn btn-primary" value="Personalizar"/></a>	            
	            <a><input type="button" class="btn btn-inverse" value="Finalizar pedido"/></a>
	            
	            </div>
            </form>
        </div>

 <jsp:include page="rodape.jsp"></jsp:include>  