/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Event;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class MainFx extends Application {
    
    
    
    @Override
     public void start(Stage primaryStage) throws Exception {
          Parent root = FXMLLoader.load(getClass().getResource("List_Event.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("list_evenements_admin.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Detailler_Evenement.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("list_activites_admin.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("Detailler_Acti.fxml"));  
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
         //primaryStage.setTitle("lecture vidéos"); 
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }
  
    

    
}
