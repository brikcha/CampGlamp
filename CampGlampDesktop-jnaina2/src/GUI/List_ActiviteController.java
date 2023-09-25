/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ActiviteService;
import entites.Activite;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class List_ActiviteController implements Initializable {

    @FXML
    private Label Username;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Button btn_event;
    @FXML
    private Button btn_activ;

     private ArrayList<Activite> actData =  new ArrayList<>();
    ActiviteService ac = new ActiviteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GOEvents(ActionEvent event) {
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/EventList_Front.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(List_EventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               List_EventController fev=Loader.getController();
               
               fev.afficheall();
                Parent p=Loader.getRoot();
                Stage frontView ;
               
                    frontView= (Stage) ((Node) ((ActionEvent)event).getSource()).getScene().getWindow();
                
                Scene scene = new Scene(p);
                frontView.setScene(scene);
                frontView.show(); 
    }

    @FXML
    private void GoActiv(ActionEvent event) {
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/ActiviteList_Front.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(List_ActiviteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               List_ActiviteController fev=Loader.getController();
               
               fev.afficheall();
                Parent p=Loader.getRoot();
                Stage frontView ;
               
                    frontView= (Stage) ((Node) ((ActionEvent)event).getSource()).getScene().getWindow();
                
                Scene scene = new Scene(p);
                frontView.setScene(scene);
                frontView.show(); 
    }
    
     public void afficheall(){
         
    List<Activite> acts = new ArrayList<Activite>();
        acts = ac.afficherActivite();
  
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <acts.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneAct_Front.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneAct_FrontController oneact= fxmlLoader.getController();
                oneact.setData(acts.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                grid.add(anchorPane, column++, row); 
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
