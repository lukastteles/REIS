var _data;

function carregaVariaveisBalanca(_data, _peso, _altura, _unidadeMedida) {

	/* CHART BALANCA */
	var ctx = document.getElementById("chartBalanca");
	var ctx = document.getElementById("chartBalanca").getContext("2d");
	var ctx = $("#chartBalanca");

	var ctx = document.getElementById("chartBalanca");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ 'Peso', "Altura" ],
			datasets : [ {
				label : 'Última Medição',
				backgroundColor : "rgba(151,187,205,0.5)",
				data : [ _peso, _altura ]
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});

}

function carregaVariaveisOximetro(_spo2) {
	/* CHART OXIMETRO */

	var ctx = document.getElementById("chartOximetro");
	var ctx = document.getElementById("chartOximetro").getContext("2d");
	var ctx = $("#chartOximetro");

	var ctx = document.getElementById("chartOximetro");
	var myChart = new Chart(ctx, {
		type : 'doughnut',
		
		data : {
			labels : [ "SPO2" ],
			datasets : [ {
				data : [ _spo2 ],
				backgroundColor : [ "#FF6384", "#36A2EB", "#FFCE56" ],
				hoverBackgroundColor : [ "#FF6384", "#36A2EB", "#FFCE56" ]
			} ]

		},
		
	});

}
function carregaVariaveisPressao(_data, _diastolica, _distolica, _media,
		_sistolica) {
	/* CHART PRESSAO */

	var ctx = document.getElementById("chartPressao");
	var ctx = document.getElementById("chartPressao").getContext("2d");
	var ctx = $("#chartPressao");

	var ctx = document.getElementById("chartPressao");
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ "Dialóstica", "Distólica", "Média", "Sístólica" ],
			datasets : [ {
				label : 'Última Medição',
				backgroundColor : "rgba(151,187,205,0.5)",
				data : [ _diastolica, _distolica, _media, _sistolica ]
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
}

/* CHART MEDIDOR DE PULSO */

var ctx = document.getElementById("chartMedidorDePulso");
var ctx = document.getElementById("chartMedidorDePulso").getContext("2d");
var ctx = $("#chartMedidorDePulso");

var ctx = document.getElementById("chartMedidorDePulso");
var myChart = new Chart(ctx, {
	type : 'bar',
	data : {
		labels : [ "22/02/2016" ],
		datasets : [ {
			label : 'Última Medição',
			data : [ 12 ]
		} ]
	},
	options : {
		scales : {
			yAxes : [ {
				ticks : {
					beginAtZero : true
				}
			} ]
		}
	}
});
