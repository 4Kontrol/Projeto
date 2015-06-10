<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="cabecalho.jsp"></jsp:include> 
<div class="jumbotron">
            <div class="exibeCarros" id="exibeCarros">

                <div class="text-center">
                    <h3><strong>Pedidos cadastrados</strong></h3>
                </div>
                <table class="table table-bordered table-responsive text-center">
                    <tr>
                        <th>ID</th>
                        <th>Data do Pedido</th>
                        <th>Cliente</th>
                        <th>Veiculo</th>
                        <th>Valor</th>
                        <th>Ações</th>
                    </tr>
                    <c:forEach var"pedido" items="${pedidos}">
                    <tr>
                        <td>${pedido.id}</td>
                        <td>${pedido.dataEmissaoPedido}</td>
                        <td>${pedido.cliente.nome}</td>
                        <td>${pedido.veiculo.modelo}</td>
                        <td>R$ ${pedido.preco}</td>
                        <td><a
                                href="#">Cancelar</a>&nbsp &nbsp &nbsp<a
                                href="#">Exibir</a></td>
                    </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
 <jsp:include page="rodape.jsp"></jsp:include>  