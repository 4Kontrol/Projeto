<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include>

<div class="jumbotron">

            <div class="row">
            
            <form action="" id="formulario" method="post">
                <div class="col-md-12 text-center"><h3><strong>Seleção de Kit</strong></h3></div>
                <div class="col-md-3">
                    <div class="col-md-12">
                        <div class="form-group">
                                <div class="radio radio-primary">
                                <label>
                                    <input type="radio" name="kit" id="kit1" value="0" checked>
                                    <strong>--Nenhum--</strong>
                                </label>
                            </div>
                            <div class="col-lg-10">

                            </div>
                        </div>
                    </div>
                </div>

		<c:forEach var="kit" items="${kits}">
                <div class="col-md-3 controlKit">
                    <div class="col-md-12">
                        <div class="form-group">
                            <div class="radio radio-primary">
                                <label>
                                    <input type="radio" name="kit" id="${kit.id}" value="${kit.id }" onclick="ola(this.id);" >
                                    <strong>${kit.descricao}</strong>
                                </label>
                            </div>
                            <div class="col-lg-10">
                                <ul>
                                <c:forEach var="item" items="${kit.itensDoKit}">
                                    <li>${item.descricao}</li>                                    
                                </c:forEach>
                                </ul>
                                <div><strong>Preço: R$ </strong>${kit.preco}</div>
                            </div>
                        </div>
                    </div>
                </div>
          </c:forEach>
                <div class="text-center col-md-12">
	                <a href="/pi4-app/quiosque/veiculos"><input type="button" class="btn btn-danger" value="Voltar"/></a>
	                <input type="submit" class="btn btn-primary" value="Próximo"/>	                
            	</div>                
			</form>
            </div>
            
        </div>
        <script>
        	function ola(evt){        		
        		$("#formulario").attr("action","/pi4-app/quiosque/selecaoAcessorios/"+evt);
        	}
        </script>
        
<jsp:include page="rodape.jsp"></jsp:include>
