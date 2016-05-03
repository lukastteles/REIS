package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.PacienteDomain;


public class PersistenciaPerfilTests {

	
	@Before
	public void limparBase(){
		LoginDAO perfilDAO = new LoginDAO();

	}
	
	@Test
	public void criarPerfilTest() {
		LoginDAO perfilDAO = new LoginDAO();
		PacienteDomain novoPerfil = new PacienteDomain();
		perfilDAO.salvaLogin(novoPerfil);
		assertTrue(novoPerfil.getId() > 0);
	}
	
	@Test
	public void obterPerfilTest(){
		LoginDAO perfilDAO = new LoginDAO();
		List<PacienteDomain> perfis = perfilDAO.listaLogins();		
		int idUltimoPerfil = perfis.get(0).getId();
		//PacienteDomain perfil = perfilDAO.obtemPerfil(idUltimoPerfil);
		
		assertTrue(perfis.size() > 0);
		//assertTrue(perfil.getId() > 0);
	}

}
