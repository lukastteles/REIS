<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <title>UEPB app</title>
  <%@ include file="/WEB-INF/views/imports.jsp"%>
  <%@ include file="/WEB-INF/views/includeTags.jsp"%>
</head>
<body>
	<tiles:insertAttribute name="header" />
     		<section>
		<tiles:insertAttribute name="body" />
	</section>
     		<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>