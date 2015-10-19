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
								<td><a href="/pi4-app/acessorio/abrirFormulario/${acessorio.id}">Editar</a>&nbsp &nbsp &nbsp <a href="/pi4-app/acessorio/remover/${acessorio.id}" class="excluir">Excluir</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script>
			$(document).ready(function(){
				$(".excluir").click(function(e){
					e.preventDefault();
					var href = $(this).attr('href');
					$.ajax({
						type: "post",
						url: href,
						cache: false,
						success: function(response){
							location.reload();
							return true;
						},
						error: function(){
							alert("Algo muito ruim aconteceu!");
						}
					});
				})
			})
		</script>

<jsp:include page="../rodape.jsp"></jsp:include>    
