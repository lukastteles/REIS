<%@ include file="/WEB-INF/views/includeTags.jsp"%>

<style type="text/css">
	.corTurquesa {color:#20B2AA;}
	.corCinza {color:#A9A9A9;}
</style>

<div class="row">
	<div class="mdl-cell mdl-cell--12-col" style="position: absolute;">
		<div class="row"  style="margin:10px;">
			<!-- Dados do Paciente -->
  			<div class="col-md-6">
  				<div class="panel panel-default">
	  				<div class="panel-body">
	  					<div class="row">
	  						<div class="col-md-12 corTurquesa"><h1 class="mdl-card__title-text">${usuario}</h1></div>
	  					</div>
	  					
	  					<div class="row"> 
		  					<div class="col-md-4 corCinza"> <h4>Sexo:</h4> </div>
							<div class="col-md-8"> <h4>${paciente.sexo}</h4></div>
						</div>
						
						<div class="row">
		  					<div class="col-md-4 corCinza"> <h4>Endereço:</h4> </div>
							<div class="col-md-8"> <h4>${paciente.endereco}</h4></div>
						</div>
						
						<div class="row">
							<div class="col-md-4 corCinza"> <h4>Cidade:</h4> </div>
							<div class="col-md-8"> <h4>${paciente.cidade}</h4></div>
						</div>
						
						<div class="row">
							<div class="col-md-4 corCinza"> <h4>Telefone:</h4> </div>
							<div class="col-md-8"> <h4>${paciente.telefoneCasa}</h4> </div>
						</div>
					</div>
				</div>
  			</div>
  			
  			<!-- Dados das Medicoes -->
  			<div class="col-md-6">
  				<div class="panel panel-default">
  					<div class="panel-body"><h1 class="mdl-card__title-text corTurquesa">Ultima Medição</h1></div>	
	  				<div class="panel-body">
	  					<!-- 
	  					<div class="row">
	  						<div class="col-md-12 corTurquesa"><h1 class="mdl-card__title-text">Ultima Medição</h1></div>
	  					</div>
	  					 -->
		  				<div class="col-md-4">			
							<h2 class="mdl-card__title-text corCinza">Peso</h2>
							<h4><c:if test="${balanca != null}">${balanca.peso} ${balanca.uPeso}</c:if></h4>
							<hr style="height:2px; border: 2px; color:#000; background-color:#C0C0C0; margin-top: 0px; margin-bottom: 0px;">
						</div>	    
		  				<div class="col-md-4">
							<h2 class="mdl-card__title-text corCinza">Altura</h2>
							<h4><c:if test="${balanca != null}">${balanca.altura} ${balanca.uAltura}</c:if></h4>
							<hr style="height:2px; border: 2px; color:#000; background-color:#C0C0C0; margin-top: 0px; margin-bottom: 0px;">
						</div>
						<div class="col-md-4">			
							<h2 class="mdl-card__title-text corCinza">IMC</h2>
							<h4><c:if test="${balanca != null}">${balanca.massa} ${balanca.uMassa}</c:if></h4>
							<hr style="height:2px; border: 2px; color:#000; background-color:#C0C0C0; margin-top: 0px; margin-bottom: 0px;">
						</div>
					</div>
					<div class="panel-body">
		  				<div class="col-md-6">			
							<h2 class="mdl-card__title-text corCinza">sp02</h2>
							<h4><c:if test="${oximetro != null}">${oximetro.spo2} ${oximetro.uSPO2}</c:if></h4>
							<hr style="height:2px; border: 2px; color:#000; background-color:#C0C0C0; margin-top: 0px; margin-bottom: 0px;">
						</div>
						<div class="col-md-6">
							<h2 class="mdl-card__title-text corCinza">Taxa de Pulso</h2>
							<h4><c:if test="${oximetro != null}">${oximetro.taxaPulso} ${oximetro.uTaxaDePulso}</c:if></h4>
							<hr style="height:2px; border: 2px; color:#000; background-color:#C0C0C0; margin-top: 0px; margin-bottom: 0px;">
						</div>
					</div>
					<div class="panel-body">
						<div class="col-md-12">			
							<h2 class="mdl-card__title-text corCinza">Pressão Arterial</h2>
							<h4><c:if test="${pressao != null}">${pressao.pressaoSistolica} / ${pressao.pressaoDiastolica} mmHg</c:if></h4>
						</div>
					</div>
				</div>
  			</div>
		</div>
	</div>
</div>