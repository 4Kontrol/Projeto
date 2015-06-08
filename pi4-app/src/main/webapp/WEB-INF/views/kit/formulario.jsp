<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="../cabecalho.jsp"></jsp:include>

<form action="/pi4-app/kit/efetivarCadastro" method="post">
	<div class="col-md-3"></div>
	<div class="col-md-6">
		<div class="row">
			<c:choose>
				<c:when test="${kit eq null }">
					<div class="col-md-12 text-center">
						<div class="form-group">
							<input type="text" name="descricao" placeholder="Nome do Kit"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-12 text-center">
						<label for="acessorio1" class="control-label">Acess�rio 1</label>
						<div class="form-group">
							<select class="form-control" name="id1" id="ac1">
								
								<c:forEach var="acessorio" items="${acessorios}">
									<option value="${acessorio.id}">
										<c:out value="${acessorio.descricao}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-12 text-center">
						<label for="acessorio2" class="control-label">Acess�rio 2</label>
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
						<label for="acessorio3" class="control-label">Acess�rio 3</label>
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
						<label for="acessorio4" class="control-label">Acess�rio 4</label>
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
						<label for="acessorio5" class="control-label">Acess�rio 5</label>
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
							<input type="text" class="form-control" name="preco"
								placeholder="Pre�o do kit" />
						</div>
					</div>
					<div class="col-md-12 text-center form-group">
						<input type="reset" value="Cancelar" class="btn btn-danger" /> <input
							id="" type="submit" value="Cadastrar" class="btn btn-primary" />
					</div>
				</c:when>
				<c:otherwise>

					<div class="col-md-12 text-center">
						<div class="form-group">
							<input type="hidden" name="id" value="${kit.id} }"/> 
							<input type="text" name="descricao" placeholder="Nome do Kit" class="form-control" value="${kit.descricao}" />
						</div>
					</div>
					<div class="col-md-12 text-center">
						<label for="acessorio1" class="control-label">Acess�rio 1</label>
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
						<label for="acessorio2" class="control-label">Acess�rio 2</label>
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
						<label for="acessorio3" class="control-label">Acess�rio 3</label>
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
						<label for="acessorio4" class="control-label">Acess�rio 4</label>
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
						<label for="acessorio5" class="control-label">Acess�rio 5</label>
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
							<input type="text" class="form-control" name="preco"
								placeholder="Pre�o do kit" />
						</div>
					</div>
					<div class="col-md-12 text-center form-group">
						<input type="reset" value="Cancelar" class="btn btn-danger" /> <input
							id="" type="submit" value="Cadastrar" class="btn btn-primary" />
					</div>
					<input type="hidden" id="id1" value="${kitAcessorioViewModel.id1}" />
					<input type="hidden" id="id2" value="${kitAcessorioViewModel.id2}" />
					<input type="hidden" id="id3" value="${kitAcessorioViewModel.id3}" />
					<input type="hidden" id="id4" value="${kitAcessorioViewModel.id4}" />
					<input type="hidden" id="id5" value="${kitAcessorioViewModel.id5}" />


					<script>
						$(document).ready(function() {
							var ac1 = $("#id1").val();
							$("#ac1").find('option[value=ac1]')
						})
						$("");//setar os select box atrav�s de js, n�o terminada.
					</script>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</form>


<jsp:include page="../rodape.jsp"></jsp:include>
