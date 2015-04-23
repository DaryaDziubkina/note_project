package by.gsu.dashadubkina.dao;


import by.gsu.dashadubkina.objects.Note;

import java.util.List;

public interface NoteDao {

    long createNote(Note note);

    Note getNote(long id);

    void deleteNote(long id);

    void updateNote(Note note);

    List<Note> getAll();

}
