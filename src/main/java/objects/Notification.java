package objects;


import enumeration.Perform;

import java.sql.Date;
import java.sql.Time;

public class Notification {
    private int idNotification, idNotes;
    private Perform perform;
    private Date date;
    private Time time;

    public Notification() {
        super();
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getIdNotes() {
        return idNotes;
    }

    public void setIdNotes(int idNotes) {
        this.idNotes = idNotes;
    }

    public Perform getPerform() {
        return perform;
    }

    public void setPerform(Perform perform) {
        this.perform = perform;
    }

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
}
