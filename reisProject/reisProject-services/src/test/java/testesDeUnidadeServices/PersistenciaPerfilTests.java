package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.br.uepb.dao.PerfilDAO;
import com.br.uepb.model.PacienteDomain;


public class PersistenciaPerfilTests {

	
	@Before
	public void limparBase(){
		PerfilDAO perfilDAO = new PerfilDAO();

	}
	
	@Test
	public void criarPerfilTest() {
		PerfilDAO perfilDAO = new PerfilDAO();
		PacienteDomain novoPerfil = new PacienteDomain();
		perfilDAO.salvaPaciente(novoPerfil);
		assertTrue(novoPerfil.getId() > 0);
	}
	
	@Test
	public void obterPerfilTest(){
		PerfilDAO perfilDAO = new PerfilDAO();
		List<PacienteDomain> perfis = perfilDAO.listaPerfis();		
		int idUltimoPerfil = perfis.get(0).getId();
		//PacienteDomain perfil = perfilDAO.obtemPerfil(idUltimoPerfil);
		
		assertTrue(perfis.size() > 0);
		//assertTrue(perfil.getId() > 0);
	}

}
