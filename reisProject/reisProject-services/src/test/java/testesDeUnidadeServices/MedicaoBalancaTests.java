package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.model.MedicaoBalancaDomain;

public class MedicaoBalancaTests {
	
	
	@Test
	public void criarMedicaoBalancaTest() {
		MedicaoBalancaDAO medicaoDAO = new MedicaoBalancaDAO();
		MedicaoBalancaDomain NovaMedicaoDomain = new MedicaoBalancaDomain();
		medicaoDAO.salvaMedicaoBalanca(NovaMedicaoDomain);
		assertTrue(NovaMedicaoDomain.getId() > 0);
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
