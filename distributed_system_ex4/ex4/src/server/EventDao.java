package server;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface EventDao {

    String addEvent(String username, String password, Date begin,
                           Date end, String title) throws ParseException, RemoteException;



    Event deleteEvent(String eventId)throws RemoteException;

    void clearEvent(List<Event> oldEvent)throws RemoteException;

    List<Event> getEventList()throws RemoteException;
}
