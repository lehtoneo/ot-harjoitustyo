package com.lehtoneo.ot2048.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.GameGrid;
import com.lehtoneo.ot2048.domain.Ot2048Service;
import com.lehtoneo.ot2048.domain.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ossij
 */
public class GameController implements Initializable {
    
    
    
     @FXML
    public Label zeroZero;
    @FXML
    private Label zeroOne;
    @FXML
    private Label zeroTwo;
    @FXML
    private Label zeroThree;
    @FXML
    private Label oneZero;
    @FXML
    private Label oneOne;
    @FXML
    private Label oneTwo;
    @FXML
    private Label oneThree;
    @FXML
    private Label twoZero;
    @FXML
    private Label twoOne;
    @FXML
    private Label twoTwo;
    @FXML
    private Label twoThree;
    @FXML
    private Label threeZero;
    @FXML
    private Label threeOne;
    @FXML
    private Label threeTwo;
    @FXML
    private Label threeThree;
    @FXML
    private GridPane grid;
    @FXML
    private Label loggedInLabel;
    @FXML
    private Button quitGame;
    @FXML
    private Text saveText;
    
    @FXML
    private Text currentHighscore;
    
    private Ot2048Service service;
    private User loggedIn;
    private Label[][] labels;
    private GameGrid gamegrid;
    private UserDao userdao;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        gamegrid = new GameGrid();
        
        labels = new Label[4][4];
        
        service = new Ot2048Service();
        
        userdao = new UserDao();
        
        
        labels[0][0] = zeroZero;
        labels[0][1] = zeroOne;
        labels[0][2] = zeroTwo;
        labels[0][3] = zeroThree;
        labels[1][0] = oneZero;
        labels[1][1] = oneOne;
        labels[1][2] = oneTwo;
        labels[1][3] = oneThree;
        labels[2][0] = twoZero;
        labels[2][1] = twoOne;
        labels[2][2] = twoTwo;
        labels[2][3] = twoThree;
        labels[3][0] = threeZero;
        labels[3][1] = threeOne;
        labels[3][2] = threeTwo;
        labels[3][3] = threeThree;
        
        
         for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                
                if(gamegrid.getGrid()[x][y] == 1){
                    labels[y][x].setText("1");
                    
                    
                } else {
                    labels[y][x].setText("0");
                    
                }
                
                
                
            }
            
            update();
        
        
      
                
            }
        
        
    }
    
    
        @FXML  
        void keyPressed(KeyEvent event) {
            switch (event.getCode()) {
            
                case LEFT:
                gamegrid.moveLeft();
                update();
                break;
            
            case UP:
                gamegrid.moveUp();
                update();
                break;
            
            case DOWN:
                gamegrid.moveDown();
                update();
                break;
            
            case RIGHT:
                gamegrid.moveRight();
                update();
                break;
            
            
            default:
                break;
            }
        }


 public void update(){
        
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < 4; y++){
                String indexAsText = String.valueOf(gamegrid.getGrid()[y][x]);
                
                labels[y][x].setText(indexAsText);
                
                
                
                
            }
        }
        
        saveText.setText("");
        
        
        
        
            
        

        
    }
 
 
@FXML
private void quitGameButtonAction(ActionEvent event) throws IOException, Exception { 
        
    Stage gameStage = (Stage) quitGame.getScene().getWindow();
    setLoggedIn(null);    
    gameStage.close();

    SetUpLogInUI ui = new SetUpLogInUI();
    
    ui.start(new Stage());
                    
        
}

@FXML
private void saveScoreAction(ActionEvent event) throws IOException, Exception { 
        
    boolean didItUpdate = userdao.updateHighscore(service.getLoggedIn(), gamegrid.getCurrentPoints());
    
    if (didItUpdate) {
        saveText.setText("HighScore saved succesfully");
        currentHighscore.setText(userdao.getHighscore(service.getLoggedIn()).toString());
    } else {
        saveText.setText("No point in saving, you already have a better highscore");
    }
    
    
        
}
 
 
 public void setLoggedIn(User user)  {
    this.loggedIn = user;
 }
 
 
 public void setOt2048Service(Ot2048Service service) throws SQLException {
    this.service.setLoggedIn(service.getLoggedIn());
    loggedInLabel.setText("Logged in as: " + this.service.getLoggedIn().getUsername());
    currentHighscore.setText(userdao.getHighscore(this.service.getLoggedIn()).toString());
 }
 
 

    
}
