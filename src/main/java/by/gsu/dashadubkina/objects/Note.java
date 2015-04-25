package by.gsu.dashadubkina.objects;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "notes")
public class Note extends Entity {

    @ManyToOne(fetch = FetchType.EAGER)
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

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }
}
