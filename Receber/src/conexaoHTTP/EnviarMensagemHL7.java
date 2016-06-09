package conexaoHTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import domain.Mensagem;
import service.Sessao;

public class EnviarMensagemHL7 {

	public boolean enviar(String login, String senha, String dispositivo) {

		try {
			String link = "http://192.168.1.72:8080/reisProject-presentation/ReceberMensagemHL7" + "?" + "login=" + login
					+ "&senha=" + senha + "&dispositivo=" + dispositivo;
			System.out.println(link);
			URL url = new URL(link);

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = httpURLConnection.getInputStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));

			String line = in.readLine() + "\n";
			int i = 1;
			while (i < 6) {

				line = line + in.readLine() + "\n";
				//System.out.println(line);
				i++;

			}

			System.out.println(line);

			in.close();
			httpURLConnection.disconnect();

			Sessao.setMensagem(new Mensagem(line));

			return true;

		} catch (IOException e) {
			System.out.println("passou aqui e deu erro");
			e.printStackTrace();
			/*
			 * Alert alert = new Alert(AlertType.WARNING); alert.setContentText(
			 * "Falha ao enviar as informa��es. N�o foi poss�vel se conectar ao REIS!"
			 * ); alert.setTitle("REIS"); alert.setHeaderText(null);
			 * alert.showAndWait();
			 */
			return false;
		}

	}

	public static void main(String[] args) {
		EnviarMensagemHL7 enviarMensagemHL7 = new EnviarMensagemHL7();
		// enviarMensagemHL7.enviar("SenhorBrunojgfddfdgfggj");
	}
}
