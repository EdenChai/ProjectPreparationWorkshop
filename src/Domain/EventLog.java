package Domain;

import java.sql.Time;
import java.util.Date;

/**
 * @author Eden_Hai
 * @version 1.0
 * @since 02-05-2022
 */
public class EventLog
{
    private Date date;
    private Time time;
    private String minute;
    private String description;
    private Event event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
