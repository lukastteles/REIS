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

<%@ include file="/WEB-INF/views/importsDashboard.jsp"%>
<%@ include file="/WEB-INF/views/includeTags.jsp"%>
</head>
<body>


	<div
		class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
		<header
			class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title"><tiles:insertAttribute name="title" ignore="true" /></span>
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
					<a class="mdl-menu__item" href="/reisProject-presentation/index/index.html">Sair</a>
				</ul>
			</div>
		</header >
		<div
			class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
			<header class="demo-drawer-header azul-claro">
				<img src="../images/perfil.png" class="demo-avatar">
				<div class="demo-avatar-dropdown">
					<span>${usuario}</span>
					<div class="mdl-layout-spacer"></div>
				</div>
			</header>
			<nav class="demo-navigation mdl-navigation azul-escuro">
				<a class="mdl-navigation__link fonte-cinza" href="home.html">
					<i class="material-icons"	role="presentation">home</i><span class="fonte-cinza">Início</span></a> 
				<a class="mdl-navigation__link fonte-cinza" href="perfil.html"> 
					<i class=" material-icons"	role="presentation">person</i>Perfil</a>				
				<a class="mdl-navigation__link fonte-cinza" href="medicao.html">
					<i class=" material-icons"	role="presentation">queue_play_next</i>Medição</a> 
				<a class="mdl-navigation__link fonte-cinza" href="historico.html">
					<i class=" material-icons"	role="presentation">poll</i>Histórico</a>
				<div class="mdl-layout-spacer"></div>
				<a class="mdl-navigation__link fonte-cinza" href=""><i>NUTES - UEPB</i> <span
					class="visuallyhidden">Ajuda</span> </a>
			</nav>
		</div>
		<main class="mdl-layout__content mdl-color--grey-100">
		
		<div class="mdl-grid">
			<section>
				<tiles:insertAttribute name="body" />
			</section>
		</div>

		</main>
	</div>




</body>
</html>