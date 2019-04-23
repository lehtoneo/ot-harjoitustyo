
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
public class UserDao implements Dao { 

    @Override
    public void create(User user) throws SQLException {
        
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO User"
            + " (username, password, highscore)"
            + " VALUES (?, ?, ?)");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        stmt.setInt(3, 0);
        
        stmt.executeUpdate();
        
        
        
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
    
    
    
    public boolean updateHighscore(User user, Integer currentScore) throws SQLException {
        
        
        
        Integer currentHighscore = getHighscore(user);
        
        if (currentHighscore >= currentScore) {
            return false;
        }
        
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        PreparedStatement stmt = connection.prepareStatement("UPDATE User "
                + "SET Highscore = ? "
                + "WHERE Username = ?");
        stmt.setInt(1, currentScore);
        stmt.setString(2, user.getUsername());
        
        stmt.executeUpdate();
        
        return true;
        
    }
    
    public Integer getHighscore(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setString(1, user.getUsername());
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        
        Integer currentHighscore = rs.getInt("highscore");
        
        return currentHighscore;
    }
    
    
    
    public User makeANewQuestUser() throws SQLException {
        
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("Select max(id) as id from user");
        
        
        ResultSet rs = stmt.executeQuery();
        
        if (!rs.next()) {
            return new User("quest00", "");
        };
        
        Integer questnumber = rs.getInt("id");
        questnumber++;
        
        return new User("Quest8348" + questnumber, "");
    }
    

   

  
    
    
  

    
    
}
