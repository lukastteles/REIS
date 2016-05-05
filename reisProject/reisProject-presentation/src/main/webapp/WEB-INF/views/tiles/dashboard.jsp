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
		class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
		<header
			class="demo-header mdl-layout__header verde">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title"><tiles:insertAttribute
						name="title" ignore="true" /></span>
				<div class="mdl-layout-spacer"></div>
				<button
					class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon"
					id="hdrbtn">
					<i class="material-icons">more_vert</i>
				</button>
				<ul
					class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right"
					for="hdrbtn">
					<a class="mdl-menu__item" href="perfil.html">Perfil</a>
					<a class="mdl-menu__item"
						href="/reisProject-presentation/index/index.html">Sair</a>
				</ul>
			</div>
		</header>
		<div
			class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
			<header class="demo-drawer-header verde">
				<img src="../images/perfil.png" class="demo-avatar">
				<div class="demo-avatar-dropdown">
					<span>${usuario}</span>
					<div class="mdl-layout-spacer"></div>
				</div>
			</header>
			<nav class="demo-navigation mdl-navigation azul-escuro">
				<a class="mdl-navigation__link " href="home.html"> <i
					class="fa fa-home"></i><span class="">Início</span></a> <a
					class="mdl-navigation__link " href="perfil.html"> <i
					class=" fa fa-user"></i>Perfil
				</a> <a class="mdl-navigation__link " href="medicao.html"> <i
					class=" fa fa-user-md"></i>Medição
				</a> <a class="mdl-navigation__link " href="historico.html"> <i
					class=" fa fa-bar-chart"></i>Histórico
				</a>
				<a class="mdl-navigation__link " href="historico.html"> <i
					class=" fa fa-file-text-o"></i>HL7
				</a>
				<div class="mdl-layout-spacer"></div>
				<a class="mdl-navigation__link " href=""><i>NUTES - UEPB</i> <span
					class="visuallyhidden">Ajuda</span> </a>
			</nav>
		</div>
		<main class="mdl-layout__content mdl-color--grey-100">

		<div class="mdl-grid ">
			<section>
				<tiles:insertAttribute name="body" />
			</section>
		</div>

		</main>
	</div>




</body>
</html>