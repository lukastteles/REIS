package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.PacienteDomain;

public class MedicaoBalancaTests {
	
	
	@Test
	public void criarMedicaoBalancaTest() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		
		PacienteDomain paciente = new PacienteDomain();
		if(pacienteDAO.listaPacientes().isEmpty()){
			
			paciente.setNome("Jorge Miranda");
			paciente.setEndereco("Rua Calvario Azul");
			paciente.setSexo("M");
			paciente.setCidade("Campina Grande");
			pacienteDAO.salvaPaciente(paciente);			
		}
		else{
			paciente = pacienteDAO.listaPacientes().get(0);
		}
		MedicaoBalancaDAO medicaoDAO = new MedicaoBalancaDAO();
		MedicaoBalancaDomain novaMedicaoDomain = new MedicaoBalancaDomain();
		novaMedicaoDomain.setAltura(173);
		novaMedicaoDomain.setMassa(81);
		novaMedicaoDomain.setPeso(810);
		novaMedicaoDomain.setPaciente(paciente);
		medicaoDAO.salvaMedicaoBalanca(novaMedicaoDomain);
		assertTrue(novaMedicaoDomain.getId() > 0);
	}
	
	@Test
	public void obterMedicaoBalancaTest(){
		MedicaoBalancaDAO medicaoDAO = new MedicaoBalancaDAO();
		List<MedicaoBalancaDomain> medicoes = medicaoDAO.listaMedicoes();	
		int idUltimoMedicao = medicoes.get(0).getId();
		MedicaoBalancaDomain medicao = medicaoDAO.obtemMedicaoBalanca(idUltimoMedicao);
		
		assertTrue(medicoes.size() > 0);
		assertTrue(medicao.getId() > 0);
	}
}
