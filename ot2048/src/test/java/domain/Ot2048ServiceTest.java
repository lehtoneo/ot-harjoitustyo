/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.lehtoneo.ot2048.domain.Ot2048Service;
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
    
    @Before
    public void setUp() {
        service = new Ot2048Service();
    }
    
    @After
    public void tearDown() {
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
}
