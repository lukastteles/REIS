package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import com.br.uepb.dao.LoginDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.PacienteDomain;

public class PersistenciaPacienteTests {

	private int ultimoPaciente;
		
	@Test
	public void criarPacienteTest() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		PacienteDomain novoPaciente = new PacienteDomain();
				
		novoPaciente.setNome("João Lopes");
		novoPaciente.setEndereco("Rua Coronel Falamansa");
		novoPaciente.setCidade("Arco Verde");
		novoPaciente.setSexo("M");
		novoPaciente.setTelefoneCasa("8335640298");
		
		pacienteDAO.salvaPaciente(novoPaciente);
		
		assertTrue(novoPaciente.getId() > 0);
		ultimoPaciente = novoPaciente.getId();
	}
	
	@Test
	public void associarPacienteLogin(){
		PacienteDAO pacienteDAO = new PacienteDAO();
		LoginDAO loginDAO = new LoginDAO();
		PacienteDomain novoPaciente = new PacienteDomain();		
		novoPaciente.setNome("João Lopes");
		novoPaciente.setEndereco("Rua Coronel Falamansa");
		novoPaciente.setCidade("Arco Verde");
		novoPaciente.setSexo("M");
		novoPaciente.setTelefoneCasa("8335640298");
		
		pacienteDAO.salvaPaciente(novoPaciente);
		ultimoPaciente = novoPaciente.getId();
		
		LoginDomain login = new LoginDomain();
		login.setLogin("jlopes");
		login.setSenha("senha123");
		login.setPaciente(novoPaciente);
//		novoPaciente.setLogin(login);
		pacienteDAO.salvaPaciente(novoPaciente);
		assertEquals(novoPaciente.getId(), login.getPaciente().getId());
	}
	
	@After
	public void limparDados(){
		PacienteDAO pacienteDAO = new PacienteDAO();
		PacienteDomain paciente = pacienteDAO.obtemPaciente(ultimoPaciente);
		if(paciente != null)
		pacienteDAO.excluiPaciente(paciente);
	}

}
