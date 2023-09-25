/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventPersoService;
import Services.EventService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Event;
import entites.EventPerso;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class EventPersoController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private Button clos_btn;
    private ArrayList<EventPerso> eventData =  new ArrayList<>();
    EventPersoService es = new EventPersoService();
    @FXML
    private FontAwesomeIconView close_btn;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    
    public void  displayall()
    {
        List<EventPerso> eventps = new ArrayList<EventPerso>();
        eventps = es.getAll();
  
        //System.out.println(events.toString());
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <eventps.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneEventPerso.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneEventPersoController oneEvent= fxmlLoader.getController();
                oneEvent.setData(eventps.get(i));
                

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

    @FXML
    private void close(MouseEvent event) {
        Stage s=(Stage)close_btn.getScene().getWindow();
        s.close();
    }

    
}
