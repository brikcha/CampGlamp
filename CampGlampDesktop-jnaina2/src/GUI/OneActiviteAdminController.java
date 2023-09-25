/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entites.Activite;
import entites.Event;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * 
 * @author ACER 
 */
public class OneActiviteAdminController implements Initializable {
private Activite ev;
    @FXML
    private MediaView media_view;
    @FXML
    private FontAwesomeIconView play;
    @FXML
    private FontAwesomeIconView pause;
    @FXML
    private FontAwesomeIconView stop;
    @FXML
    private Text nom_act;
    @FXML
    private Text prix_act;
    @FXML
    private Text nbrep_act;
    @FXML
    private Text type_act;
    @FXML
    private Slider slider;
    
    
     private MediaPlayer mediaPlayer;
    private Media media;
    private FileChooser fileChooser;
    private FileChooser.ExtensionFilter filter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setData(Activite e) {
         this.ev=e;
        nom_act.setText(e.getNomActivite());        
        prix_act.setText(String.valueOf(e.getPrixActivite()));
        type_act.setText(e.getTypeActivite());
        nbrep_act.setText(String.valueOf(e.getNbparticipant()));
        
        String path = new File("C:\\Users\\ACER\\Desktop\\PIValidationFinal\\PIY\\PIY\\PiProjet\\src\\GUI\\vidéo\\"+e.getVideo()).getAbsolutePath();
        media =new Media(new File(path).toURI().toString());
        mediaPlayer=new MediaPlayer(media);
        media_view.setMediaPlayer(mediaPlayer);
        
        slider.setValue(mediaPlayer.getVolume()*100);
        slider.valueProperty().addListener(new InvalidationListener() {
          @Override
          public void invalidated(Observable observable) {
              mediaPlayer.setVolume(slider.getValue()/100);
          }
      });
      
    }

    @FXML
    private void playMedia(MouseEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void pauseMedia(MouseEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void stopMedia(MouseEvent event) {
        mediaPlayer.stop();
    }
}
