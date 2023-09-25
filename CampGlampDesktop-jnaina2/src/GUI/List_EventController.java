/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventService; 
import com.jfoenix.controls.JFXCheckBox;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import entites.Event;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class List_EventController implements Initializable {

    @FXML
    private Label Username;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Button btn_PersoList;
    @FXML
    private Button btn_creerPerso;
    @FXML
    private JFXCheckBox ck_all;
    @FXML
    private JFXCheckBox ck_rando;
    @FXML
    private JFXCheckBox ck_camp;
    @FXML
    private JFXCheckBox ck_glamp;
    @FXML
    private Button btn_event;
    @FXML
    private Button btn_activ;
    
     private ArrayList<Event> eventData =  new ArrayList<>();
    EventService es = new EventService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void Logout(ActionEvent event) {
    }

    @FXML
    private void ModifierComptes(ActionEvent event) {
    }

    @FXML
    private void AfficherPubs(ActionEvent event) {
    }

    @FXML
    private void listRéservations(ActionEvent event) {
    }

    @FXML
    private void MesCommandes(ActionEvent event) {
    }
    
    public void afficheall(){
         
    List<Event> events = new ArrayList<Event>();
        events = es.getAll();
        System.out.println(events);
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneEvent_Front.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneEvent_FrontController oneEvent= fxmlLoader.getController();
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
    public void afficheallFiltred(String s){
         
    List<Event> events = new ArrayList<Event>();
        events = es.getAllFiltred(s);
  
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneEvent_Front.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneEvent_FrontController oneEvent= fxmlLoader.getController();
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
    
    

    @FXML
    private void sortedEvent_ASC(MouseEvent event) {
        List<Event> events = new ArrayList<Event>();
        events = es.getAllSortedASC();
  
        //System.out.println(events.toString());
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneEvent_Front.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneEvent_FrontController oneEvent= fxmlLoader.getController();
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

    @FXML
    private void sortedEvent_DESC(MouseEvent event) {
        List<Event> events = new ArrayList<Event>();
        events = es.getAllSortedDESC();
  
        //System.out.println(events.toString());
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneEvent_Front.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneEvent_FrontController oneEvent= fxmlLoader.getController();
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

    @FXML
    private void ListPersoEvent(ActionEvent event) {
        
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/EventPerso.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(EventCreate_FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ////////
              
               EventPersoController aRC=Loader.getController();
                aRC.displayall();
              
                Parent p=Loader.getRoot();
                Stage comm=new Stage();
                Scene scene = new Scene(p);
                comm.initStyle(StageStyle.TRANSPARENT);
                comm.setScene(scene);
                comm.show();
    }

    @FXML
    private void creerEventPerso(ActionEvent event)  throws MessagingException{
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/EventCreate_Front.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(EventCreate_FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
              
               EventCreate_FrontController aRC=Loader.getController();
                
              
                Parent p=Loader.getRoot();
                Stage comm=new Stage();
                Scene scene = new Scene(p);
                comm.initStyle(StageStyle.TRANSPARENT);
                comm.setScene(scene);
                comm.show();
    }

   

   

    @FXML
    private void disALL(MouseEvent event) {
        ck_all.setSelected(true);
        ck_camp.setSelected(false);
        ck_rando.setSelected(false);
        ck_glamp.setSelected(false);
        this.afficheall();
    }

    @FXML
    private void disRAND(MouseEvent event) {
        ck_all.setSelected(false);
        ck_camp.setSelected(false);
        ck_rando.setSelected(true);
        ck_glamp.setSelected(false);
        this.memepage(event, ck_rando.getText());
    }

    @FXML
    private void disCAMP(MouseEvent event) {
         ck_all.setSelected(false);
        ck_camp.setSelected(true);
        ck_rando.setSelected(false);
        ck_glamp.setSelected(false);
        this.memepage(event, ck_camp.getText());
    }

    @FXML
    private void disGlamp(MouseEvent event) {
         ck_all.setSelected(false);
        ck_camp.setSelected(false);
        ck_rando.setSelected(false);
        ck_glamp.setSelected(true);
        this.memepage(event, ck_glamp.getText());
    }
    public void memepage(Object event,String s)
    {
        
        grid.getChildren().clear();
        
         List<Event> events = new ArrayList<Event>();
        events = es.getAllFiltred(s);
        if(events.size()!=0){
            int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneEvent_Front.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneEvent_FrontController oneEvent= fxmlLoader.getController();
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
        }else
        {
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("there is no event  with type "+s );
            alert.show();
        }
        
    }

    @FXML
    private void GOEvents(ActionEvent event) {
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/List_Event.fxml"));
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
        Loader.setLocation(getClass().getResource("/GUI/List_Activite.fxml"));
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

    @FXML
    private void GoAdmin(ActionEvent event) {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/list_evenements_admin.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(List_evenements_adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               List_evenements_adminController fev=Loader.getController();
               
               fev.afficheall();
                Parent p=Loader.getRoot();
                Stage frontView ;
               
                    frontView= (Stage) ((Node) ((ActionEvent)event).getSource()).getScene().getWindow();
                
                Scene scene = new Scene(p);
                frontView.setScene(scene);
                frontView.show(); 
    }
    
    
}