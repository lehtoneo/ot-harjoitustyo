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
 * Controller luokka, joka huolehtii ikkunasta, jossa luodaan uusikäyttäjä
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
    UserDao dao;
    
    /**
     * alustaa service ja dao oliot
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new Ot2048Service();
        dao = new UserDao();
    }
    
    /**
     * submit napit painamisen toimisesta huolehtiva metodi
     * @param event #
     * @throws IOException -
     * @throws SQLException -
     * @throws InterruptedException -
     */
    @FXML
    private void submitButtonAction(ActionEvent event) throws IOException, SQLException, InterruptedException {
        
        
        if (!service.doPasswordFieldsMatch(createUserPassword.getText(), createUserPasswordAgain.getText())) {
            passwordFieldsDontMatch();
            return;
        }
        
        if (service.doesUsernameExist(createUsername.getText())) {
            usernameExists();
            return;
        }
        
        User newUser = new User(createUsername.getText(), createUserPassword.getText());
         
        if (newUser.isUserLegal()) {
            letsMakeANewUser(newUser);
        } else {
            cantMakeThisUser();
        }
        

        
    }
    
    /**
     * Tyhjentää salasanakentät
     */
    public void clearPasswordFields() {
        createUserPassword.setText("");
        createUserPasswordAgain.setText("");
    }
    
    /**
     * Sulkee käyttäjänluomis-ikkunan
     * @throws InterruptedException -
     */
    public void closeCreateUserScreen() throws InterruptedException {
        Stage createUserStage = (Stage) submit.getScene().getWindow();
        sleep(1000);
        createUserStage.close();
        
        
        
        
    }
    /**
     * Asettaa tekstin, että salasanakentät eivät täsmää, sekä tyhjentää kentät
     * @see #clearPasswordFields() 
     */
    public void passwordFieldsDontMatch() {
        somethingIsWrongPassword.setText("Passwordfields don't match.");
        everythingOk.setText("");
        clearPasswordFields();
        
    }
    
    /**
     * Asettaa tekstin, että käyttäjänimi on käytössä, sekä tyhjentää salasanakentät
     * @see #clearPasswordFields() 
     */
    public void usernameExists() {
        somethingIsWrongUsername.setText("Username is already in use");
        everythingOk.setText("");
        clearPasswordFields();
    }
    
    /**
     * Luo daon avulla uuden käyttäjän, sekä asettaa tekstin, että käyttäjä on luotu onnistuneesti
     * @param user käyttäjä, joka luodaan
     * @throws SQLException -
     * @throws InterruptedException  -
     */
    public void letsMakeANewUser(User user) throws SQLException, InterruptedException {
        dao.create(user);
        everythingOk.setText("User created successfully!");
            
        clearPasswordFields();
        closeCreateUserScreen();
    }
    
    /**
     * Asettaa tekstejä, jossa kerrotaan, mikä on mahdollisesti mennyt pieleen käyttäjää luodessa
     */
    public void cantMakeThisUser() {
        somethingIsWrongUsername.setText("Make sure your username is atleast 4 characters long");
        somethingIsWrongPassword.setText("Password has to be atleast 5 characters long");
        someThingIsWrongPasswordTwo.setText("Password can't contain spaces");
        everythingOk.setText("");
        clearPasswordFields();
        
    }
    
    /**
     * Metodi, joka pysäyttää sovelluksen toiminnan hetkellisesti
     * @param time aika, jonka sovellus odottaa tekemättä mitään
     * @throws InterruptedException #
     */
    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    } 
        
}
    