<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<section>
	<div class='container'>
		<div class='row'>
			<div class='col-md-2'>&nbsp;</div>
			<div class='col-md-6'>
				<form:form id="formLogin" modelAttribute="loginDomain" method="post">
					<div class='col-lg-12 text-center'>
						<h2 class="negrito">
							<img class='img-responsive' width="100px" height="100px"
								src='../images/reis_logo.png' style="margin: auto;" /> Login
						</h2>

					</div>
					<div class="col-md-12">
					<c:if test="${status == 1}">
								<div class="alert alert-danger" role="alert">
				<span class="close" data-dismiss="alert" aria-label="close">&times;</span>
									<span class="fa fa-exclamation-circle" aria-hidden="true"></span>
									<span class="sr-only">Erro:</span> ${mensagem}
								</div>
							</c:if>
						<label class="demo-panel-title">Login</label>
						<div class="form-group">
							<form:input path="login" type="text" value="" placeholder="Login"
								class="form-control"/>
						</div>
					</div>
					<br>
					<div class="col-md-12">
						<label class="demo-panel-title">Senha</label>
						<div class="form-group">
							<form:input path="senha" type="password" value="" placeholder="Senha"
								class="form-control"/>
						</div>
					</div>
					<br>
					<div class="col-md-12">
						<button
							class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect btn-azul">Login</button>
					</div>
				</form:form>
			</div>
			<div class='col-md-3'>&nbsp;</div>
		</div>
	</div>
</section>
