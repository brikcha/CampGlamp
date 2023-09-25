/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventService;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Event;
import enums.EventType;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class List_evenements_adminController implements Initializable {

    @FXML
    private AnchorPane Dashboradadmin;
    @FXML
    private Button btn_event;
    @FXML
    private Label txtUsername;
    private ListView<Event> listOfEvents;
    private TextField event_Name;
    private Pane pan;

    private ObservableList<Event> eventData = FXCollections.observableArrayList();
    EventService es = new EventService();

    private TextField id_name;
    private TextField description_a_jour;
    private TextField lieu_a_jour;
    private ComboBox<String> type_a_jour;
    private DatePicker date_a_jour;
    private ComboBox<String> statut_a_jour;
    private CheckBox payant_a_jour;
    private CheckBox gratuit_a_jour;
    private TextField prix_a_jour;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Button btn_creerPerso;
    @FXML
    private FontAwesomeIconView refrech;
    @FXML
    private Button btn_Act;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        
        
    }

    @FXML
    private void GestionEvent(ActionEvent event) {
    }



    @FXML
    private void creerEvent(ActionEvent event) {
        
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/AdminEventC.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(AdminEventCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
              
               AdminEventCController aRC=Loader.getController();
                
              
                Parent p=Loader.getRoot();
                Stage comm=new Stage();
                Scene scene = new Scene(p);
                comm.initStyle(StageStyle.TRANSPARENT);
                comm.setScene(scene);
                comm.show();
    }
    
     public void afficheall(){
         
    List<Event> events = new ArrayList<Event>();
        events = es.getAll();
  
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i <events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/OneAdminEvent.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                OneAdminEventController oneEvent= fxmlLoader.getController();
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
    private void refrech(MouseEvent event) {
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
               
                    frontView= (Stage) ((Node) ((MouseEvent)event).getSource()).getScene().getWindow();
                
                Scene scene = new Scene(p);
                frontView.setScene(scene);
                frontView.show(); 
    }

    @FXML
    private void GestionAct(ActionEvent event) {
         FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("/GUI/list_Activites_admin.fxml"));
        try {
            Loader.load();  
        } catch (IOException ex) {
            Logger.getLogger(List_evenements_adminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               List_activites_adminController fev=Loader.getController();
               
               fev.afficheall();
                Parent p=Loader.getRoot();
                Stage frontView ;
               
                    frontView= (Stage) ((Node) ((ActionEvent)event).getSource()).getScene().getWindow();
                
                Scene scene = new Scene(p);
                frontView.setScene(scene);
                frontView.show(); 
    }

}
