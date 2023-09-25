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
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class AdminEventCController implements Initializable {

    @FXML
    private Pane pan;
    @FXML
    private ComboBox<String> type_a_jour;
    @FXML
    private DatePicker date_a_jour;
    @FXML
    private ComboBox<String> statut_a_jour;
    @FXML
    private CheckBox payant_a_jour;
    @FXML
    private CheckBox gratuit_a_jour;
    @FXML
    private TextField id_name;
    @FXML
    private TextField description_a_jour;
    @FXML
    private TextField lieu_a_jour;
    @FXML
    private TextField prix_a_jour;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_mod;
    @FXML
    private FontAwesomeIconView close;
    
    private ArrayList<Event> eventData =  new ArrayList<>();
    EventService es = new EventService();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String> types = FXCollections.observableArrayList("RANDONNEE", "CAMPING","GLAMPING");
        type_a_jour.getItems().clear();
        type_a_jour.setItems(types);
        type_a_jour.setValue("RANDONNEE");
        
         ObservableList<String> status = FXCollections.observableArrayList("PROGRAMME", "FINI");
         statut_a_jour.getItems().clear();
         statut_a_jour.setItems(status);
        statut_a_jour.setValue("PROGRAMME");
    }    

    @FXML
    private void ck_clicked(ActionEvent event) {
    }

    @FXML
    private void addEvent(MouseEvent event) {
        
    }

    @FXML
    private void ajouterevent(ActionEvent event) {
        
        Event ie=new Event();
       // ie.setIdClient(Integer.parseInt(idClient.getText()));
       // ie.setIdExam(this.ex.getIdE());
        ie.setName(this.id_name.getText());
        ie.setDescription(this.description_a_jour.getText());
        ie.setLocation(this.lieu_a_jour.getText());
        
        Date date = Date.valueOf(date_a_jour.getValue());
        ie.setDate(date);
    
        ie.setType(this.type_a_jour.getValue());
        ie.setPrix(Integer.valueOf(prix_a_jour.getText()));
        //;
        System.out.println(ie.toString());
        es.addEvent(ie);
       Stage stagea = (Stage) this.btn_ajouter.getScene().getWindow();
              stagea.close();
              
            //////notificationnnnnnn  
            Notifications.create()
                 .title("Ajouter event ")
                 .text("Event  << "+id_name.getText()+" >>est ajouté avec success")
                 .darkStyle().position(Pos.BOTTOM_RIGHT).showConfirm();
             //////notificationnnnnnn  
    }

    @FXML
    private void modificatin(ActionEvent event) {
        
    }

    @FXML
    private void close(MouseEvent event) {
        Stage s=(Stage)close.getScene().getWindow();
        s.close();
    }
    
    

    
    
}
