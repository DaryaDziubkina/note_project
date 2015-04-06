package objects;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "notifications")

public class Notification  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private long idNotification;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_notification", unique = true, nullable = false, length = 10)
    public Date DateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_notes", nullable = false)
    private Note note;

    public Notification() {
        super();
    }

    public long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(long idNotification) {
        this.idNotification = idNotification;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
