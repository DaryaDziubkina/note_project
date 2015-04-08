package by.gsu.dashadubkina.dao;


import by.gsu.dashadubkina.objects.Note;

public interface NoteDao {

    long createNote(Note note);
    void changeNote(Note note);
    void deleteNote(Note note);
    void updateNote(Note note);

}
