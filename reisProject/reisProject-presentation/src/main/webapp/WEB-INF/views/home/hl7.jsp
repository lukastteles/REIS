<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<div class="mdl-grid">
	<div class="mdl-cell mdl-cell--12-col">
		<h3 class="negrito">Mensagem HL7</h3>
	</div>

	<div class="alert alert-warning alert-dismissible col-md-12"
		role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Aviso!</strong> <br>Para enviar uma mensagem para outro
		sistema, preencha todos os campos abaixo.
	</div>

	<div class="mdl-cell mdl-cell--6-col">
		<label class="demo-panel-title">Endereço</label>
		<div class="form-group">
			<input class="form-control">
		</div>
	</div>

	<div class="mdl-cell mdl-cell--6-col">
		<label class="demo-panel-title">Port</label>
		<div class="form-group">
			<input class="form-control">
		</div>
	</div>



	<div class="mdl-cell mdl-cell--4-col">
		<label class="demo-panel-title">Balança</label>

		<div class="form-group">
			<select class="form-control">
				<c:forEach items="listaBalanca" var="balanca">
					<option>${balanca }</option>
				</c:forEach>
			</select>
		</div>
	</div>




	<div class="mdl-cell mdl-cell--4-col">
		<label class="demo-panel-title">Oximetro</label>

		<div class="form-group">
			<select class="form-control" id="">
				<c:forEach items="listaOximetro" var="oximetro">
					<option>${oximetro }</option>
				</c:forEach>
			</select>
		</div>
	</div>



	<div class="mdl-cell mdl-cell--4-col">
		<label class="demo-panel-title">Pressão</label>

		<div class="form-group">
			<select class="form-control" id="">
				<c:forEach items="listaPressao" var="pressao">
					<option>${pressao }</option>
				</c:forEach>
			</select>
		</div>
	</div>


	<div class="mdl-cell">
		<button class="btn btn-primary" type="submit">Enviar</button>
		<button class="btn btn-default" type="submit">Limpar</button>
	</div>
</div>


<script src="../js/flat-ui-reis/flat-ui-reis.js"></script>


