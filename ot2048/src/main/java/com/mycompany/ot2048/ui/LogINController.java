package com.mycompany.ot2048.ui;

import com.mycompany.ot2048.dao.UserDao;
import com.mycompany.ot2048.domain.User;
import com.mycompany.ot2048.domain.User;
import com.mycompany.ot2048.dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// This is the controller for log in screen


public class LogINController implements Initializable {
    
    @FXML
    Label status;
    
    @FXML
    TextField usernameField;
    
    @FXML
    PasswordField passwordField;
    
    @FXML
    Button LogIn;
    
    @FXML
    Button questLogIn;
    
    @FXML
    private void logInButtonAction(ActionEvent event) throws IOException, SQLException {
        
        if(doesUsernameExist(getUsernameField()) && isPasswordCorrect(getPasswordField())) { 
            startGame(new Stage());
    } else {
        
            status.setText("Wrong username or password");
    }
    
        
        
    }
    
    
     @FXML
    private void questLogInButtonAction(ActionEvent event) throws IOException { 
        
    
            startGame(new Stage());
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
       
        
        
    }


   public void startGame(Stage stage) throws IOException { 
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Game.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Peli");
        stage.setScene(scene);
        stage.show();
        
        closeLogInScreen();
        
       
   }
   
   public void closeLogInScreen(){
       
       Stage logInScreenStage = (Stage) LogIn.getScene().getWindow();
       logInScreenStage.close();
   }
   
   
   public String getUsernameField(){
       return usernameField.getText();
   }
   
   
    public String getPasswordField(){
       return passwordField.getText();
       
   }
    
    
   public boolean doesUsernameExist(String username) throws SQLException{
        UserDao userDao = new UserDao();
        User user = userDao.read(username);
        
        if(user == null){
            return false;
        }
        
        return true;
        
       
   }
   
   
   public boolean isPasswordCorrect(String username) throws SQLException{
       
       UserDao userDao = new UserDao();
       
       User user = userDao.read(username);
       
       if(user.getPassword() == getPasswordField()){
           return true;
       }
       
       return false;
       
   }
   
   
   
   
   
   
   
}
