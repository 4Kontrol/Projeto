<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include> 

<div class="jumbotron">
    <p><strong>Escolha o carro!</strong></p>

    <div class="row text-left">
        <div class="col-md-12">
            <p class="text-left">Filtrar por:</p>
        </div>
        <div class="btn-group text-left col-md-12" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Marca
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Audi</a></li>
                    <li><a href="#">BMW</a></li>
                    <li><a href="#">Bentley</a></li>
                    <li><a href="#">GM</a></li>
                    <li><a href="#">Citroën</a></li>
                    <li><a href="#">Dodge</a></li>
                    <li><a href="#">Ferrari</a></li>
                    <li><a href="#">Fiat</a></li>
                    <li><a href="#">Ford</a></li>
                    <li><a href="#">Honda</a></li>
                    <li><a href="#">Land Rover</a></li>
                    <li><a href="#">Nissan</a></li>
                    <li><a href="#">Peugeot</a></li>
                    <li><a href="#">Porsche</a></li>
                    <li><a href="#">Toyota</a></li>
                    <li><a href="#">Volkswagen</a></li>
                    <li><a href="#">Volvo</a></li>
                    <li><a href="#">Wayne Enterprises</a></li>

                </ul>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Preço
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Até R$10.000,00</a></li>
                    <li><a href="#">Até R$20.000,00</a></li>
                    <li><a href="#">Até R$30.000,00</a></li>
                    <li><a href="#">Até R$40.000,00</a></li>
                    <li><a href="#">Até R$50.000,00</a></li>
                    <li><a href="#">Até R$60.000,00</a></li>
                    <li><a href="#">Até R$70.000,00</a></li>
                    <li><a href="#">Até R$80.000,00</a></li>
                    <li><a href="#">Até R$90.000,00</a></li>
                    <li><a href="#">Até R$100.000,00</a></li>
                    <li><a href="#">Até R$200.000,00</a></li>
                </ul>
            </div>
        </div>

    </div>
    <br>
    
    

    <div class="row text-left">
    	<c:forEach var="veiculo" items="${veiculos}">
	        <a href="/pi4-app/quiosque/detalhes/${veiculo.id}">
	        	<div class="col-md-2 car">	        	
	            <img class="img-responsive" src="<c:url value='/resources/img/veiculos/${veiculo.imagem}'/>" alt=""/><br>
	            <div><strong>Modelo: </strong>${veiculo.modelo}</div>
	            <div><strong>Marca: </strong>${veiculo.marca}</div>
	            <div><strong>Ano: </strong>${veiculo.ano}</div>
	            <div><strong>Cor: </strong>${veiculo.cor}</div>
	            <div><strong>Preço: R$</strong>${veiculo.preco}</div>
	        </div>
	        </a>
        </c:forEach>        
	</div>


<nav>
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<!-- Modal HTML -->
<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Informação</h4>
            </div>
            <div class="modal-body">
                <p>Informações sobre o veículo</p>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Finalizar pedido</button>
                <button type="button" class="btn btn-primary">Personalizar</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="rodape.jsp"></jsp:include>
