/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ActiviteService;
import Services.EventService;
import entites.Activite;
import entites.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class List_activites_adminController implements Initializable {

    @FXML
    private AnchorPane Dashboradadmin;
    @FXML
    private Button btn_event;
    @FXML
    private Label txtUsername;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    
    private ObservableList<Activite> eventData = FXCollections.observableArrayList();
    ActiviteService es = new ActiviteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void addActi(MouseEvent event) {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/AdminActivC.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(AdminActivCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
              
               AdminActivCController aRC=Loader.getController();
                
              
                Parent p=Loader.getRoot();
                Stage comm=new Stage();
                Scene scene = new Scene(p);
                comm.initStyle(StageStyle.TRANSPARENT);
                comm.setScene(scene);
                comm.show();
    }

    @FXML
    private void removeActiv(MouseEvent event) {
        
    }


    @FXML
    private void GestionActivite(ActionEvent event) {
    }
     public void afficheall(){
         
    List<Activite> events = new ArrayList<Activite>();
        events = es.afficherActivite();
  
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneActiviteAdmin.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneActiviteAdminController oneEvent= fxmlLoader.getController();
                oneEvent.setData(events.get(i));

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
