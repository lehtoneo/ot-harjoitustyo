
package com.lehtoneo.ot2048.domain;

import com.lehtoneo.ot2048.dao.UserDao;
import java.sql.SQLException;
import javafx.scene.control.PasswordField;

/**
 * Apuluokka huolehtimaan osasta käyttöliittymään liittyvästä sovelluslogiikasta
 */
public class Ot2048Service {
    
    private User loggedIn;
    
/**
 * Tutkii, onko parametriksi annettu käyttäjänimi varattu
 * @param username    käyttäjätunnus
 * @return true  jos käyttäjä tunnus on olemassa, muuten false
     * @throws java.sql.SQLException -
 * @see UserDao#read(java.lang.String) 
 */    
    public boolean doesUsernameExist(String username) throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.read(username);
        
        if (user == null) {
            return false;
        }
        
        return true;
        
       
    }
    
    public void setLoggedIn(User user) {
        this.loggedIn = user;
    }
    
    public User getLoggedIn() {
        return this.loggedIn;
    }
       
 /**
 * Tutkii, vastaako salasana käyttäjätunnustu
 * @param user    käyttäjä
 * @return true  jos salasana vastaa käyttäjätunnusta, muuten false
     * @throws java.sql.SQLException -
 * @see UserDao#read(java.lang.String) 
 */          
    public boolean isPasswordCorrect(User user) throws SQLException {
       
        UserDao userDao = new UserDao();
       
        User user2 = userDao.read(user.getUsername());
       
        if (user.getPassword().equals(user2.getPassword())) {
            return true;
        }
       
        return false;
       
    }
    
  /**
 * Vertailee kahta stringiä
 * @param password    salasana
 * @param passwordAgain    salasana uusiksi
 * @return true  jos salasanat vastaa toisiaan, muuten false
 */          
    public boolean doPasswordFieldsMatch(String password, String passwordAgain) {
        return password.equals(passwordAgain);
    }
    
    
//    public void createUser(User user) throws SQLException {
//        
//        UserDao userDao = new UserDao();
//        userDao.create(user);
//    }

   
    
}
