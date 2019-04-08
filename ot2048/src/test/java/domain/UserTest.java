/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.lehtoneo.ot2048.domain.User;
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
    User testUser1;
    User testUser2;
    User testUser3;
    User testUser4;
    User testUser5;
    User testUser6;
    User testUser7;
    
    @Before
     public void setUp() {
        testUser1 = new User("mo iii", "      lllll");
        testUser2 = new User("he i", "moi");
        testUser3 = new User("oee", "o  ");
        testUser4 = new User("username", "password");
        testUser5 = new User("user", "passw");
        
        testUser6 = new User("user", "  l");
        testUser7 = new User("u", "password");
    }
     //tests for equal method
      @Test
    public void equalWhenSameUsername() {
        User u1 = new User("hei", "moi");
        User u2 = new User("hei", "moi");
        assertTrue(u1.equals(u2));
    }
    
    
      @Test
    public void notEqualWhenDifferentUsername() {
        User u1 = new User("test2", "Teppo");
        User u2 = new User("test1", "Teppo");
        assertFalse(u1.equals(u2));
    }
    
    //tests for idPasswordEqual method
    @Test
    public void passwordIsNotLegalIfItContainsSpaces() {
        assertFalse(testUser1.isPasswordLegal());
    }
    
    @Test
    public void passwordIsNotLegalIfItIsTooShort() {
        assertFalse(testUser2.isPasswordLegal());
    }
    
    @Test
    public void passwordIsNotLegalIfItIsTooShortAndContainsSpaces() {
        assertFalse(testUser3.isPasswordLegal());
    }
    
    @Test
    public void passwordIsLegalIfItDoesntContainWhiteSpacesAndItIsFiveCharactersLong() {
        assertTrue(testUser5.isPasswordLegal());
    }
    
    @Test
    public void passwordIsLegalIfItDoesntContainWhiteSpacesAndItIsOverFiveCharactersLong() {
        assertTrue(testUser4.isPasswordLegal());
    }
    
    //tests for isUsernameLegal
    @Test
    public void usernameIsNotLegalIfItIsUnderFourCharactersLong() {
        assertFalse(testUser3.isUsernameLegal());
    }
    
    @Test
    public void usernameIsNotLegalIfItContainsSpaces() {
        assertFalse(testUser2.isUsernameLegal());
    }
    
    @Test
    public void usernameIsNotLegalIfItContainsSpacesAndIsTooShort() {
        assertFalse(testUser1.isUsernameLegal());
    }
    
    @Test
    public void usernameIsLegalIfItDoesntContainSpacesAndItIsFourCharactersLong() {
        assertTrue(testUser5.isUsernameLegal());
    }
    
    @Test
    public void usernameIsLegalIfItDoesntContainSpacesAndItIsOverFourCharactersLong() {
        assertTrue(testUser4.isUsernameLegal());
    }
    
    //tests for method isUserLegal
    
    @Test
    public void userIsNotLegalIfPasswordIsNotLegalButUsernameIs() {
        assertFalse(testUser6.isUserLegal());
    }
    
    @Test
    public void userIsNotLegalIfPasswordIsLegalButUsernameIsNot() {
        assertFalse(testUser7.isUserLegal());
    }
    
    @Test
    public void userIsNotLegalIfPasswordIsNotLegalAndUsernameIsNotLegal() {
        assertFalse(testUser1.isUserLegal());
    }
    
    @Test
    public void userIsLegalIfPasswordILegalAndUsernameIsLegal() {
        assertTrue(testUser5.isUserLegal());
    }
    
    
    

    
}
