/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import enums.EventType;
import java.sql.Date;

/**
 *
 * @author ACER
 */
public class EventPerso {
    private int idep,prix,iduser;
    private String nom, desc,location ;
    private Date date;
     private String type;

    public EventPerso() {
    }

     
     
    public EventPerso(int idEP, String nom, String desc, Date date, String location, int prix,String type, int idUser) {
        this.idep = idEP;
        this.prix = prix;
        this.iduser = idUser;
        this.nom = nom;
        this.desc = desc;
        this.location = location;
        this.date = date;
        this.type = type;
    }

    public int getIdEP() {
        return idep;
    }

    public int getPrix() {
        return prix;
    }

    public int getIdUser() {
        return iduser;
    }

    public String getNom() {
        return nom;
    }

    public String getDesc() {
        return desc;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public void setIdEP(int idEP) {
        this.idep = idEP;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setIdUser(int idUser) {
        this.iduser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

   

    @Override
    public String toString() {
        return "EventPerso{" + "idEP=" + idep + ", prix=" + prix + ", nom=" + nom + ", desc=" + desc + ", location=" + location + ", type=" + type + '}';
    }

    public EventPerso(int prix, int iduser, String nom, String desc, String location, Date date, String type) {
        this.prix = prix;
        this.iduser = iduser;
        this.nom = nom;
        this.desc = desc;
        this.location = location;
        this.date = date;
        this.type = type;
    }

   
    
    
    
}
