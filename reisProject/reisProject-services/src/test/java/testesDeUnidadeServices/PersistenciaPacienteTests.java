package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.PacienteDomain;

public class PersistenciaPacienteTests {

		
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
	}

}
