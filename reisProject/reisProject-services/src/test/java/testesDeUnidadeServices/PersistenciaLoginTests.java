package testesDeUnidadeServices;

import static junit.framework.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.br.uepb.dao.LoginDAO;
import com.br.uepb.model.LoginDomain;
import com.br.uepb.model.PacienteDomain;


public class PersistenciaLoginTests {

	
	@Before
	public void limparBase(){
		LoginDAO perfilDAO = new LoginDAO();

	}
	
	@Test
	public void criarLoginTest() {
		LoginDAO loginDAO = new LoginDAO();
		LoginDomain novoLogin = new LoginDomain();
		loginDAO.salvaLogin(novoLogin);
		assertTrue(novoLogin.getId() > 0);
	}
	
	@Test
	public void obterLoginTest(){
		LoginDAO loginDAO = new LoginDAO();
		List<LoginDomain> logins = loginDAO.listaLogins();		
		int idUltimoPerfil = logins.get(0).getId();
		LoginDomain login = loginDAO.obtemLogin(idUltimoPerfil);
		
		assertTrue(logins.size() > 0);
		assertTrue(login.getId() > 0);
	}

}
