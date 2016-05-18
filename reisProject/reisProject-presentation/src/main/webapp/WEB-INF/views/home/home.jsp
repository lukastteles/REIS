<%@ include file="/WEB-INF/views/includeTags.jsp"%>
<div class="centro">
	<c:if test="${status == 0}">
		<div class="alert alert-success" role="alert" >
				<span class="close" data-dismiss="alert" aria-label="close">&times;</span>
			<span class="fa fa-exclamation-circle" aria-hidden="true"></span> <span
				class="sr-only">Sucesso:</span> ${mensagem}
		</div>
	</c:if>
	<img class='img-responsive' width="550px" height="550px"
		src='../images/reis.png' style="margin: auto;" />
	<div class='row'>
		<div class='col-lg-12 text-center'>
			<p>Registro Eletrônico para Interoperabilidade em Saúde</p>
		</div>
	</div>
</div>