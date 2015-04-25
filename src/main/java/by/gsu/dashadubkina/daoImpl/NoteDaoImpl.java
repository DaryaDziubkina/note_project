package by.gsu.dashadubkina.daoImpl;


import by.gsu.dashadubkina.dao.NoteDao;
import by.gsu.dashadubkina.objects.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("NoteDao")
public class NoteDaoImpl implements NoteDao {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public long createNote(Note note) {
        getSession().save(note);
        return note.getId();
    }

    public Note getNote(long id) {
        return (Note) getSession().get(Note.class, id);
    }

    public void deleteNote(long id) {
        Note note = (Note) getSession().get(Note.class, id);
        getSession().delete(note);
    }

    public void updateNote(Note note) {
        getSession().saveOrUpdate(note);
    }

    public List<Note> getAll() {
        return getSession().createQuery("FROM Note").list();
    }
}
