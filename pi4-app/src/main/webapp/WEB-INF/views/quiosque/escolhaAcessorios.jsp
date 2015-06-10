<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include> 
<div class="jumbotron">

            <div class="row">
            <form>
                <div class="col-md-12 text-center"><h3><strong>Seleção de acessórios</strong></h3></div>
                <c:forEach var="acessorio" items="${acessorios}" >
                <div class="col-md-2">
                    <div class="col-md-12">
                        <div class="form-group">
                            <div class="checkbox checkbox-material">
                                <label>
                                    <input type="checkbox" name="acessorio" id="acessorio1" value="${acessorio.id}" >
                                    <div><strong>${acessorio.descricao }</strong></div>
                                    <div><Strong>Preço: R$</Strong>${acessorio.preco}</div>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                
                
                <div class="text-center">
	                <input type="button" class="btn btn-danger" value="Cancelar"/>
	                <input type="button" class="btn btn-inverse" value="Finalizar pedido"/>
            	</div>

                
			</form>
			
            </div>
            
        </div>
        <jsp:include page="rodape.jsp"></jsp:include>  