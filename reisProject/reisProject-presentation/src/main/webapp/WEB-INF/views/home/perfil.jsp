<div class="mdl-grid">
	<div class="mdl-cell mdl-cell--12-col">
		<h3 class="negrito">Perfil</h3>
	</div>
	<div class="mdl-cell mdl-cell--8-col">
		<label class="demo-panel-title">Nome</label>
		<div class="form-group">
			<input type="text" value="" placeholder="nome" class="form-control">
		</div>
	</div>
	<div class="mdl-cell mdl-cell--4-col">
		<label class="demo-panel-title">Sexo</label>
		<div class="form-group">
        <select data-toggle="select" class="form-control select select-primary select-lg">
          <option value="0">Masculino</option>
          <option value="1">Feminino</option>
        </select>
      </div>
	</div>
	<div class="mdl-cell mdl-cell--8-col">
		<label class="demo-panel-title">Endereço</label>
		<div class="form-group">
			<input type="text" value="" placeholder="endereço"
				class="form-control">
		</div>
	</div>
	<div class="mdl-cell mdl-cell--4-col">
		<label class="demo-panel-title">Cidade</label>
		<div class="form-group">
			<input type="text" value="" placeholder="cidade" class="form-control">
		</div>
	</div>
	<div class="mdl-cell mdl-cell--8-col">
		<label class="demo-panel-title">Telefone</label>
		<div class="form-group">
			<input type="text" value="" placeholder="telefone"
				class="form-control">
		</div>
	</div>
	<div class="mdl-cell mdl-cell--12-col">

		<div class="mdl-cell mdl-cell--6-col">
			<button
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-azul">
				<span class="fa fa-pencil tamanho-14" aria-hidden="true"></span>Atualizar
				Dados
			</button>
			&nbsp;
			<button
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-vermelho">
				<span class="fa fa-trash tamanho-14" aria-hidden="true"></span>Deletar
			</button>
		</div>

	</div>

</div>
<script>
      $(document).ready(function(){
        $('select[name="inverse-dropdown"], select[name="inverse-dropdown-optgroup"], select[name="inverse-dropdown-disabled"]').select2({dropdownCssClass: 'select-inverse-dropdown'});

        $('select[name="searchfield"]').select2({dropdownCssClass: 'show-select-search'});
        $('select[name="inverse-dropdown-searchfield"]').select2({dropdownCssClass: 'select-inverse-dropdown show-select-search'});
      });
    </script>