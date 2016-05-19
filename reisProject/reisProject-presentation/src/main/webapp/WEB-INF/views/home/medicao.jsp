<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<div class="mdl-grid">

	<div class="mdl-cell mdl-cell--12-col">
		<form:form modelAttribute="uploadItem" method="post" id="formMedicao"
			enctype="multipart/form-data">
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


			<div class="mdl-cell mdl-cell--4-col">
				<label class="demo-panel-title">Tipo de Medição</label>
				<form:input path="tipo_dispositivo" type="text" class="form-control"
					id="tipoDispositivo" cssStyle="display: none;" />
				<div class="form-group">
					<select data-toggle="select" id="tipo"
						class="form-control select select-primary select-lg">						
						<option value="0">Oximetro</option>
						<option value="1">Balança</option>
						<option value="2">Pressão</option>
					</select>
				</div>

			</div>
			<div class="mdl-cell mdl-cell--6-col">
				<form:label for="fileData" path="fileData">Arquivo XML</form:label>

				<form:input path="fileData" type="file" cssClass="form-control" />
			</div>
			<div class="mdl-cell mdl-cell--2-col">
				<input type="button"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-verde" onclick="enviar()" value="Enviar" />

			</div>

		</form:form>
	</div>
</div>
<script>
	function enviar() {
		var sexoSelecionado = document.getElementById("tipo").value;
		document.getElementById("tipoDispositivo").value = sexoSelecionado;
		document.getElementById("formMedicao").submit();
	}
</script>
