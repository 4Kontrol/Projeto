<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<jsp:include page="../cabecalho.jsp"/>

<div class="jumbotron">
			<div class="row">
				<div class="text-center">
					<h3>Acessórios</h3>
				</div>
				<div class="conteudo">
					<div class="col-md-3"></div>
					<div class="tabela col-md-6">
						<table class="table table-bordered table-responsive text-center">
							<tr>
								<th>Número</th>
								<th>Nome </th>
								<th>Ações</th>
							</tr>
							<c:forEach var="acessorio" items="${acessorios}">
								<tr>
								<td>${acessorio.id}</td>
								<td>${acessorio.descricao}</td>
								<td><a href="/pi4-app/acessorio/abrirFormulario/${acessorio.id}">Editar</a>&nbsp &nbsp &nbsp <a href="">Excluir</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>

<jsp:include page="../rodape.jsp"></jsp:include>    
 
 <script type="text/javascript">


 </script>