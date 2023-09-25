/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class Detailler_ActiController implements Initializable {

    @FXML
    private AnchorPane Dashboradadmin;
    @FXML
    private Button btn_activite;
    @FXML
    private Slider volume;
    
     @FXML
    private MediaView mediaview;
    private MediaPlayer mediaPlayer;
    private Media media;
    @FXML
   
    private FileChooser fileChooser;
    private FileChooser.ExtensionFilter filter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String path= new File("src/GUI/vidéo/ZAGHOUAN ,TYROLIENNE .mp4").getAbsolutePath();
        media = new Media( new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaview.setMediaPlayer(mediaPlayer);
        volume.setValue(mediaPlayer.getVolume()*100);
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                 mediaPlayer.setVolume(volume.getValue()/100);
            }
        
            
         
       });
    }    
       

    @FXML
    private void GestionActivite(ActionEvent event) {
    }

    @FXML
    private void play(ActionEvent event) {
    }

    @FXML
    private void stop(ActionEvent event) {
    }

    @FXML
    private void pause(ActionEvent event) {
    }

    @FXML
    private void openFichier(ActionEvent event) {
    }

    @FXML
    private void quitter(ActionEvent event) {
    }

    @FXML
    private void add_event(MouseEvent event) {
    }
    
}
