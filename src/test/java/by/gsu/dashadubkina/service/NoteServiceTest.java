package by.gsu.dashadubkina.service;

import by.gsu.dashadubkina.objects.Note;
import by.gsu.dashadubkina.objects.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NoteServiceTest {

    public static final String BAD_SHOP = "bad shop";
    public static final String BUY_A_PLATE = "buy a plate";

    private NoteService noteService;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("userService");
        noteService = (NoteService) context.getBean("noteService");
    }

    @Test
    public void testCreateNote() throws Exception {
        User user = new User();
        user.setName("masha");
        user.setEmail("masha@mail.ru");
        user.setPassword("45214");
        userService.createUser(user);
        System.out.println(user.getId());
        Note note = new Note();
        note.setTopic("jump");
        note.setText("exxxxyyyy");
        note.setDateTime(new Date());
        note.setAuthor(user);
        noteService.createNote(note);
        System.out.println("add");

    }

    @Test
    public void testDeleteNote() throws Exception {
        User user = new User();
        user.setName("masha");
        user.setEmail("masha@mail.ru");
        user.setPassword("45214");
        userService.createUser(user);
        System.out.println(user.getId());
        Note note = new Note();
        note.setAuthor(user);
        note.setTopic("jump");
        note.setText("exy");
        note.setDateTime(new Date());
        noteService.createNote(note);
        noteService.deleteNote(note.getId());
        System.out.println("delete");

    }

    @Test
    public void testGetNote() throws Exception {
        User user = new User();
        user.setName("kira");
        user.setEmail("kira@gmail.com");
        user.setPassword("long123456789");
        userService.createUser(user);
        Note note = new Note();
        note.setAuthor(user);
        note.setTopic("buy a plate");
        note.setDateTime(new Date());
        note.setText("shop Alis");
        noteService.createNote(note);
        System.out.println(note.getId());
        Note updatedNote = noteService.getNote(note.getId());
        assertEquals(BUY_A_PLATE, updatedNote.getTopic());


    }

    @Test
    public void testGetAll() throws Exception {
        List<Note> all = noteService.getAll();
        for (Note note : all) {
            System.out.println(note.getAuthor().getId());
        }
        assertEquals("Size should be equal zero", 24, all.size());
    }


    @Test
    public void testUpdateNote() throws Exception {
        User user = new User();
        user.setName("kira");
        user.setEmail("kira@gmail.com");
        user.setPassword("long123456789");
        userService.createUser(user);
        Note note = new Note();
        note.setAuthor(user);
        note.setTopic("buy a plate");
        note.setDateTime(new Date());
        note.setText("shop Alis");
        noteService.createNote(note);
        System.out.println(note.getId());
        note.setText(BAD_SHOP);
        noteService.updateNote(note);
//        найти решение проблемы
//        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//        sessionFactory.openSession();


        Note updatedNote = noteService.getNote(note.getId());
        assertEquals(BAD_SHOP, updatedNote.getText());
    }
}