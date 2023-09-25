/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventPersoService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Event;
import entites.EventPerso;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class OneEventPersoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private EventPerso ev;
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
    private Text td_date;
    @FXML
    private FontAwesomeIconView delete;
    @FXML
    private FontAwesomeIconView share;
    
    EventPersoService es = new EventPersoService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //this.setData
    }   
    public void setData(EventPerso e) {
         this.ev=e;
        tf_name.setText(e.getNom());
        tf_desc.setText(e.getDesc());
        tf_prix.setText(String.valueOf(e.getPrix()));
        tf_type.setText(e.getType());
        tf_location.setText(e.getLocation());
        td_date.setText(e.getDate().toString());
      
    }

    @FXML
    private void deletePerso(MouseEvent event) {
       this.es.cancelEventPerso(ev);
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("event supprimée avec succés!");
        alert.show();
        
           Parent page1 = null;
        try {
            page1= FXMLLoader.load(getClass().getResource("/GUI/EventPerso.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(EventPersoController.class.getName()).log(Level.SEVERE, null, ex);
        }
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
       
        
    }

    @FXML
    private void sharePerso(KeyEvent event) {
    }
    
}
