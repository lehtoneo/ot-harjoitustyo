/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ossij
 */
public class UserDAO implements Dao<User,Integer>{

    @Override
    public void create(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO User"
            + " (username, password)"
            + " VALUES (?, ?");
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getPassword());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
        
    }

    @Override
    public User read(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> list() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public User readWithUsername(String username) throws SQLException {
         Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
        
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        
        if(!rs.next()) {
            return null;
        }
        
        
        User user = new User(rs.getString("Username"), rs.getString("Password"));
        
        stmt.close();
        connection.close();
        
        return new User(rs.getString("Username"), rs.getString("Password"));
    }
    
    
  

    
    
}
