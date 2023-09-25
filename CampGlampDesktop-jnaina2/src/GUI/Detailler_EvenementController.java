/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventService;
import Services.Utilisateurservices;
import entites.Event;
import entités.Utilisateurs;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class Detailler_EvenementController implements Initializable {
    Event event = new Event();
    
    @FXML
    private AnchorPane Dashboradadmin;
    private ComboBox<String> type;
    private TextField event_name;
    private TextArea event_description;
    private TextField event_location;
    private DatePicker event_date;
    private TextField event_price;
    private ComboBox<String> statut;
    
    EventService eventService = new EventService();
    Utilisateurservices utilisateurservices = new Utilisateurservices();
    private CheckBox ck_payant;
    private CheckBox ck_gratuit;
    @FXML
    private Button Vider;
    @FXML
    private Button btn_activite;
    @FXML
    private Button Add_Activie_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<String> types = FXCollections.observableArrayList("RANDONNEE", "CAMPING","GLAMPING");
        type.getItems().clear();
        type.setItems(types);
        type.setValue("RANDONNEE");
        
         ObservableList<String> status = FXCollections.observableArrayList("PROGRAMME", "FINI");
        statut.getItems().clear();
        statut.setItems(status);
        statut.setValue("PROGRAMME");
        
        event_price.setEditable(false);



    }    


    @FXML
    private void add_event(MouseEvent event) {
         /* Glamper */
        Utilisateurs u = utilisateurservices.getUser(1);
        this.event.setUser(u);
        this.event.setName(event_name.getText());
        if (Double.valueOf(event_price.getText()) == 0) {
            this.event.setPrix(0);
            this.event.setPayant(false);
        } else {
            this.event.setPrix(Double.valueOf(event_price.getText()));
            this.event.setPayant(true);
        }
        Date date = Date.valueOf(event_date.getValue());
        this.event.setDate(date);
        this.event.setDescription(event_description.getText());
        this.event.setType((type.getValue()));
        this.event.setLocation(event_location.getText());
        eventService.addEvent(this.event);
    }
       /*vider les champs*/
    
    private void Delete(ActionEvent event) {
       /*  Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez vous supprimer les détails de l'évènement ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            eventService.cancelEvent(this.event);
            
        }*/
       /*event_description.setText("");
       event_location.setText("");
       event_name.setText("");
       event_price.setText("");
       event_date.setValue(null);
       ck_payant.setSelected(false);
       ck_gratuit.setSelected(false);*/
    }


    private void is_clicked(ActionEvent event) {
        if (ck_payant.isSelected()){
           event_price.setEditable(true); 
           ck_gratuit.setDisable(true);
        }else {
             event_price.setEditable(false);
        }
         
    }

    @FXML
    private void vider(ActionEvent event) {
       event_description.setText("");
       event_location.setText("");
       event_name.setText("");
       event_price.setText("");
       event_date.setValue(null);
       ck_payant.setSelected(false);
       ck_gratuit.setSelected(false);
    }

    @FXML
    private void GestionActivite(ActionEvent event) {
    }

    @FXML
    private void add_Activite(MouseEvent event) {
    }
    
}
