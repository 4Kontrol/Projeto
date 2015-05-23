<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="cabecalho.jsp"></jsp:include> 

    <div class="row">
        <div class="col-md-3"></div>
        <div class="formulario col-md-6 text-center">
            <form id="formCadastro" action="javascript:submitForm()" method="post">
                <div class="COL-MD-8">
                	<c:if test="${concessionaria eq null }">
                    	<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome da concessionária"/>
                    </c:if>
                    	<input type="hidden" id="id" value="${concessionaria.id}"/>
                    	<input type="text" value="${concessionaria.nome }" class="form-control" id="nome" name="nome" placeholder="Nome da concessionária"/>
                </div>
                <div class="COL-MD-4">
                	<c:if test="${concessionaria eq null }">
                    	<input type="text" class="form-control" id="rua" name="rua"placeholder="Rua"/>
                    </c:if>
                   		<input type="text" value="${concessionaria.endereco.endereco}" class="form-control" id="rua" name="rua"placeholder="Rua"/>
                </div>
                <div class="">
                	<c:if test="${concessionaria eq null }">
                    	<input class="form-control" type="text" id="numero" name="numero" placeholder="Nº"/>
                    </c:if>
                    	<input class="form-control" value="${concessionaria.endereco.numero}" type="text" id="numero" name="numero" placeholder="Nº"/>
                </div>
                <div class="" >
                	<c:if test="${concessionaria eq null }">
                    	<input class="form-control" type="text" id="complemento" name="complemento" placeholder="Complemento"/>
                    </c:if>
                    	<input class="form-control" value="${concessionaria.endereco.complemento}" type="text" id="complemento" name="complemento" placeholder="Complemento"/>
                </div>
                <div class="">
                	<c:if test="${concessionaria eq null }">
                	    <input class="form-control" type="text" id="bairro" name="bairro" placeholder="Bairro"/>
                    </c:if>
                    	<input class="form-control" value="${concessionaria.endereco.bairro}" type="text" id="bairro" name="bairro" placeholder="Bairro"/>
                </div>
                <div class="">
                	<c:if test="${concessionaria eq null }">
                   	 	<input class="form-control" type="text" id="cidade" name="cidade" placeholder="Cidade"/>
                    </c:if>
                    	<input class="form-control" value="${concessionaria.endereco.cidade}" type="text" id="cidade" name="cidade" placeholder="Cidade"/>
                    	
                </div>
                <div class="">
                	<c:if test="${concessionaria eq null }">
                    	<input class="form-control" type="text" id="estado" name="estado" placeholder="Estado"/>
                    </c:if>
                    	<input class="form-control" value="${concessionaria.endereco.estado} type="text" id="estado" name="estado" placeholder="Estado"/>
                </div>
                <div class="">
                	<c:if test="${concessionaria eq null }">
                    	<input class="form-control" type="text" id="cnpj" name="cnpj" placeholder="CNPJ"/>
                    </c:if>
                    	<input class="form-control" value="${concessionaria.cnpj} type="text" id="cnpj" name="cnpj" placeholder="CNPJ"/>
                </div>
                <input type="reset" value="Cancelar" class="btn btn-danger"/>
                <c:if test="${concessionaria eq null }">
                	<input id="submitForm" type="submit" value="Cadastrar" class="btn btn-primary"/>
                </c:if>
                	<input id="submitForm" type="submit" value="Editar" class="btn btn-primary"/>
            </form>
        </div>
    </div>
    
 <jsp:include page="rodape.jsp"></jsp:include>    
 
 <script type="text/javascript">

 	

	function submitForm(){

		var val = $("#submitForm").val();
		if(val === "Cadastrar"){
			$("#formCadastro").attr("action","/pi4-app/listarConcessionarias/");
			$("formCadastro").submit();
		} else {
			$("#formCadastro").attr("action","/pi4-app/confirmarEdicao/"+$("#id").val());
			$("formCadastro").submit();
		}
		
		
	}

 </script>