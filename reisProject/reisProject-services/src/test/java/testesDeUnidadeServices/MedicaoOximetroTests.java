package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.br.uepb.dao.MedicaoOximetroDAO;
import com.br.uepb.model.MedicaoOximetroDomain;


public class MedicaoOximetroTests {

	@Test
	public void criarMedicaoOximetroTest() {
		MedicaoOximetroDAO medicaoDAO = new MedicaoOximetroDAO();
		MedicaoOximetroDomain NovaMedicaoDomain = new MedicaoOximetroDomain();
		medicaoDAO.salvaMedicaoOximetro(NovaMedicaoDomain);
		assertTrue(NovaMedicaoDomain.getId() > 0);
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
