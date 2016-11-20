import io.github.printf.educake.dao.LoginDAO;
import io.github.printf.educake.model.Login;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Vitor Silvério de Souza
 *         On nov, 2016
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    LoginDAO dao = new LoginDAO();
    Login user;

    @Test
    public void createUser(){
        Login login = new Login();
        login.setUser("Admin");
        login.setPassword("Admin");

        user = login;

        assertTrue(dao.persist(login));
    }

    @Test
    public void tryLoginSuccess(){
        assertTrue(dao.tryLogin("Admin", "Admin"));
    }

    @Test
    public void tryLoginFailUser(){
        assertFalse(dao.tryLogin("AAA", "Admin"));
    }

    @Test
    public void tryLoginFailPass(){
        assertFalse(dao.tryLogin("Admin", "AAA"));
    }

    @Test
    public void uRemoveUser(){ // o "u" é só pra alterar a sequência de execução
        assertTrue(dao.remove(user));
    }
}
