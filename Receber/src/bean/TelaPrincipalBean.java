package bean;



import javax.faces.bean.ManagedBean;

import conexaoHTTP.EnviarMensagemHL7;
import domain.Mensagem;
import service.Sessao;

@ManagedBean
public class TelaPrincipalBean {
	
	private Mensagem mensagem;
	private String login;
	private String senha;
	private String dispositivo;
	
	public Mensagem getMensagem() {
		return Sessao.getMensagem();
	}
	
	/*public void verificarSessao() {
		if(mensagem == null || mensagem == "") {
			//Sessao.setMensagem("cavalo");
			mensagem = "Não tem mensagem";
		} else {
			mensagem = Sessao.getMensagem().getMensagem();
		}
		
	}*/
	
	public void enviarMensagem() {
		EnviarMensagemHL7 hl7 = new EnviarMensagemHL7();
		hl7.enviar(login, senha, dispositivo);
		System.out.println(dispositivo);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}
