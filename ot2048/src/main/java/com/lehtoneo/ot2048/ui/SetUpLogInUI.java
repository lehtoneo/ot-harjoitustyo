package com.lehtoneo.ot2048.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;






public class SetUpLogInUI extends Application {

   
   
    
    @Override
    public void start(Stage stage) throws Exception {
//     Connection connection = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "");
//        
//        PreparedStatement stmt = connection.prepareStatement("CREATE TABLE User (\n" +
//"    id int NOT NULL AUTO_INCREMENT,\n" +
//"    username varchar,\n" +
//"    password varchar,\n" +
//"    PRIMARY KEY (id)\n" +
//");");
//        
//        stmt.executeUpdate();
//        stmt.close();
//        connection.close();
        initDatabase();

        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        
        Scene scene = new Scene(root);
 
       scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Log IN");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    private static void initDatabase() {
        
           try (Connection conn = DriverManager.getConnection("jdbc:h2:./kayttajatJaHighscoret", "sa", "")) {
            conn.prepareStatement("CREATE TABLE User(id INTEGER NOT NULL AUTO_INCREMENT, username VARCHAR, password VARCHAR);").executeUpdate();
            
            
      
            
        } catch (SQLException ex) {
            
        }
        
    }

}


