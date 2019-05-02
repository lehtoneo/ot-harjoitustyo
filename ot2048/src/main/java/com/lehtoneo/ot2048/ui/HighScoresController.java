/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.ui;

import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * HighScore ikkunan controller luokka
 *
 * @author ossij
 */
public class HighScoresController implements Initializable {

    
    @FXML
private Text numberOneUser;
    @FXML
private Text numberTwoUser;
    @FXML
private Text numberThreeUser;
    @FXML
private Text numberOneScore;
    @FXML
private Text numberTwoScore;
    @FXML
private Text numberThreeScore;

    private UserDao dao;

    /**
     * Alustaa luokan
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new UserDao();
        try {
            getThreeBestUsers();
        } catch (SQLException ex) {
            System.out.println("EI TOIMI");
            Logger.getLogger(HighScoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
   /**
    * Lataa top3 highscoret ja asettaa ne tekstikenttiin
    */ 
    public void getThreeBestUsers() throws SQLException {
       
        HashMap<Integer, String> highScoreMap = dao.list();
       
        if (highScoreMap == null) {
            return;
        }
       
        if (highScoreMap.size() < 1) {
            return;
        }
        User user1 = dao.read(highScoreMap.get(1));
        numberOneUser.setText(highScoreMap.get(1));
        numberOneScore.setText(dao.getHighscore(user1).toString());
        if (highScoreMap.size() < 2) {
            return;
        }
        User user2 = dao.read(highScoreMap.get(2));
        numberTwoUser.setText(highScoreMap.get(2));
        numberTwoScore.setText(dao.getHighscore(user2).toString());
        if (highScoreMap.size() < 3) {
            return;
        }
        User user3 = dao.read(highScoreMap.get(3));
       
        numberThreeUser.setText(highScoreMap.get(3));
        numberThreeScore.setText(dao.getHighscore(user3).toString());
       
    }    
    
}
