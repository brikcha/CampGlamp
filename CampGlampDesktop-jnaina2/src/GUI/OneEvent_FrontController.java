/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Event;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ACER 
 */
public class OneEvent_FrontController implements Initializable {

    @FXML
    private ImageView event_img;
    @FXML
    private Text tf_name;
    @FXML
    private Text tf_type;
    @FXML
    private Text tf_date;
    @FXML
    private Text tf_location;
    @FXML
    private Text tf_desc;
    @FXML
    private Text tf_prix;

    
    private Event ev ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setData(Event e) {
       this.ev=e;
       
       tf_name.setText(ev.getName());
       tf_type.setText(ev.getType().toString());
       tf_desc.setText(ev.getDescription());
       tf_date.setText(ev.getDate().toString());
       tf_location.setText(ev.getLocation());
       tf_prix.setText(String.valueOf(ev.getPrix()));
    }
    
}
