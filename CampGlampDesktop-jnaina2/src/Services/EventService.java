/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.mysql.jdbc.Connection;
import entites.Event;
import entités.Utilisateurs;
import enums.EventStatus;
import enums.EventType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Services.Utilisateurservices;  
import tools.MaConnexion;

/**
 *
 * @author ACER
 */
public class EventService {

     private static EventService instance;
    private Statement st;
    private ResultSet rs;
    public static List<Event> displayActualite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection cnx;

    public EventService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
     Utilisateurservices us= new Utilisateurservices();
     
      public boolean addEvent(Event e) {

        String request = "INSERT INTO event ( name, description, type, location, date, payant, prix, status, idCentre)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setString(1, e.getName());
            pst.setString(2, e.getDescription());
            pst.setString(3, e.getType().toString());
            pst.setString(4, e.getLocation());
            pst.setDate(5, e.getDate());
            pst.setBoolean(6, e.isPayant());
            pst.setDouble(7,e.getPrix());
            pst.setInt(8, 2); // 2 PROGRAMEE// 1 FINI
            pst.setInt(9, 14);
            pst.executeUpdate();

            System.out.println("Evenement Ajouté");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
       
      }
      
       public boolean updateEvent(Event e) {
        String request = "UPDATE event SET  name=?, description=?, type=?, location=?, date=?, payant=?, prix=?, status=? idCentre=? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setString(2, e.getName());
            pst.setString(3, e.getDescription());
            pst.setString(4, e.getType());
            pst.setString(5, e.getLocation());
            pst.setDate(6, e.getDate());
            pst.setBoolean(7, e.isPayant());
            pst.setDouble(8,e.getPrix());
            pst.setString(9, e.getStatus());
            pst.setInt(10, e.getId());
             pst.setInt(11, e.getId());
            pst.executeUpdate();

            System.out.println("Evenement modifié");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }
    
       public boolean cancelEvent(Event e) {
        String request = "DELETE FROM event where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
            System.out.println("Evenement supprimé");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
       public List<Event> getAll() {
        List<Event> myList = new ArrayList<>();
        String request = "SELECT * FROM event";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType((rs.getString("type")));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus((rs.getString("status")));
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }

       public Event getEvent(int id) {
        String request = "select * from event where id=" + id;
        Statement st;
        try {

            st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(request);
            rs.last();
            int nb = rs.getRow();
            rs.beforeFirst();
            if (nb != 0) {
                rs.next();
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType(rs.getString("type"));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus(rs.getString("status"));

                return e;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         return null;
    }
       
       
       public boolean utilisateursParticipation(Event e, Utilisateurs u) {
        String request = "INSERT INTO event_user (idUser,eventid)"
                + " VALUES (?,?)";

        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setInt(1, u.getIdUser());
            pst.setInt(2, e.getId());

            pst.executeUpdate();

            System.out.println("User participate in Event : " + e.getName());

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public boolean utilisateursParticipationCancel(Event e, Utilisateurs u) {

        String request = "DELETE FROM event_user where idUser=? and eventid=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setInt(1, u.getIdUser());
            pst.setInt(2, e.getId());
            pst.executeUpdate();
            System.out.println("User Participation Canceled from Event : " + e.getName());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        /*les fonctionnalitée */
        // number des events
         public int numberOfEventsAdmin(int Glamperid) {
         int numberOfEvents = 0;
        String request = "SELECT * FROM event where idUser="+Glamperid;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
              numberOfEvents++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numberOfEvents;
    }
         //2- revenu par event
        public double incomePerEvent( int eventid) {
        Event e = getEvent(eventid);
        if(e.isPayant())
        {
            int participants = numberOfParticipants(e.getId());
        return  e.getPrix()*participants;
        }
        
        return 0;
        
    }
        
        //3-number de participants 
         public int numberOfParticipants( int eventid) {
         int numberOfParticipants = 0;
        String request = "SELECT * FROM event_user where eventid="+eventid;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
              numberOfParticipants++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numberOfParticipants;
    }
         
         //4- revenu total des events
         
          public double totalIncome(int Glamperid) {
        
          List<Event> myList = new ArrayList<>();
             // Utilisateurservices us= new Utilisateurservices();
                  double totalIncome=0;

        String request = "SELECT * FROM event where idUser="+Glamperid;
        Statement st;
        try {
              st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType((rs.getString("type")));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus((rs.getString("status")));
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        for (Event event : myList) {
            double incomePerEvent = incomePerEvent( event.getId());
            totalIncome+=incomePerEvent;
        }
        
        
        return totalIncome;
    }
          
     /* affichage de statistics*/
          
      public List<Event> getAll(int Glamper) {
      List<Event> myList = new ArrayList<>();
       Utilisateurservices us= new Utilisateurservices();
        String request = "SELECT * FROM event where idUser="+Glamper;
        Statement st;
        try {
             st = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType((rs.getString("type")));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus((rs.getString("status")));
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }
     /////////////////////////////////////////////::::
      
      
      public List<Event> getAllSortedASC() {
        List<Event> myList = new ArrayList<>();
        String request = "SELECT * FROM event order by date asc";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType((rs.getString("type")));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus((rs.getString("status")));
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }
      
      public List<Event> getAllSortedDESC() {
        List<Event> myList = new ArrayList<>();
        String request = "SELECT * FROM event order by date desc";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType((rs.getString("type")));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus((rs.getString("status")));
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }
      
      
       public List<Event> getAllFiltred(String str) {
        List<Event> myList = new ArrayList<>();
        String request = "select * from event where type like '%"+str+"%'";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request);
            while (rs.next()) {
                Event e = new Event();
                e.setId(rs.getInt(1));
                e.setUser(us.getUser(1));
                e.setName(rs.getString("name"));
                e.setDescription(rs.getString("description"));
                e.setType((rs.getString("type")));
                e.setLocation(rs.getString("location"));
                e.setDate(rs.getDate("date"));
                e.setPayant(rs.getBoolean("payant"));
                e.setPrix(rs.getDouble("prix"));
                e.setStatus((rs.getString("status")));
                myList.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return myList;
    }

}



        