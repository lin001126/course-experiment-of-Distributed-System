package server;



import javax.xml.ws.WebServiceRef;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Serializable{
    private String eventId;
    private Date begin;
    private Date end;
    private String title;
    private User creator;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    public Event(String eventId, Date begin, Date end, String title, User creator) {
        this.eventId = eventId;
        this.begin = begin;
        this.end = end;
        this.title = title;
        this.creator = creator;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


    @Override
    public String toString() {
        return "MeetingImpl{\n" +
                "meeId='" + eventId + '\'' + "£¬\n"+
                "begin=" + simpleDateFormat.format(begin) +"£¬\n"+
                "end=" + simpleDateFormat.format(end) +"£¬\n"+
                "title='" + title + '\'' +"£¬\n"+
                "creator='" + creator.getName() + '\'' +"£¬\n"+
                '}';
    }
}
