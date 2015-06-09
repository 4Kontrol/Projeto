<jsp:include page="cabecalho.jsp"></jsp:include>
<div class="jumbotron">

	<div class="row">
		<div class="col-md-12 text-center">
			<h3>
				<strong>Finalizar pedido</strong>
			</h3>
		</div>
		<br>
		<br>

		<div class="col-md-3">
			<div class="col-md-12 text-center">
				<h4>
					<strong>Já sou cadastrado</strong>
				</h4>
			</div>
			<form action="">
				<div class="form-group">
					<input type="text" id="cpf" class="form-control" placeholder="CPF" />
				</div>
				<div class="text-center">
					<input type="submit" class="btn btn-success" id="enviar"
						value="Finaizar pedido" />
				</div>
			</form>
		</div>

		<div class="col-md-1"></div>

		<div class="col-md-8">
			<div class="col-md-12 text-center">
				<h4>
					<strong>Não tenho cadastro</strong>
				</h4>
			</div>
			<form action="">
				<div class="form-group">
					<input class="form-control" type="text" name="nome"
						placeholder="Nome" id="Nome" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="cpf"
						placeholder="CPF" id="cpf2" />
				</div>
				<div class="form-group">
					<input class="form-control" type="date" name="dataNascimento"
						placeholder="dd/mm/aaaa" id="dataNascimento" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="endereco"
						placeholder="Rua, Avenida, etc..." id="endereco" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="numero"
						placeholder="Nº" id="numero" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="complemento"
						placeholder="Complemento" id="complemento" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="cep"
						placeholder="Cep" id="cep" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="bairro"
						placeholder="Bairro" id="bairro" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="estado"
						placeholder="Estado" id="estado" />
				</div>
				<div class="form-group text-center">
					<input type="reset" class="btn btn-danger" value="Cancelar" /> <input
						type="submit" class="btn btn-inverse"
						value="Cadastrar e finalizar pedido" />
				</div>
			</form>
		</div>
	</div>


</div>
<jsp:include page="rodape.jsp"></jsp:include>