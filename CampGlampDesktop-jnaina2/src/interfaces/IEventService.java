/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entites.Event;
import entités.Utilisateurs;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface IEventService {
    public boolean addEvent(Event e);
    public boolean updateEvent(Event e);
    public boolean cancelEvent(Event e);
    public List<Event> getAll();
    public List<Event> getAll(int Glamper);
    public Event getEvent(int id);
    
    public boolean userParticipation(Event e,Utilisateurs u);
    public boolean userParticipationCancel(Event e,Utilisateurs u);
    
    
    //Les fonctionnalités:
    
    public int numberOfEventsPodcaster(int Glamperid);
    public double totalIncome(int Glamperid);
    public double incomePerEvent(int eventid);
    public int numberOfParticipants(int eventid);
    
    
}
