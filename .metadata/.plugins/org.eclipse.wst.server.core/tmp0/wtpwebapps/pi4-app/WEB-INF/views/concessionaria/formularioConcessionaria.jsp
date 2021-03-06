<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../cabecalho.jsp"></jsp:include> 

    <div class="row">
    	<h1>Cadastrar Concession�ria</h1>
        <div class="col-md-3"></div>
        <div class="formulario col-md-6 text-center">
           <c:choose>
           		<c:when  test="${concessionaria eq null }">
		            <form id="formCadastro" action="/pi4-app/concessionaria/efetivarCadatro" method="post">
		                <div class="COL-MD-8">
		                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome da concession�ria"/>
		                </div>
		                <div class="COL-MD-4">
		                    <input type="text" class="form-control" id="rua" name="rua"placeholder="Rua"/>
		                </div>
		                <div class="">
		                    <input class="form-control" type="text" id="numero" name="numero" placeholder="N�"/>
		                </div>
		                <div class="" >
		                    <input class="form-control" type="text" id="complemento" name="complemento" placeholder="Complemento"/>
		                </div>
		                <div class="">
		                	   <input class="form-control" type="text" id="bairro" name="bairro" placeholder="Bairro"/>
		                </div>
		                <div class="">
		                   	 <input class="form-control" type="text" id="cidade" name="cidade" placeholder="Cidade"/>  	
		                </div>
		                <div class="">
		                    <input class="form-control" type="text" id="estado" name="estado" placeholder="Estado"/>
		                </div>
		                <div class="">
		                    <input class="form-control" type="text" id="cnpj" name="cnpj" placeholder="CNPJ"/>
		                </div>
		                <a href="/pi4-app/concessionaria/listarConcessionarias" class="btn btn-danger">Cancelar</a>
		                <input id="submitForm" type="submit" value="Cadastrar" class="btn btn-primary"/>
		            </form>		
		    	</c:when>
		    	<c:otherwise>
		    		<form id="formCadastro" action="/pi4-app/concessionaria/efetivarEdicao" method="post">
		                <div class="COL-MD-8">
		                    <input type="hidden" id="id" value="${concessionaria.id}"/>
		                    <input type="text" value="${concessionaria.nome }" class="form-control" id="nome" name="nome" placeholder="Nome da concession�ria"/>
		                </div>
		                <div class="COL-MD-4">
		                   	<input type="text" value="${concessionaria.endereco.endereco}" class="form-control" id="rua" name="rua"placeholder="Rua"/>
		                </div>
		                <div class="">
		                    <input class="form-control" value="${concessionaria.endereco.numero}" type="text" id="numero" name="numero" placeholder="N�"/>
		                </div>
		                <div class="" >
		                    <input class="form-control" value="${concessionaria.endereco.complemento}" type="text" id="complemento" name="complemento" placeholder="Complemento"/>
		                </div>
		                <div class="">
		                    <input class="form-control" value="${concessionaria.endereco.bairro}" type="text" id="bairro" name="bairro" placeholder="Bairro"/>
		                </div>
		                <div class="">
		                    <input class="form-control" value="${concessionaria.endereco.cidade}" type="text" id="cidade" name="cidade" placeholder="Cidade"/>
		                </div>
		                <div class="">
		                    <input class="form-control" value="${concessionaria.endereco.estado}" type="text" id="estado" name="estado" placeholder="Estado"/>
		                </div>
		                <div class="">
		                    <input class="form-control" value="${concessionaria.cnpj}" type="text" id="cnpj" name="cnpj" placeholder="CNPJ"/>
		                </div>
		                <a href="/pi4-app/concessionaria/listarConcessionarias" class="btn btn-danger">Cancelar</a>
		                <input id="submitForm" type="submit" value="Editar" class="btn btn-primary"/>
		            </form>
		    	</c:otherwise>
	    	</c:choose>        
        </div>
    </div> 	
    
 <jsp:include page="../rodape.jsp"></jsp:include>    
 
 <script type="text/javascript">


 </script>