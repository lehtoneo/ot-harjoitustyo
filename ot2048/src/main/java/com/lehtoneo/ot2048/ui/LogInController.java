package com.lehtoneo.ot2048.ui;

import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.User;
import com.lehtoneo.ot2048.domain.User;
import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.Ot2048Service;
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


public class LogInController implements Initializable {
    
    @FXML
    Label status;
    
    @FXML
    TextField usernameField;
    
    @FXML
    PasswordField passwordField;
    
    @FXML
    Button logIn;
    
    @FXML
    Button questLogIn;
    
    @FXML
    Button createNewUserButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
    @FXML
    private void createNewUserButtonAction(ActionEvent event) throws IOException {
        openCreateUserScreen(new Stage());
    }
    
    @FXML
    private void logInButtonAction(ActionEvent event) throws IOException, SQLException {
        Ot2048Service service = new Ot2048Service();
        
        User user = new User(getUsernameField(), getPasswordField());
        
        if(service.doesUsernameExist(user.getUsername())) {
            
            if(service.isPasswordCorrect(user)) {
                startGame(new Stage());
                
            } else {
                status.setText("Wrong username or password");
            }
            
        } else {
            
            status.setText("Wrong username or password");
            
        }
        
    }
    
    
     @FXML
    private void questLogInButtonAction(ActionEvent event) throws IOException { 
        
    
            startGame(new Stage());
        
        
    }
    


   public void startGame(Stage stage) throws IOException { 
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
        
        closeLogInScreen();
        
       
   }
   
   public void closeLogInScreen(){
       
       Stage logInScreenStage = (Stage) logIn.getScene().getWindow();
       logInScreenStage.close();
   }
   
   
   public String getUsernameField(){
       return usernameField.getText();
   }
   
   
    public String getPasswordField(){
       return passwordField.getText();
       
   }
    
    
   public void openCreateUserScreen(Stage stage) throws IOException { 
        Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Create a new user");
        stage.setScene(scene);
        stage.show();
        
       
   }  
    

}
