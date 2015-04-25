package by.gsu.dashadubkina.objects;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity
@Table(name = "notifications")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Notification extends Entity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_notification", unique = true, nullable = false, length = 10)
    public Date DateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_notes", nullable = false)
    private Note note;

    public Notification() {
        super();
    }


    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
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
