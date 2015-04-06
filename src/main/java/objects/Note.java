package objects;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private long idNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_author", nullable = false)
    private User author;

    @Column(name = "topic_name", nullable = false)
    private String topic;

    @Column(name = "text")
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "datetime_reminder", unique = true, nullable = false, length = 10)
    public Date DateTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
    private Set<Notification> notifications;


    public Note() {
        super();
    }

    public long getIdNote() {
        return idNote;
    }

    public void setIdNote(long idNote) {
        this.idNote = idNote;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }
}
