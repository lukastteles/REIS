function menuInicioSobre(){

    var div = "corpo";
    var corpo = document.getElementById(div).innerHTML = "";
    
    var divInicio = "<header id='page-top'> <div class='container' ><div class='row'><div class='col-lg-12'><img class='img-responsive' src='img/reis3.png' alt=''<div class='intro-text'><h1>REIS</h1><hr class='star-primary'><p>Registro Eletrônico para Interoperabilidade em Saúde</p></div></div></div></div></header>";

    
     var divSobre = "<section class='success' id='sobre'><div class='container'><div class='row'><div class='col-lg-12 text-center'><h2>Sobre</h2><hr class='star-primary'></div></div><div class='row'><div class='col-lg-8 col-lg-offset-2'><h1>O que é o REIS?</h1><br><p>Registro Eletrônico para Interoperabilidade em Saúde - REIS - é um projeto desenvolvido por um grupo de estudantes da Universidade Estadual da Paraíba com o intuito de tornar o acompanhamento de dispositivos de saúde de uso pessoal interoperável.</p></div><div class='col-lg-8 col-lg-offset-2'><h1>Qual a nossa proposta?</h1><br><p> Nossa proposta é armazenar em um perfil o acompanhamento a cada medição de alguns dispositivos de uso pessoal voltado para a saúde.</p></div><div class='col-lg-8 col-lg-offset-2'><h1>Quais são esses dispositívos?   <span class='fa fa-heartbeat'></span></h1><br><div class='col-md-4'><p> <i class='fa fa-user-md' aria-hidden='true''></i> Balança </p></div><div class='col-md-4'><p> <i class='fa fa-user-md' aria-hidden='true''></i> Oximetro de pulso </p></div><div class='col-md-4'><p> <i class='fa fa-user-md' aria-hidden='true'></i> Medidor de pressão </p></div></div></div></div></section>";
      
    
	
	var elemento = document.getElementById(div).innerHTML += divInicio;
    var elemento = document.getElementById(div).innerHTML += divSobre;

}

function menuCadastrar(){
    
    var div = "corpo";
    var corpo = document.getElementById(div).innerHTML = "";
   
     var btnCadastrar =  "<div class='col-lg-8 col-lg-offset-2 text-center'><br><input type='button' value='Cadastrar' class='btn btn-info btn-lg'></div>";
        
    var conteudo =  "<div class='col-lg-8 col-lg-offset-2'><form name='sentMessage' id='contactForm' novalidate><div class='row control-group'><div class='form-group col-xs-12 floating-label-form-group controls'><label>Login</label><input type='text' class='form-control' placeholder='Login' id='name' required data-validation-required-message='Por favor, informe seu login.'><p class='help-block text-danger'></p></div></div><div class='form-group col-xs-12 floating-label-form-group controls'><label>Senha</label><input type='password' class='form-control' placeholder='Senha' id='senha' required data-validation-required-message='Por favor, informe sua senha.'><p class='help-block text-danger'></p></div></div><div class='row'><div class='form-group col-xs-12'>"+btnCadastrar+"</div></div></form></div>";
    
   
    var divCadastrar = "<section id='cadastrar'><div class='container'><div class='row'><div class='col-lg-12 text-center'><h2>Cadastre-se! :)</h2><hr class='star-primary'></div></div><div class='row'>"+conteudo+"</div></div></section>";
    
    var elemento = document.getElementById(div).innerHTML = divCadastrar;
}

function menuEntrar(){
    
    var div = "corpo";
    var corpo = document.getElementById(div).innerHTML = "";
    
    
          var btnEntrar =  "<div class='col-lg-8 col-lg-offset-2 text-center'><br><input type='button' value='Entrar' class='btn btn-success btn-lg '></div>";
        
    var conteudo =  "<div class='col-lg-8 col-lg-offset-2'><form name='sentMessage' id='contactForm' novalidate><div class='row control-group'><div class='form-group col-xs-12 floating-label-form-group controls'><label>Login</label><input type='text' class='form-control' placeholder='Login' id='name' required data-validation-required-message='Por favor, informe seu login.'><p class='help-block text-danger'></p></div></div><div class='form-group col-xs-12 floating-label-form-group controls'><label>Senha</label><input type='password' class='form-control' placeholder='Senha' id='senha' required data-validation-required-message='Por favor, informe sua senha.'><p class='help-block text-danger'></p></div></div><div class='row'><div class='form-group col-xs-12'>"+btnEntrar+"</div></div></form></div>";
    
    
    
    var divEntrar = "<section id='entrar'><div class='container'><div class='row'><div class='col-lg-12 text-center'><h2>Entrar</h2><hr class='star-primary'></div></div><div class='row'>"+conteudo+"</div></div></section>";

    var elemento = document.getElementById(div).innerHTML = divEntrar;
}