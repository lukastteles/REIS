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
import com.br.uepb.model.MedicaoOximetroDomain;

/**
 * Servlet implementation class ReceberPortaSerial
 */
public class ReceberPortaSerial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceberPortaSerial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = "";
		String senha = "";
		String hora = "";
		String porcentagem = "";
		String saturacao = "";
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		hora = request.getParameter("hora");
		porcentagem = request.getParameter("porcentagem");
		saturacao = request.getParameter("saturacao");
		PrintWriter out = response.getWriter();
		LoginBusiness loginBusiness = new LoginBusiness();
		if(loginBusiness.loginValido(login, senha)){
			MedicaoOximetroDomain oximetroDomain = new MedicaoOximetroDomain();
			MedicaoOximetroDAO oximetroDAO = new MedicaoOximetroDAO();
			oximetroDomain.setDataHora(new Date());
			oximetroDomain.setPaciente(loginBusiness.getPaciente(login, senha));
			oximetroDomain.setSpo2(Double.parseDouble(porcentagem));
			oximetroDomain.setuSPO2("%");
			oximetroDomain.setTaxaPulso(Double.parseDouble(saturacao));
			oximetroDomain.setuTaxaDePulso("bpm");
			oximetroDAO.salvaMedicaoOximetro(oximetroDomain);
			 out.print("sucesso");//É usuário cadastrado
		 }else{
			 out.print("erro");//Não é usuário cadastrado
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
