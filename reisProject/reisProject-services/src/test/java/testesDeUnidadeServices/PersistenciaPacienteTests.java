package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.PacienteDomain;

public class PersistenciaPacienteTests {

	@Before
	public void criarPerfil(){
		LoginDAO perfilDAO = new LoginDAO();
		PacienteDomain paciente = new PacienteDomain();
		
		perfilDAO.salvaLogin(paciente);
	}
	
	@Test
	public void criarPacienteTest() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		LoginDAO perfilDAO = new LoginDAO();
		PacienteDomain novoPaciente = new PacienteDomain();
		/*
		PerfilDomain perfil = perfilDAO.obtemPerfil(1);
		
		novoPaciente.setLogin("joao");
		novoPaciente.setSenha("senha123");
		novoPaciente.setNome("João Lopes");
		novoPaciente.setPerfil(perfil);
		
		pacienteDAO.salvaPaciente(novoPaciente);
		*/
		assertTrue(novoPaciente.getId() > 0);
	}

}
