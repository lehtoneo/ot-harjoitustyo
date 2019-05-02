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
import java.util.HashMap;
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
        PreparedStatement stmt = conn.prepareStatement("Delete FROM User WHERE username = ?");
        PreparedStatement stmt2 = conn.prepareStatement("Delete FROM User WHERE username = ?");
        stmt.setString(1, "username");
        stmt2.setString(1, "testuser");
        
        stmt.executeUpdate();
        stmt2.executeUpdate();

        
        
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
    
    @Test
    public void updateHighScoreMethodUpdatesHighScoreIfParameterScoreIsBetterThanCurrentScore() throws SQLException {
       
        User user = userdao.read("testuser");
        
        userdao.updateHighscore(user, 120);
        
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setString(1, "testuser");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int shouldBe120 = rs.getInt("highscore");
        
        assertEquals(120, shouldBe120);
    }
    
    @Test
    public void updateHighScoreMethodDoesntUpdateHighScoreIfParameterHighScoreIsWorseThanCurrentHighscore() throws SQLException {
       
        User user = userdao.read("testuser");
        
        userdao.updateHighscore(user, 120);
        userdao.updateHighscore(user, 8);
        
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setString(1, "testuser");
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int shouldBe120 = rs.getInt("highscore");
        
        assertEquals(120, shouldBe120);
    }
    
    
    @Test
    public void getHighScoreMethodReturnsHighScore() throws SQLException {
       
        User user = userdao.read("testuser");
        
        userdao.updateHighscore(user, 2048);
        
        int shouldBe2048 = userdao.getHighscore(user);
        
        assertEquals(2048, shouldBe2048);
    }
    
    @Test
    public void listMethodReturnsHashMapSoThatKeyValue1PointsToUserWithBiggestHighscore() throws SQLException {
    
        HashMap<Integer, String> testMap = userdao.list();
        boolean truth = true;
        User shouldBeBestPlayer = userdao.read(testMap.get(1));
        Integer shouldBeBestScore = userdao.getHighscore(shouldBeBestPlayer);
        for (int i = 1; i < testMap.size() + 1; i++) {
            if (shouldBeBestScore < userdao.getHighscore(userdao.read(testMap.get(i)))) {
                truth = false;
                break;
            }
        }
        
        assertTrue(truth);
        
}
    
    
    
    
}
