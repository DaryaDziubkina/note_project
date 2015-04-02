package objects;


import enumeration.Perform;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "notifications")
public class Notification  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private long idNotification;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notes")
    private long idNotes;
    @Column(name = "perform")
    private Perform perform;
    @Column(name = "date_notification")
    private Date date;
    private Time time;

    public Notification() {
        super();
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
    }

    public long getIdNotes() {
        return idNotes;
    }

    public void setIdNotes(long idNotes) {
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
