/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ActiviteService;
import Services.EventService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Activite;
import entites.Event;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class AdminActivCController implements Initializable {

    @FXML
    private Pane pan;
    @FXML
    private TextField id_name;
    private TextField description;
    @FXML
    private TextField tf_nbP;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField tf_prix;
    @FXML
    private Button btn_choose;
    @FXML
    private TextField type;
    @FXML
    private FontAwesomeIconView close;
    
     private ArrayList<Activite> eventData =  new ArrayList<>();
    ActiviteService es = new ActiviteService();
    @FXML
    private TextField tf_videoName;
    
    
     private MediaPlayer mediaPlayer;
    private Media media;
    private FileChooser fileChooser;
    private FileChooser.ExtensionFilter filter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void addEvent(MouseEvent event) {
    }

    @FXML
    private void ajouteract(ActionEvent event) {
        
         Activite ie=new Activite();
       // ie.setIdClient(Integer.parseInt(idClient.getText()));
       // ie.setIdExam(this.ex.getIdE());
        ie.setNomActivite(this.id_name.getText());
        ie.setPrixActivite(Integer.valueOf(tf_prix.getText()));
        ie.setTypeActivite(this.type.getText());
        ie.setNbparticipant(Integer.valueOf(tf_nbP.getText()));
        ie.setVideo(tf_videoName.getText());
        
        //;
        System.out.println(ie.toString());
        es.ajouterActivite(ie);
       Stage stagea = (Stage) this.btn_ajouter.getScene().getWindow();
              stagea.close();
              
            //////notificationnnnnnn  
            Notifications.create()
                 .title("Ajouter activite ")
                 .text("activite  << "+id_name.getText()+" >>est ajouté avec success")
                 .darkStyle().position(Pos.BOTTOM_RIGHT).showConfirm();
             //////notificationnnnnnn  
    }

    @FXML
    private void choosefile(ActionEvent event) throws MalformedURLException {
        
         fileChooser= new FileChooser();
      filter = new FileChooser.ExtensionFilter("choisir un vidéo:", "*.mp4");
      fileChooser.setSelectedExtensionFilter(filter);
      File file = fileChooser.showOpenDialog(null);
      if(file !=null)
          //mediaPlayer.stop();
          media = new Media(file.toURI().toURL().toExternalForm());
          mediaPlayer = new MediaPlayer(media);
         // media_view.setMediaPlayer(mediaPlayer);
         tf_videoName.setText(file.toURI().toURL().toString());
    }

    @FXML
    private void close(MouseEvent event) {
        Stage s=(Stage)close.getScene().getWindow();
        s.close();
    }
    
}
