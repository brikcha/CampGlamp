/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.mysql.jdbc.Connection;
import entites.Event;
import entites.EventPerso;
import enums.EventType;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MaConnexion;

/**
 *
 * @author mahdi
 */
public class EventPersoService {
    
    private static EventService instance;
    private Statement st;
    private ResultSet rs;
    public static List<Event> displayActualite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection cnx;
    
    public EventPersoService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
    
    public List<EventPerso> getAll() {
        List<EventPerso> myList = new ArrayList<>();
        // hedhy thootha kif tzidou tziidou el gestion user w tejbed ken event mta3 user wehed 
        //String request = "SELECT * FROM EventPerso where iduser= id  ";
        String request = "SELECT * FROM eventperso ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                EventPerso e = new EventPerso();
                e.setIdEP(rs.getInt(1));
                e.setIdUser(rs.getInt("iduser"));
                e.setNom(rs.getString("nom"));
                e.setDesc(rs.getString("description"));
                e.setType(rs.getString("type"));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                
                e.setPrix(rs.getInt("prix"));
            
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventPersoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }
    
    public boolean addEventPerso(EventPerso e) {
       e.toString();
        //String request = "insert into eventperso ( nom , desc, date, location, prix, type, iduser " + " values (?,?,?,?,?,?,?)";
        String req = "insert into eventperso (nom, description , date, location, prix, type, iduser) " + " values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getDesc());
            pst.setDate(3, e.getDate());
            pst.setString(4, e.getLocation());
            pst.setInt(5,e.getPrix());
            pst.setString(6, e.getType());
            pst.setInt(7,e.getIdUser());
           
            
            pst.executeUpdate();

            System.out.println("Evenement Perso Ajouté");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EventPersoService.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
       
      }
    
    
     public boolean cancelEventPerso(EventPerso e) {
        String request = "DELETE FROM eventperso where idep=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setInt(1, e.getIdEP());
            pst.executeUpdate();
            System.out.println("Evenement perso supprimé");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
     
     
      public boolean updateEvent(EventPerso e) {
        String request = "UPDATE event SET  nom=?, desc=?, date=?, location=?, prix=?, type=?, prix=?, iduser=? ";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getDesc());
            pst.setDate(3, e.getDate());
            pst.setString(4, e.getLocation());
            pst.setString(5,String.valueOf( e.getPrix()));
            pst.setString(6, e.getType().toString());
            //pst.setString(6, "1");
            pst.executeUpdate();

            System.out.println("EvenementPerso modifié");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }
    
}
