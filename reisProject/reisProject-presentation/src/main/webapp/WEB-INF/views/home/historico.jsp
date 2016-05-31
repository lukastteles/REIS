

<div class="mdl-grid">
	
	<div class="mdl-cell mdl-cell--12-col">
		<table class="mdl-data-table mdl-js-data-table">
			<thead>
				<tr>
					<th class="mdl-data-table__cell--non-numeric">Dispositivo</th>
					<th>Valor</th>
					<th>Data</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="mdl-data-table__cell--non-numeric">Don Aubrey</td>
					<td>25</td>
					<td>49021</td>
				</tr>
				<tr>
					<td class="mdl-data-table__cell--non-numeric">Sophia Carson</td>
					<td>32</td>
					<td>10258</td>
				</tr>
				<tr>
					<td class="mdl-data-table__cell--non-numeric">Steve Moreno</td>
					<td>29</td>
					<td>12359</td>
				</tr>
			</tbody>
		</table>
	</div>

</div>

<script src="../js/flat-ui-reis/flat-ui-reis.js"></script>

<script language="javascript">
	carregaVariaveisBalanca('${ultimoHistorico.data}',
			'${ultimoHistorico.balanca.massa}',
			'${ultimoHistorico.balanca.altura}',
			'${ultimoHistorico.balanca.uMassa}');
	carregaVariaveisOximetro('${oximetro.spo2}');
	carregaVariaveisPressao('${ultimoHistorico.data}',
			'${ultimoHistorico.pressao.pressaoDiastolica}',
			'${ultimoHistorico.pressao.pressaoDistolica}',
			'${ultimoHistorico.pressao.pressaoMedia}',
			'${ultimoHistorico.pressao.pressaoSistolica}')

	document.querySelector('#spo2').addEventListener('mdl-componentupgraded',
			function() {
				this.MaterialProgress.setProgress('${oximetro.spo2}');
			});
</script>
