package objects;


import enumeration.Importance;

import java.sql.Date;
import java.sql.Time;

public class Note {
    private int idNote, idAuthor;
    private String topic;
    private String text;
    private Date date;
    private Time time;
    private Importance importance;

    public Note(){
        super();
    }

    public int getIdNote() {
        return idNote;
    }


    public void setIdNote(int idNote) {

        this.idNote = idNote;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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

    public Importance getImportance() {
        return importance;
    }

}
