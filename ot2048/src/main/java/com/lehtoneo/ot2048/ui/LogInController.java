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


/**
 * Controller luokka, joka huolehtii log in ikkunasta
*/
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
    
    
    public Ot2048Service service;
    
    /**
     * alustaa ot2048Service olion
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        service = new Ot2048Service();
    }
    
    /**
     * Huolehtii create new user napin kontrollista
     * @see #openCreateUserScreen(javafx.stage.Stage) 
     * @param event -
     * @throws IOException -
     */
    @FXML
    private void createNewUserButtonAction(ActionEvent event) throws IOException {
        openCreateUserScreen(new Stage());
    }
    
    /**
     * Huolehtii log in napin kontrollista
     * @param event
     * @throws IOException
     * @throws SQLException 
     */
    @FXML
    private void logInButtonAction(ActionEvent event) throws IOException, SQLException {
        
        User user = new User(getUsernameField(), getPasswordField());
        
        if(service.doesUsernameExist(user.getUsername())) {
            
            if(service.isPasswordCorrect(user)) {
                service.setLoggedIn(user);
                startGame(new Stage());
                
            } else {
                status.setText("Wrong username or password");
            }
            
        } else {
            
            status.setText("Wrong username or password");
            
        }
        
    }
    
    /**
     * Huolehtii log in as a quest napin kontrollista
     * @param event
     * @throws IOException
     * @throws SQLException 
     */
    @FXML
    private void questLogInButtonAction(ActionEvent event) throws IOException, SQLException { 
            UserDao dao = new UserDao();
            User user = dao.makeANewQuestUser();
            service.setLoggedIn(dao.makeANewQuestUser());
            dao.create(user);
            startGame(new Stage());
        
        
    }
    

    /**
     * Avaa uuden peli-ikkunan, sekä kutsuu peli-ikkunan setOt2048Service metodia
     * @see GameController#setOt2048Service(com.lehtoneo.ot2048.domain.Ot2048Service) 
     * @param stage -
     * @throws IOException -
     * @throws SQLException -
     */
    public void startGame(Stage stage) throws IOException, SQLException { 
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Parent root = loader.load();
        GameController c = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
        c.setOt2048Service(getService());

       
        closeLogInScreen();
        
        
   }
   
    /**
     * sulkee log in screenin
     */
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
    
    /**
     * avaa create user screenin
     * @param stage -
     * @throws IOException -
     */
    public void openCreateUserScreen(Stage stage) throws IOException { 
        Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Create a new user");
        stage.setScene(scene);
        stage.show();
        
       
   }
   
    public Ot2048Service getService() {
       return this.service;
   }
    

}