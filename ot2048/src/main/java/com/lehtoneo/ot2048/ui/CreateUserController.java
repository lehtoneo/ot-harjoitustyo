/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.ui;

import com.lehtoneo.ot2048.dao.UserDao;
import com.lehtoneo.ot2048.domain.User;
import com.lehtoneo.ot2048.domain.Ot2048Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ossij
 */
public class CreateUserController implements Initializable {

    
    @FXML
    Text somethingIsWrongUsername;
    @FXML
    Text somethingIsWrongPassword;
    @FXML
    Text someThingIsWrongPasswordTwo;
    @FXML
    TextField createUsername;
    @FXML
    PasswordField createUserPassword;
    @FXML
    PasswordField createUserPasswordAgain;
    @FXML
    Button submit;
    @FXML
    Text everythingOk;
    
    Ot2048Service service;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new Ot2048Service();
    }

    @FXML
    private void submitButtonAction(ActionEvent event) throws IOException, SQLException, InterruptedException {
        
        
        if (!service.doPasswordFieldsMatch(createUserPassword.getText(), createUserPasswordAgain.getText())) {
            somethingIsWrongPassword.setText("Passwordfields don't match.");
            everythingOk.setText("");
            return;
        }
        
        if (service.doesUsernameExist(createUsername.getText())) {
            somethingIsWrongUsername.setText("Username is already in use");
            everythingOk.setText("");
            clearPasswordFields();
            return;
        }
        
        User newUser = new User(createUsername.getText(), createUserPassword.getText());
         
        if (newUser.isUserLegal()) {
            service.createUser(newUser);
            everythingOk.setText("User created successfully!");
            
            clearPasswordFields();
            closeCreateUserScreen();
        } else {
            somethingIsWrongUsername.setText("Make sure your username is atleast 4 characters long");
            somethingIsWrongPassword.setText("Password has to be atleast 5 characters long");
            someThingIsWrongPasswordTwo.setText("Password can't contain spaces");
            everythingOk.setText("");
            clearPasswordFields();
        }
        

        
    }
    
    
    public void clearPasswordFields() {
        createUserPassword.setText("");
        createUserPasswordAgain.setText("");
    }
    
    
    public void closeCreateUserScreen() throws InterruptedException {
        Stage createUserStage = (Stage) submit.getScene().getWindow();
        sleep(1000);
        createUserStage.close();
        
        
        
        
    }
    
    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    } 
        
    }
    