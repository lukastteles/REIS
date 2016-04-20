<!DOCTYPE html>

<%@ include file="/WEB-INF/views/imports.jsp"%>
<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<html>
<body class="index">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#page-top"> <img
					class='img-responsive' src='../images/reis3.png' width="25px"
					height="25px" alt=''></a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="index.html#page-top">Início</a></li>
					<li class="page-scroll"><a href="index.html#sobre">Sobre</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="page-scroll"><a href="cadastrar.html">Cadastre-se</a></li>
					<li class="page-scroll"><a href="login.html">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="corpo">
		<section id='cadastrar'>
			<div class='container'>
				<div class='row'>
					<div class='col-lg-12 text-center'>
						<h2>Cadastre-se! :)</h2>
						<hr class='star-primary'>
					</div>
				</div>
				<div class='row'>
					<div class='col-lg-8 col-lg-offset-2'>
						<form id='contactForm' novalidate>
							<div class='row control-group'>
								<div
									class='form-group col-xs-12 floating-label-form-group controls'>
									<label>Login</label><input type='text' class='form-control'
										placeholder='Login' id='name' required
										data-validation-required-message='Por favor, informe seu login.'>
									<p class='help-block text-danger'></p>
								</div>
							</div>
							<div
								class='form-group col-xs-12 floating-label-form-group controls'>
								<label>Senha</label><input type='password' class='form-control'
									placeholder='Senha' id='senha' required
									data-validation-required-message='Por favor, informe sua senha.'>
								<p class='help-block text-danger'></p>
							</div>
							<div class='row'>
								<div class='form-group col-xs-12'>
									<div class='col-lg-8 col-lg-offset-2 text-center'>
										<br> <input type='button' value='Cadastrar'
											class='btn btn-info btn-lg'>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- Footer -->
	<footer class="text-center">
		<div class="footer-above">
			<div class="container">
				<div class="row">
					<div class="footer-col col-md-6">
						<h3>Endereço</h3>
						<p>
							Campina Grande<br>Paraíba, Brasil
						</p>
					</div>

					<div class="footer-col col-md-6">
						<h3>Sobre REIS</h3>
						<p>Desenvolvido por um grupo de estudantes da Universidade
							Estadual da Paraíba.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-below">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">Copyright &copy; REIS - 2016</div>
				</div>
			</div>
		</div>
	</footer>


	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-top page-scroll visible-xs visble-sm">
		<a class="btn btn-primary" href="#page-top"> <i
			class="fa fa-chevron-up"></i>
		</a>
	</div>

</body>
</html>