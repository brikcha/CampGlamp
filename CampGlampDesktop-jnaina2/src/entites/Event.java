
package entites;

import entités.Utilisateurs;
import java.sql.Date;
import enums.EventType;
import enums.EventStatus;
/**
 *
 * @author ACER
 */
public class Event {
    private int id;
    private String name;
    private String description;
    private String type;
    private String location;
    private Date date;
    private boolean payant;
    private double prix;
    private String status;
   // private int idCentre;
    private Utilisateurs user;

    public Event() {
    }

    public Event(int id, String name, String description, String type, String location, Date date, boolean payant, double prix, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.location = location;
        this.date = date;
        this.payant = payant;
        this.prix = prix;
        this.status = status;
       // this.idCentre= idCentre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPayant() {
        return payant;
    }

    public double getPrix() {
        return prix;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayant(boolean payant) {
        this.payant = payant;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*public int getIdCentre() {
        return idCentre;
    }*/

    public Utilisateurs getUser() {
        return user;
    } 

    public void setUser(Utilisateurs user) {
        this.user = user;
    }
    

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ", location=" + location + ", date=" + date + ", payant=" + payant + ", prix=" + prix + ", status=" + status + '}';
    }
    

   
    
    

}
