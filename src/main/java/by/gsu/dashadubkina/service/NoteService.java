package by.gsu.dashadubkina.service;

import by.gsu.dashadubkina.dao.NoteDao;
import by.gsu.dashadubkina.objects.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public NoteService() {
        super();
    }

    public void createNote(Note note) {
        noteDao.createNote(note);
    }

    public void deleteNote(long id) {
        noteDao.deleteNote(id);
    }

    public void updateNote(Note note) {
        noteDao.updateNote(note);
    }

    public Note getNote(long id) {
        return noteDao.getNote(id);
    }

    public List<Note> getAll() {
        return noteDao.getAll();
    }
}
