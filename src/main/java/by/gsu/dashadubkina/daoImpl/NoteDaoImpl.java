package by.gsu.dashadubkina.daoImpl;


import by.gsu.dashadubkina.dao.NoteDao;
import by.gsu.dashadubkina.objects.Note;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class NoteDaoImpl implements NoteDao{

    private Session session;

    public NoteDaoImpl(Session session) {
        this.session = session;
    }

    public long createNote(Note note) {
        note.setDateTime(new Date());
        note.setTopic("me");
        session.save(note);
        return note.getId();

    }

    public void changeNote(Note note) {

    }

    public void deleteNote(Note note) {

    }

    public void updateNote(Note note) {

    }
}
