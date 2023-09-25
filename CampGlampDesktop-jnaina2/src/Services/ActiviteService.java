/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.mysql.jdbc.Connection;
import entites.Activite;
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
 * @author ACER
 */
public class ActiviteService {
     Connection cnx;

    public ActiviteService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
    /*CRUD */
    
    public void ajouterActivite(Activite a){
        String sql="INSERT INTO `Activite`(`idActivite`, `nomActivite`,`typeActivite`,`prixActivite`,`video`) VALUES ('"+a.getIdActivite()+"','"+a.getNomActivite()+"','"+a.getTypeActivite()+"','"+a.getPrixActivite()+"','"+a.getVideo()+"')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Activite Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
   
      /*2 ème méthode d'ajouter des données */
    /*  public void ajouterActivite2 (Activite a){
        String sql="insert into activite (nom,prix) values(?,?)";
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
             ste.setString(1, a.getNom());
             ste.setInt(2, a.getPrix());
             ste.executeUpdate();
            System.out.println("Activite  Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
     
      public List<Activite> afficherActivite(){
        List<Activite> list = new ArrayList<>();
        String query="select * from activite";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Activite a = new Activite();
                a.setIdActivite(rs.getInt("idActivite"));
                a.setNomActivite(rs.getString("nomActivite"));
                a.setTypeActivite(rs.getNString("typeActivite"));
                a.setPrixActivite(rs.getInt("prixActivite"));
                a.setVideo(rs.getString("video"));
                a.setNbparticipant(rs.getInt("nombre de participants"));
                list.add(a);
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
        
    }
      
      /* suppression des données */
        public boolean cancelActivite( Activite a) {
        String request = "DELETE FROM activite  where idActivite=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(request);
            pst.setInt(1, a.getIdActivite());
            pst.executeUpdate();
            System.out.println("Activite  Canceled");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
       /* modifier les données */
       public void ModifierActivite(Activite a){
        String sql="update activite set  nomActivite=? ,typeActivite=?,prixActivite=?, video=? where idActivite='" + a.getIdActivite() + "'";;
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
              ste.setString(1, a.getNomActivite());
              ste.setString (2,a.getTypeActivite());
              ste.setInt(3,a.getPrixActivite());
              ste.executeUpdate();
            System.out.println("Activite modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       /*rechercher activite*/          
       public List<Activite> rechercherActivite(Activite a){
        List<Activite> activités = new ArrayList<>();
        String query="select * from activite where idActivite='" + a.getIdActivite()+ "'";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                Activite ac = new Activite ();
                ac.setIdActivite(rs.getInt("idActivite"));
                ac.setNomActivite(rs.getString("nomActivite"));
                ac.setTypeActivite(rs.getNString("typeActivite"));
                ac.setPrixActivite(rs.getInt("prixActivite"));
                ac.setVideo(rs.getString("video"));
                activités.add(a);
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return activités;
        
    }
       
}

    
    

