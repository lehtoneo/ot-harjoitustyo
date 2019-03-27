/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.ot2048.domain.User;
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
public class UserTest {
    
      @Test
    public void equalWhenSameUsername() {
        User u1 = new User("tester", "Teppo");
        User u2 = new User("tester", "Teppo");
        assertTrue(u1.equals(u2));
    }
    
    
      @Test
    public void notEqualWhenDifferentUsername() {
        User u1 = new User("test2", "Teppo");
        User u2 = new User("tester", "Teppo");
        assertFalse(u1.equals(u2));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
