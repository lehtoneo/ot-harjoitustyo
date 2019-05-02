/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.Ot2048Service;
import com.lehtoneo.ot2048.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.PasswordField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ossij
 */
public class Ot2048ServiceTest {
    
    private Ot2048Service service;
    PasswordField pass;
    private UserDao dao;
    
    @Before
    public void setUp() {
        service = new Ot2048Service();
        dao = new UserDao();
    }
    
    @After
    public void tearDown() throws SQLException {
        
        Connection conn = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("Delete FROM User WHERE username = ?");
        stmt.setString(1, "asojdoaaw");
        
        PreparedStatement stmt2 = conn.prepareStatement("Delete FROM User WHERE username = ?");
        stmt2.setString(1, "asojdoaqw2aw");
        
        PreparedStatement stmt3 = conn.prepareStatement("Delete FROM User WHERE username = ?");
        stmt3.setString(1, "asojdoaqw2aaw");
        
        stmt.executeUpdate();
        stmt2.executeUpdate();
        stmt3.executeUpdate();
        
    }

    @Test
    public void ifPasswordFieldsMatchDoPasswordFieldsMatchMethodReturnsTrue() {
        boolean shouldBeTrue = service.doPasswordFieldsMatch("passs", "passs");
        
        assertTrue(shouldBeTrue);
    }
    
     @Test
    public void ifPasswordFieldsDontMatchDoPasswordFieldsMatchMethodReturnsFalse() {
        boolean shouldBeTrue = service.doPasswordFieldsMatch("passs", "passu");
        
        assertFalse(shouldBeTrue);
    }
    
    @Test
    public void ifUserExistsDoesUsernameMethodReturnsTrue() throws SQLException {
        dao.create(new User("asojdoaaw", ""));
        
        assertTrue(service.doesUsernameExist("asojdoaaw"));
        
        
        
    }
    
    @Test
    public void ifUserDoesntExistDoesUsernameMethodReturnsFalse() throws SQLException {
        
        
        assertFalse(service.doesUsernameExist("asojdoaaqwojqwejklw"));
        
        
        
    }
    
    @Test
    public void isPasswordCorrectMethodReturnsTrueIfPasswordIsCorrect() throws SQLException {
        dao.create(new User("asojdoaqw2aw", "aaaaa"));
        
        assertTrue(service.isPasswordCorrect(new User("asojdoaqw2aw", "aaaaa")));
        
    }
    
    
    @Test
    public void isPasswordCorrectMethodReturnsFalseIfPasswordIsNotCorrect() throws SQLException {
        dao.create(new User("asojdoaqw2aaw", "aaaaa"));
        
        assertFalse(service.isPasswordCorrect(new User("asojdoaqw2aaw", "bbbbb")));
        
    }
    
    
}
