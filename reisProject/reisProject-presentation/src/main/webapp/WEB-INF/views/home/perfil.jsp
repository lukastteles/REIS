<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<form:form id="formAtualizar" modelAttribute="loginDomain" method="post">
	<div class="mdl-grid">

		<div class="mdl-cell mdl-cell--12-col">

			<c:if test="${status == 0}">
				<div class="alert alert-success" role="alert">
					<span class="close" data-dismiss="alert" aria-label="close">&times;</span>
					<span class="fa fa-exclamation-circle" aria-hidden="true"></span> <span
						class="sr-only">Sucesso:</span> ${mensagem}
				</div>
			</c:if>
			<c:if test="${status == 1}">
				<div class="alert alert-danger" role="alert">
					<span class="close" data-dismiss="alert" aria-label="close">&times;</span>
					<span class="fa fa-exclamation-circle" aria-hidden="true"></span> <span
						class="sr-only">Erro:</span> ${mensagem}
				</div>
			</c:if>
			<c:if test="${statusExcluir == 1}">
				<div class="alert alert-danger" role="alert">
					<span class="fa fa-exclamation-circle" aria-hidden="true"></span> <span
						class="sr-only">Erro:</span> ${mensagem}
				</div>
			</c:if>
		</div>
		<div class="mdl-cell mdl-cell--8-col">
			<label class="demo-panel-title">Nome</label>
			<div class="form-group">
				<form:input path="paciente.nome" type="text" value=""
					placeholder="nome" class="form-control" />
			</div>
		</div>

		<div class="mdl-cell mdl-cell--4-col">
			<label class="demo-panel-title">Sexo</label>
			<form:input path="paciente.sexo" type="text" class="form-control"
				placeholder="sexo" id="sexoValor" cssStyle="display: none;" />
			<div class="form-group">
				<select data-toggle="select" id="sexo"
					class="form-control select select-primary select-lg">
					<option value="Masculino">Masculino</option>
					<option value="Feminino">Feminino</option>
				</select>
			</div>
		</div>

		<div class="mdl-cell mdl-cell--8-col">
			<label class="demo-panel-title">Login</label>
			<div class="form-group">
				<form:input path="login" type="text" class="form-control"
					placeholder="Login" disabled="true" />

			</div>
		</div>

		<div class="mdl-cell mdl-cell--4-col">
			<label class="demo-panel-title">Senha</label>
			<div class="form-group">
				<form:input path="senha" type="password" class="form-control"
					placeholder="Senha" />
			</div>
		</div>


		<div class="mdl-cell mdl-cell--8-col">
			<label class="demo-panel-title">Endereço</label>
			<div class="form-group">
				<form:input path="paciente.endereco" type="text"
					placeholder="endereço" class="form-control" />
			</div>
		</div>
		<div class="mdl-cell mdl-cell--4-col">
			<label class="demo-panel-title">Cidade</label>
			<div class="form-group">
				<form:input path="paciente.cidade" type="text" placeholder="cidade"
					class="form-control" />
			</div>
		</div>
		<div class="mdl-cell mdl-cell--8-col">
			<label class="demo-panel-title">Telefone</label>
			<div class="form-group">
				<form:input path="paciente.telefoneCasa" type="text"
					placeholder="telefone" class="form-control" />
			</div>
		</div>

		<div class="mdl-cell mdl-cell--6-col">
			<button
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-azul"
				onclick="selecionarSexo()">
				<span class="fa fa-pencil tamanho-14" aria-hidden="true"></span>Atualizar
				Dados
			</button>
			&nbsp;
			<button formaction="./excluir.html"
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-vermelho">
				<span class="fa fa-trash tamanho-14" aria-hidden="true"></span>Deletar
			</button>
		</div>
	</div>
</form:form>
<script>
document.getElementById("sexo").value = '${loginDomain.paciente.sexo}';
	$(document)
			.ready(
					
					function() {
						
						$(
								'select[name="inverse-dropdown"], select[name="inverse-dropdown-optgroup"], select[name="inverse-dropdown-disabled"]')
								.select2(
										{
											dropdownCssClass : 'select-inverse-dropdown'
										});

						$('select[name="searchfield"]').select2({
							dropdownCssClass : 'show-select-search'
						});
						$('select[name="inverse-dropdown-searchfield"]')
								.select2(
										{
											dropdownCssClass : 'select-inverse-dropdown show-select-search'
										});
					});
	
	function selecionarSexo(){
		 var sexoSelecionado = document.getElementById("sexo").value;
		 document.getElementById("sexoValor").value = sexoSelecionado;


	}
	
	

</script>