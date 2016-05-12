<!DOCTYPE html>
<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="position: relative;">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a href="apresentacao.html"><br> <img
					src="../images/logo_header.png" class="img-responsive" alt=""
					height="50%" width="50%" /> </a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<form:form modelAttribute="model" method="post"
					class="navbar-form navbar-right">
					<p></p>
					<div class="col-md-4">
						<div class='input-group'>
							<span class="input-group-addon"
								style="background-color: #4FC1E9;"><span
								class="glyphicon glyphicon-user"></span></span>
							<form:input path="login" type="text" class="form-control"
								placeholder="Login" />
						</div>
					</div>

					<div class="col-md-4">
						<div class='input-group'>
							<span class="input-group-addon"
								style="background-color: #4FC1E9;"><span
								class="glyphicon glyphicon-lock"></span></span>
							<form:input path="senha" type="password" class="form-control"
								placeholder="Senha" />
						</div>
					</div>
					<div class="col-md-4">
						<button type="submit" class="btn btn-primary btn-block">
							<span class="fa fa-sign-in fa-lg" aria-hidden="true"></span>&nbsp;
							Entrar
						</button>
					</div>

					<p></p>
				</form:form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>