/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.domain;

/**
 *
 * @author ossij
 */
public class User {
    
    String username;
    String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isUserLegal() {
        
        if (isUsernameLegal() && isPasswordLegal()) {
            return true;
        }
        return false;
    }
    
    public boolean isUsernameLegal() {
        
        if (username == null) {
            return false;
        }
        
        String usernameTrimmed = username.replaceAll("\\s", "");
        
        if (!usernameTrimmed.equals(username) || usernameTrimmed.length() < 4) {
            return false;
        }
        return true;
        
    }
    
    public boolean isPasswordLegal() {
        
        if (password == null) {
            return false;
        }
        
        String passwordTrimmed = password.replaceAll("\\s", "");
        
        if (!passwordTrimmed.equals(password) || password.length() < 5) {
            
            return false;
            
        }
        return true;
    }
    
    
    @Override
    public boolean equals(Object obj) {
            
        if (!(obj instanceof User)) {
            return false;
        }
        
        User other = (User) obj;
        return username.equals(other.username);
        
        
    }
    
    
    
    
}
