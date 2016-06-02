package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.uepb.business.LoginBusiness;
import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.hl7.MensagensHL7;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.PacienteDomain;

import ca.uhn.hl7v2.HL7Exception;

/**
 * Servlet implementation class ReceberMensagemHL7
 */
public class ReceberMensagemHL7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceberMensagemHL7() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = "";
		String senha = "";
		String dispositivo = "";
		
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		dispositivo = request.getParameter("dispositivo");
		
		PrintWriter out = response.getWriter();
		LoginBusiness loginBusiness = new LoginBusiness();
		if (loginBusiness.loginValido(login, senha)) {
			PacienteDomain pacienteDomain = loginBusiness.getPaciente(login, senha);
			
			MensagensHL7 hl7 = new MensagensHL7();
			String mensagem = "";
			if(dispositivo == "balanca") {
				try {
					mensagem = hl7.criarMensagemHL7Balanca(pacienteDomain);
				} catch (HL7Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(dispositivo == "oximetro") {
				try {
					mensagem = hl7.criarMensagemHL7Oximetro(pacienteDomain);
				} catch (HL7Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(dispositivo == "pressao") {
				try {
					mensagem = hl7.criarMensagemHL7Pressao(pacienteDomain);
				} catch (HL7Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			out.print(mensagem);// Mensagem HL7
		} else {
			out.print("Não existe esse usuário cadastrado no REIS!");// Não existe usuario
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
