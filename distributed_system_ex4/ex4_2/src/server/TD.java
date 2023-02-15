package server;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TD implements Serializable{
    private String TDId;
    private Date begin;
    private Date end;
    private String title;
    private User creator;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    public TD(String TDId, Date begin, Date end, String title, User creator) {
        this.TDId = TDId;
        this.begin = begin;
        this.end = end;
        this.title = title;
        this.creator = creator;
    }

    public String getTDId() {
        return TDId;
    }

    public void setTDId(String TDId) {
        this.TDId = TDId;
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
                "meeId='" + TDId + '\'' + "£¬\n"+
                "begin=" + simpleDateFormat.format(begin) +"£¬\n"+
                "end=" + simpleDateFormat.format(end) +"£¬\n"+
                "title='" + title + '\'' +"£¬\n"+
                "creator='" + creator.getName() + '\'' +"£¬\n"+
                '}';
    }
}
