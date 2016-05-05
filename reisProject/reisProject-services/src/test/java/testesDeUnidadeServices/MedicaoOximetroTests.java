package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.PacienteDomain;


public class MedicaoOximetroTests {

	@Test
	public void criarMedicaoOximetroTest() {
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
		
		MedicaoOximetroDAO medicaoDAO = new MedicaoOximetroDAO();
		MedicaoOximetroDomain novaMedicaoDomain = new MedicaoOximetroDomain();
		novaMedicaoDomain.setPaciente(paciente);
		novaMedicaoDomain.setSpo2(120);
		novaMedicaoDomain.setTaxaPulso(100);
		
		medicaoDAO.salvaMedicaoOximetro(novaMedicaoDomain);
		assertTrue(novaMedicaoDomain.getId() > 0);
	}
	
	@Test
	public void obterMedicaoOximetroTest(){
		MedicaoOximetroDAO medicaoDAO = new MedicaoOximetroDAO();
		List<MedicaoOximetroDomain> medicoes = medicaoDAO.listaMedicoes();	
		int idUltimoMedicao = medicoes.get(0).getId();
		MedicaoOximetroDomain medicao = medicaoDAO.obtemMedicaoOximetro(idUltimoMedicao);
		
		assertTrue(medicoes.size() > 0);
		assertTrue(medicao.getId() > 0);
	}
}
