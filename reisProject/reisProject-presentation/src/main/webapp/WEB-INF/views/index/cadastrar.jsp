<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<section>
	<div class='container'>
		<div class='row'>
			<div class="mdl-grid">
				<div class='col-md-2'>&nbsp;</div>
				<div class='col-md-6'>
					<form:form id="formCadastro" modelAttribute="loginDomain" method="post">
						<div class='col-lg-12 text-center'>
							<h2 class="negrito">
								<img class='img-responsive' width="100px" height="100px"
									src='../images/reis_logo.png' style="margin: auto;" />
								Cadastre-se! :)
							</h2>

						</div>
						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Login</label>
							<div class="form-group">
								<form:input path="login" type="text" class="form-control"
									placeholder="Login" />

							</div>
						</div>
						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Senha</label>
							<div class="form-group">
								<form:input path="senha" type="text" class="form-control"
									placeholder="Senha" />
							</div>
						</div>

						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Nome</label>
							<div class="form-group">
								<form:input path="paciente.nome" type="text"
									class="form-control" placeholder="Nome" />
							</div>
						</div>
						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Sexo</label>
							<form:input path="paciente.sexo" type="text"
									class="form-control" placeholder="sexo" id="sexoValor" cssStyle="display: none;"/>
							<div class="form-group">
								<select data-toggle="select" id="sexo" 
									class="form-control select select-primary select-lg">
									<option value="Masculino">Masculino</option>
									<option value="Feminino">Feminino</option>
								</select>
							</div>
						</div>
						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Endereço</label>
							<div class="form-group">
								<form:input path="paciente.endereco" type="text"
									class="form-control" placeholder="Endereço" />
							</div>
						</div>
						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Cidade</label>
							<div class="form-group">
								<form:input path="paciente.cidade" type="text"
									class="form-control" placeholder="Cidade" />
							</div>
						</div>
						<div class="mdl-cell mdl-cell--12-col">
							<label class="demo-panel-title">Telefone</label>
							<div class="form-group">
								<form:input path="paciente.telefoneCasa" type="text"
									class="form-control" placeholder="Telefone" />
							</div>
						</div>
						<div class="mdl-cell mdl-cell--12-col">

							<div class="mdl-cell mdl-cell--6-col">
								<button
									class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-azul" onclick="selecionarSexo()">
									Salvar</button>
								&nbsp;

							</div>

						</div>
					</form:form>
				</div>
			</div>
			<div class='col-md-3'>&nbsp;</div>
		</div>
	</div>
</section>
<script>
	$(document).ready(	function() {
			$('select[name="inverse-dropdown"], select[name="inverse-dropdown-optgroup"], select[name="inverse-dropdown-disabled"]')
			.select2({dropdownCssClass : 'select-inverse-dropdown'});
			$('select[name="searchfield"]').select2({dropdownCssClass : 'show-select-search'});
			$('select[name="inverse-dropdown-searchfield"]').select2({dropdownCssClass : 'select-inverse-dropdown show-select-search'});
	});
	function selecionarSexo(){
			 var sexoSelecionado = document.getElementById("sexo").value;
			 document.getElementById("sexoValor").value = sexoSelecionado;

	}

</script>