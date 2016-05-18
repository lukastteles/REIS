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

<link rel="apple-touch-icon" sizes="57x57" href="../images/favicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="../images/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="../images/favicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="../images/favicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="../images/favicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="../images/favicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="../images/favicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="../images/favicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="../images/favicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="../images/favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="../images/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="../images/favicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="../images/favicon/favicon-16x16.png">
<link rel="manifest" href="../images/favicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="../images/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<%@ include file="/WEB-INF/views/importsDashboard.jsp"%>
<%@ include file="/WEB-INF/views/includeTags.jsp"%>

</head>
<body>


	<div
		class="demo-layout mdl-layout mdl-js-layout  mdl-layout--fixed-header">
		<header class="demo-header mdl-layout__header verde">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title">REIS</span>
				<div class="mdl-layout-spacer"></div>
				<button
					class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon"
					id="hdrbtn">
					<i class="material-icons">more_vert</i>
				</button>
				<ul
					class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right"
					for="hdrbtn">
					<a class="mdl-menu__item" href="../index/index.html#page-top">Início</a>
					<a class="mdl-menu__item" href="../index/index.html#sobre">Sobre</a>
					<a class="mdl-menu__item" href="../index/cadastrar.html">Cadastre-se</a>
					<a class="mdl-menu__item" href="../index/login.html">Entrar</a>

				</ul>
			</div>
		</header>


		<main class="mdl-layout__content">
		<div class="page-content" style="background-color: #fff;">
			<tiles:insertAttribute name="body" />
		</div>
		</main>
	</div>



</body>
</html>