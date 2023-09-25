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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class OneAdminEventController implements Initializable {

    @FXML
    private Text td_date;
    @FXML
    private Text tf_name;
    @FXML
    private Text tf_desc;
    @FXML
    private Text tf_type;
    @FXML
    private Text tf_location;
    @FXML
    private Text tf_prix;
    @FXML
    private FontAwesomeIconView delete;
    
    private Event ev;
    EventService es = new EventService();
    @FXML
    private FontAwesomeIconView Mod;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deletePerso(MouseEvent event) {
        this.es.cancelEvent(ev);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("event supprimée avec succés!");
        alert.show();
        
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/OneAdminEvent.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(List_evenements_adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               List_evenements_adminController fev=Loader.getController();
               
               fev.afficheall();
                Parent p=Loader.getRoot();
                Stage frontView ;
               
                    frontView= (Stage) ((Node) ((MouseEvent)event).getSource()).getScene().getWindow();
                
                Scene scene = new Scene(p);
                frontView.setScene(scene);
                frontView.show(); 
    }
    
    public void setData(Event e) {
         this.ev=e;
        tf_name.setText(e.getName());
        tf_desc.setText(e.getDescription());
        tf_prix.setText(String.valueOf(e.getPrix()));
        tf_type.setText(e.getType().toString());
        tf_location.setText(e.getLocation());
        td_date.setText(e.getDate().toString());
      
    }

    @FXML
    private void ModeEvent(MouseEvent event) {
    }
    
}
