/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.domain;

import com.lehtoneo.ot2048.dao.UserDao;
import java.sql.SQLException;
import javafx.scene.control.PasswordField;

/**
 *
 * @author ossij
 */
public class Ot2048Service {
    
    private User loggedIn;
    
    
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
       
       
    public boolean isPasswordCorrect(User user) throws SQLException {
       
        UserDao userDao = new UserDao();
       
        User user2 = userDao.read(user.getUsername());
       
        if (user.getPassword().equals(user2.getPassword())) {
            return true;
        }
       
        return false;
       
    }
    
    
    public boolean doPasswordFieldsMatch(String password, String passwordAgain) {
        if (password.equals(passwordAgain)) {
            return true;
        }
        
        
        return false;
    }
    
    
    public void createUser(User user) throws SQLException {
        
        UserDao userDao = new UserDao();
        userDao.create(user);
    }

   
    
}
