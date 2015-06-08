<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="../cabecalho.jsp"></jsp:include>

<form action="/pi4-app/kit/efetivarCadastro" method="post">
	<div class="col-md-3"></div>
    <div class="col-md-6">
        <div class="row"> 
        	<div class="col-md-12 text-center">
        		<div class="form-group">
        			<input type="text" name="descricao" placeholder="Nome do Kit" class="form-control"/>
        		</div>
        	</div>           
            <div class="col-md-12 text-center">
                <label for="acessorio1" class="control-label">Acessório 1</label>
                <div class="form-group">
                    <select class="form-control" name="id1">
                    <option>
                    --Selecione--
                    </option>
                    <c:forEach var="acessorio" items="${acessorios}">
                        <option value="${acessorio.id}">
                            <c:out value="${acessorio.descricao}"/>
                        </option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            
            <div class="col-md-12 text-center">
                <label for="acessorio2" class="control-label">Acessório 2</label>
                <div class="form-group">
                    <select class="form-control" name="id2">
                    <option>
                    --Selecione--
                    </option>
                    <c:forEach var="acessorio" items="${acessorios}">
                        <option value="${acessorio.id}">
                            <c:out value="${acessorio.descricao}"/>
                        </option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            
            <div class="col-md-12 text-center">
                <label for="acessorio3" class="control-label">Acessório 3</label>
                <div class="form-group">
                    <select class="form-control" name="id3">
                    <option>
                    --Selecione--
                    </option>
                    <c:forEach var="acessorio" items="${acessorios}">
                        <option value="${acessorio.id}">
                            <c:out value="${acessorio.descricao}"/>
                        </option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            
            <div class="col-md-12 text-center">
                <label for="acessorio4" class="control-label">Acessório 4</label>
                <div class="form-group">
                    <select class="form-control" name="id4">
                    <option>
                    --Selecione--
                    </option>
                    <c:forEach var="acessorio" items="${acessorios}">
                        <option value="${acessorio.id}">
                            <c:out value="${acessorio.descricao}"/>
                        </option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            
            <div class="col-md-12 text-center">
                <label for="acessorio5" class="control-label">Acessório 5</label>
                <div class="form-group">
                    <select class="form-control" name="id5">
                    <option>
                    --Selecione--
                    </option>
                    <c:forEach var="acessorio" items="${acessorios}">
                        <option value="${acessorio.id}">
                            <c:out value="${acessorio.descricao}"/>
                        </option>
                    </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-12 text-center">
            	<div class="form-group">
            		<input type="text" class="form-control" name="preco" placeholder="Preço do kit"/>
            	</div>
            </div>
            <div class="col-md-12 text-center form-group"   >
    			<input type="reset" value="Cancelar" class="btn btn-danger"/>
		        <input id="" type="submit" value="Cadastrar" class="btn btn-primary"/>
			</div>
        </div>
    </div>
    
</form>


<jsp:include page="../rodape.jsp"></jsp:include>  
