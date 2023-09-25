/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventPersoService;
import Services.EventService;
import entites.EventPerso;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class EventCreate_FrontController implements Initializable {

    @FXML
    private TextField tf_desc;
    @FXML
    private TextField tf_loc;
    @FXML
    private TextField tf_price;
    @FXML
    private TextField tf_nom;
    @FXML
    private Button btn_create;
    @FXML
    private Button btn_back;
    @FXML
    private DatePicker date_picker;
    @FXML
    private ChoiceBox<String> type;

    
    EventPersoService eventpersoService = new EventPersoService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> types = FXCollections.observableArrayList("RANDONNEE", "CAMPING","GLAMPING");
        type.getItems().clear();
        type.setItems(types);
        type.setValue("RANDONNEE");
    }    

    @FXML
    private void createPEvent(ActionEvent event) {
     
        EventPerso ie=new EventPerso();
       // ie.setIdClient(Integer.parseInt(idClient.getText()));
       // ie.setIdExam(this.ex.getIdE());
        ie.setNom(this.tf_nom.getText());
        ie.setDesc(this.tf_desc.getText());
        ie.setLocation(this.tf_loc.getText());
        
        Date date = Date.valueOf(date_picker.getValue());
        ie.setDate(date);
    
        ie.setType(this.type.getValue());
        ie.setPrix(Integer.valueOf(tf_price.getText()));
        ie.setIdUser(2);
        System.out.println(ie.toString());
        if(eventpersoService.addEventPerso(ie))
        {
           
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("the personnel event  "+tf_nom.getText()+" is created successfully");
            alert.show();
            
        
           Parent page1 = null;
        try {
            page1= FXMLLoader.load(getClass().getResource("/GUI/EventCreate_Front.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(EventCreate_FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
        }
        else
            System.out.println("whel lenna");
            /////////////////////////
    }

    @FXML
    private void GOBack(ActionEvent event) {
        
        Stage s=(Stage)btn_back.getScene().getWindow();
        s.close();
    }
    
}
