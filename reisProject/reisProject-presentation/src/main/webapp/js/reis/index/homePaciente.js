function menuPerfil(){
    
}

function menuHistorico(){
    var div = "corpo";
    var corpo = document.getElementById(div).innerHTML = "";
    
    var canvas =  "<canvas id='canvas' height='450' width='600'></canvas>";
 var historicoCanvas = "<header id='page-top'> <div class='container' ><div class=''><h2>Histórico do Paciente</h2><hr class='star-primary'><div class='col-lg-12'style='width:90%; height: 100%;'>"+canvas+"</div></div></header>";
    
  
    var elemento = document.getElementById(div).innerHTML = historicoCanvas;
     
    var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
		var lineChartData = {
			labels : ["January","February","March","April","May","June","July"],
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
				},
				{
					label: "My Second dataset",
					fillColor : "rgba(151,187,205,0.2)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(151,187,205,1)",
					data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
				}
			]

		}


		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});

    
    
}

function menuAdicionarMedicao(){
    
}

function menuUltimasMedicoes(){
    
}

function menuDispositivosConectados(){
    
}

function menuSair(){
    
}