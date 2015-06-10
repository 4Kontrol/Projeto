<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="../cabecalho.jsp"></jsp:include>


<c:choose>
	<c:when test="${kit eq null }">
		<form action="/pi4-app/kit/efetivarCadastro" method="post"
			id="formularioKit">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="form-group">
							<input type="text" name="descricao" placeholder="Nome do Kit"
								class="form-control" id="descricao" />
						</div>
					</div>
					<div class="col-md-12 text-center">
						<label for="acessorio1" class="control-label">Acessório 1</label>
						<div class="form-group">
							<select class="form-control" name="id1" id="ac1">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="acessorio2" class="control-label">Acessório 2</label>
						<div class="form-group">
							<select class="form-control" name="id2" id="ac2">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="acessorio3" class="control-label">Acessório 3</label>
						<div class="form-group">
							<select class="form-control" name="id3" id="ac3">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="acessorio4" class="control-label">Acessório 4</label>
						<div class="form-group">
							<select class="form-control" name="id4" id="ac4">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="acessorio5" class="control-label">Acessório 5</label>
						<div class="form-group">
							<select class="form-control" name="id5" id="ac5">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<div class="form-group">
							<input type="text" class="form-control" name="preco" readonly
								placeholder="Preço do kit" id="preco" value="0"/>
						</div>
					</div>
					<div id="base">
						<c:forEach var="acessorio" items="${acessorios}">
							<input type="hidden" value="${acessorio.preco}"
								id="${acessorio.id}" />
						</c:forEach>
					</div>
					<div class="col-md-12 text-center form-group">
						<input type="reset" value="Cancelar" class="btn btn-danger" /> <input
							type="button" value="Cadastrar" class="btn btn-primary"
							id="submeter" />
					</div>
				</div>
			</div>

		</form>
	</c:when>



	<c:otherwise>
		<form action="/pi4-app/kit/efetivarEdicao" method="post"
			id="formularioKit">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row">

					<div class="col-md-12 text-center">
						<div class="form-group">
							<input type="hidden" name="id" value="${kit.id} }" /> <input
								type="text" name="descricao" placeholder="Nome do Kit"
								class="form-control" value="${kit.descricao}" id="descricao" />
						</div>
					</div>
					<div class="col-md-12 text-center">
						<label for="ac1" class="control-label">Acessório 1</label>
						<div class="form-group">
							<select class="form-control" name="id1" id="ac1">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="ac2" class="control-label">Acessório 2</label>
						<div class="form-group">
							<select class="form-control" name="id2" id="ac2">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="ac3" class="control-label">Acessório 3</label>
						<div class="form-group">
							<select class="form-control" name="id3" id="ac3">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="ac4" class="control-label">Acessório 4</label>
						<div class="form-group">
							<select class="form-control" name="id4" id="ac4">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="ac5" class="control-label">Acessório 5</label>
						<div class="form-group">
							<select class="form-control" name="id5" id="ac5">
								<option value="0">--Selecione--</option>
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<div class="form-group">
							<input type="text" class="form-control" id="preco" name="preco"
								placeholder="Preço do kit" value="${kit.preco}" readonly />
						</div>
					</div>
					<input type="hidden" id="id1" value="${kitAcessorioViewModel.id1}" />
					<input type="hidden" id="id2" value="${kitAcessorioViewModel.id2}" />
					<input type="hidden" id="id3" value="${kitAcessorioViewModel.id3}" />
					<input type="hidden" id="id4" value="${kitAcessorioViewModel.id4}" />
					<input type="hidden" id="id5" value="${kitAcessorioViewModel.id5}" />

					<div id="base">
						<c:forEach var="acessorio" items="${acessorios}">
							<input type="hidden" value="${acessorio.preco}"
								id="${acessorio.id}" />
						</c:forEach>
					</div>


					<div class="col-md-12 text-center form-group">
						<input type="reset" value="Cancelar" class="btn btn-danger" /> <input
							type="button" value="Editar" class="btn btn-primary"
							id="submeter" />
					</div>
				</div>
			</div>

		</form>




		<script>
			$(document).ready(
					function() {
						$("select#ac1 > option[value=" + $("#id1").val() + "]")
								.prop("selected", true);
						$("select#ac2 > option[value=" + $("#id2").val() + "]")
								.prop("selected", true);
						$("select#ac3 > option[value=" + $("#id3").val() + "]")
								.prop("selected", true);
						$("select#ac4 > option[value=" + $("#id4").val() + "]")
								.prop("selected", true);
						$("select#ac5 > option[value=" + $("#id5").val() + "]")
								.prop("selected", true);
					});
			//setar os select box através de js.
		</script>
	</c:otherwise>
</c:choose>
<script>
	$(document)
			.ready(
					function() {
						$("select").change(function(){
							var total = 0;
							$("select").each(function(){
								var id = this.id;								
								var valor = Number($("#"+$("#"+id).val()).val());
								if (!isNaN(valor)) total += valor;
							});
							$("#preco").val(0);
				            $("#preco").val(total.toFixed(2));
				        });

						$("#submeter")
								.click(
										function() {
											if ($("#ac1").val() == 0
													&& $("#ac2").val() == 0
													&& $("#ac3").val() == 0
													&& $("#ac4").val() == 0
													&& $("#ac5").val() == 0) {
												alert("Selecione no mínimo um acessório");
												return false;
											}

											if ($("#descricao").val() == ""
													|| $("#preco").val() == "") {
												alert("Todos os campos são obrigatórios");
												return false;
											}
											for (var i = 1; i <= 5; i++) {
												if ($("#ac" + i).val() != "0") {
													for (var j = i + 1; j <= 5; j++) {
														if ($("#ac" + i).val() == $(
																"#ac" + j)
																.val()) {
															alert("Não selecione acessórios repetidos.");
															return;
														}
													}
												}
											}
											$("#formularioKit").submit();
										});

					});
</script>



<jsp:include page="../rodape.jsp"></jsp:include>
