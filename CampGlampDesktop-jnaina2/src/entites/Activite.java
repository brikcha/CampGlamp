/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author ACER
 */
public class Activite {
    private int idActivite,prixActivite, nbparticipant;
    private String nomActivite,typeActivite,video;

    public void setNbparticipant(int nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    public int getNbparticipant() {
        return nbparticipant;
    }

    public Activite(int idActivite, int prixActivite, int nbparticipant, String nomActivite, String typeActivite, String video) {
        this.idActivite = idActivite;
        this.prixActivite = prixActivite;
        this.nbparticipant = nbparticipant;
        this.nomActivite = nomActivite;
        this.typeActivite = typeActivite;
        this.video = video;
    }

    public Activite() {
    }

    public Activite(int idActivite, int prixActivite, String nomActivite, String typeActivite,String video) {
        this.idActivite = idActivite;
        this.prixActivite = prixActivite;
        this.nomActivite = nomActivite;
        this.typeActivite = typeActivite;
        this.video= video;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public int getPrixActivite() {
        return prixActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public void setPrixActivite(int prixActivite) {
        this.prixActivite = prixActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    @Override
    public String toString() {
        return "Activite{" + "idActivite=" + idActivite + ", prixActivite=" + prixActivite + ", nomActivite=" + nomActivite + ", typeActivite=" + typeActivite + '}';
    }
    
    
    
}
