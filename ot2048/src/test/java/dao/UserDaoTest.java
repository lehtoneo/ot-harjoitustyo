/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class UserDaoTest {
    
   User user;
   UserDao userdao; 
    @Before
    public void setUp() throws SQLException {
        user = new User("username", "password");
        userdao = new UserDao();
        
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "")) {
            conn.prepareStatement("CREATE TABLE User(id INTEGER NOT NULL AUTO_INCREMENT, username VARCHAR, password VARCHAR, highscore INTEGER);").executeUpdate();
            
            
      
            
        } catch (SQLException ex) {
            
        }
        userdao.create(new User("testuser", "passu"));
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        PreparedStatement stmt = conn.prepareStatement("Delete FROM User WHERE username = username");
        
        stmt.executeUpdate();

        
        
    }
    
    
    
    @Test
    public void createUserMethodCreatesUser() throws SQLException {
        userdao.create(user);
      
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement statement = connection.prepareStatement("SELECT username, password FROM User WHERE username = username");

        
        ResultSet resultSet = statement.executeQuery();
        
        assertTrue(resultSet.next());
      
      
    }
    
    @Test
    public void readMethodReturnsUserWhenUserExists() throws SQLException {
        User user2 = userdao.read("testuser");
        
        assertEquals(user2.getUsername(), "testuser");
    }
    
    
}
