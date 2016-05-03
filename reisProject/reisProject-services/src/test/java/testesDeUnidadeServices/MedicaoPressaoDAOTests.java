package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.br.uepb.dao.MedicaoPressaoDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.MedicaoPressaoDomain;
import com.br.uepb.model.PacienteDomain;

public class MedicaoPressaoDAOTests {

	@Before
	public void criarPaciente(){
		PacienteDAO pacienteDAO = new PacienteDAO();
		LoginDAO perfilDAO = new LoginDAO();
		PacienteDomain paciente = new PacienteDomain();
		/*
		PacienteDomain perfil = perfilDAO.obtemPerfil(1);
		paciente.setNome("Chico Silva");
		paciente.setSexo("M");
		
		
		pacienteDAO.salvaPaciente(paciente);
		*/
	}
	
	@Test
	public void criarMedicaoPressao() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		MedicaoPressaoDAO medicaoDAO = new MedicaoPressaoDAO();
		MedicaoPressaoDomain medicao = new MedicaoPressaoDomain();
		PacienteDomain paciente = pacienteDAO.obtemPaciente(1);
		medicao.setId_Paciente(paciente);
		medicao.setPressaoDistolica(80);
		medicao.setPressaoSistolica(120);
		medicao.setPressaoMedia(112);
		medicao.setTaxaDePulso(90);
		
		medicaoDAO.salvaMedicaoPressao(medicao);
		assertTrue(medicao.getId() > 0);
	}
	
	@After
	public void limparDados(){
		PacienteDAO pacienteDAO = new PacienteDAO();
		MedicaoPressaoDAO medicaoDAO = new MedicaoPressaoDAO();
		MedicaoPressaoDomain medicao = new MedicaoPressaoDomain();
		PacienteDomain paciente = pacienteDAO.obtemPaciente(1);
	}

}
