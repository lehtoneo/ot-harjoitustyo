package UI;

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
import javafx.stage.Stage;

// This is the controller for log in screen


public class LogINController implements Initializable {
    
   
    
    @FXML
    Button LogIn;
    
    @FXML
    private void logInButtonAction(ActionEvent event) throws IOException {
        //Kirjautuu jos tiedot oikein
       
    startGame(new Stage());
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
    }


   public void startGame(Stage stage) throws IOException{
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
   
   
}
