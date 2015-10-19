<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="cabecalho.jsp"></jsp:include>

<div class="jumbotron">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div id="cadastro col-md-12">
                        <form:form action="/pi4-app/quiosque/finalizarPrepedido" methodParam="POST" modelAttribute="cliente">
                            <div class="form-group">
                                <input name="nome" id="nome" class="form-control" type="text" placeholder="nome"/>
                            </div>
                            <div class="form-group">
                                <input name="cpf" id="cpf" class="form-control" type="text" placeholder="cpf"/>
                            </div>
                            
                            <div class="form-group">
                                <select name="sexo" id="sexo" class="form-control">
                                    <option value="Feminino">Feminino</option>
                                    <option value="Masculino">Masculino</option>
                                </select>
                            </div>
                                                      
                          

                            <div class="form-group text-center col-md-12">
                                <input type="reset" class="btn btn-danger" value="Voltar" />
                                <input type="submit" class="btn btn-inverse" value="Cadastrar e finalizar pedido" />
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

<jsp:include page="rodape.jsp"></jsp:include>