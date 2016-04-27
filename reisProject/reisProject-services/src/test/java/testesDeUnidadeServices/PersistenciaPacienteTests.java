package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.dao.PerfilDAO;
import com.br.uepb.model.PacienteDomain;
import com.br.uepb.model.PerfilDomain;

public class PersistenciaPacienteTests {

	@Before
	public void criarPerfil(){
		PerfilDAO perfilDAO = new PerfilDAO();
		PerfilDomain perfil = new PerfilDomain();
		
		perfilDAO.salvaPerfil(perfil);
	}
	
	@Test
	public void criarPacienteTest() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		PerfilDAO perfilDAO = new PerfilDAO();
		PacienteDomain novoPaciente = new PacienteDomain();		
		PerfilDomain perfil = perfilDAO.obtemPerfil(1);
		
		novoPaciente.setLogin("joao");
		novoPaciente.setSenha("senha123");
		novoPaciente.setNome("João Lopes");
		novoPaciente.setPerfil(perfil);
		
		pacienteDAO.salvaPaciente(novoPaciente);
		
		assertTrue(novoPaciente.getId() > 0);
	}

}
