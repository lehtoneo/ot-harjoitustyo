
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.dao;

import com.lehtoneo.ot2048.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ossij
 */
public class UserDao implements Dao<User, String> { 

    @Override
    public void create(User user) throws SQLException {
        
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO User"
            + " (username, password)"
            + " VALUES (?, ?)");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        
        stmt.executeUpdate();
    //    stmt.close();
    //   connection.close();
        
    }

    @Override
    public List<User> list() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement statement = connection.prepareStatement("SELECT username, password FROM User");

        
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            
            User user = new User(username, password);
            
            userList.add(user);
            
        }
        
   //     statement.close();
   //     connection.close();
        return userList;
        
    }
    
   
  

    @Override
    public User read(String username) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        
        if (!rs.next()) {
            return null;
        }
        
        
        User user = new User(rs.getString("Username"), rs.getString("Password"));
        
     //     stmt.close();
    //    connection.close();
        
        return new User(rs.getString("Username"), rs.getString("Password"));
    }
    

   

  
    
    
  

    
    
}
