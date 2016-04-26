<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<%@ include file="/WEB-INF/views/importsDefault.jsp"%>
<%@ include file="/WEB-INF/views/includeTags.jsp"%>

</head>
<body>
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title -->
				<span class="mdl-layout-title"> <a class="navbar-brand"
					href="#page-top"> <img class='img-responsive'
						src='../images/reis3.png' width="25px" height="25px" alt=''></a>

				</span>
				<!-- Add spacer, to align navigation to the right -->
				<div class="mdl-layout-spacer"></div>
				<!-- Navigation. We hide it in small screens. -->
				<nav class="mdl-navigation mdl-layout--large-screen-only">
					<a class="mdl-navigation__link" href="index.html#page-top">Início</a>
					<a class="mdl-navigation__link" href="index.html#sobre">Sobre</a> <a
						class="mdl-navigation__link" href="cadastrar.html">Cadastre-se</a>
					<a class="mdl-navigation__link" href="login.html">Entrar</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title"> <a class="navbar-brand"
				href="#page-top"> <img class='img-responsive'
					src='../images/reis3.png' width="25px" height="25px" alt=''></a>

			</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="index.html#page-top">Início</a>
				<a class="mdl-navigation__link" href="index.html#sobre">Sobre</a> <a
					class="mdl-navigation__link" href="cadastrar.html">Cadastre-se</a>
				<a class="mdl-navigation__link" href="login.html">Entrar</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
		<div class="page-content">
			<tiles:insertAttribute name="body" />
		</div>
		</main>
	</div>



</body>
</html>