package server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EventDaoImpl implements Serializable, EventDao {

    private List<Event> eventList = new ArrayList<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    /**
     * add the event for the user
     * @param username user name
     * @param password user password
     * @param begin begin date
     * @param end end date
     * @param title event title
     * @return the event id
     * @throws ParseException ParseException
     * @throws RemoteException RemoteException
     */
    @Override
    public String addEvent(String username, String password, Date begin, Date end, String title) throws ParseException, RemoteException {

        String eventId = getUUID();
        Event event = new Event(eventId, begin, end, title, new User(username, password));
        eventList.add(event);
        return event.getEventId();

    }

    /**
     * delete the event for the user
     * @param eventId event id
     * @return the deleted event
     * @throws RemoteException RemoteException
     */
    @Override
    public Event deleteEvent(String eventId) throws RemoteException {
        Event event = getEventById(eventId);

        if(event != null) {
            eventList.remove(event);
        }
        return event;
    }

    /**
     * clear all the event
     * @param oldEvent oldEvent
     * @throws RemoteException RemoteException
     */
    @Override
    public void clearEvent(List<Event> oldEvent) throws RemoteException {
        if(oldEvent == null || oldEvent.size() == 0)return;
        for(Event event : oldEvent){
            eventList.remove(event);
        }
    }

    /**
     * get all the event
     * @return event list
     * @throws RemoteException RemoteException
     */
    @Override
    public List<Event> getEventList() throws RemoteException {
        return eventList;
    }

    /**
     * find event by event id
     * @param eventId event id
     * @return event
     */
    public Event getEventById(String eventId){
        if(eventList == null) return null;
        for(Event event : eventList){
            if(event.getEventId().equals(eventId))return event;
        }
        return null;
    }

    /**
     * find events by user name
     * @param username user name
     * @return the event list belonged to user
     */
    public List<Event> getEventsByUser(String username){
        if(eventList == null) return null;
        List<Event> res = new ArrayList<>();

        for(Event event : eventList){
            if(event.getCreator().getName().equals(username))res.add(event);
        }

        return res;
    }


    /**
     * generate the identity id
     * @return the id
     */
    public static String getUUID() {

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return uuidStr;
    }
}
