package by.gsu.dashadubkina.service;

import by.gsu.dashadubkina.objects.Note;
import by.gsu.dashadubkina.objects.Notification;
import by.gsu.dashadubkina.objects.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class NotificationServiceTest {
    private NotificationService notificationService;
    private UserService userService;
    private NoteService noteService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("userService");
        noteService = (NoteService) context.getBean("noteService");
        notificationService = (NotificationService) context.getBean("notificationService");
    }

    @Test
    public void testCreateNotification() throws Exception {
        User user = new User();
        user.setName("jon");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
        System.out.println(user.getId());
        Note note = new Note();
        note.setTopic("jump");
        note.setText("exxxxyyyy");
        note.setDateTime(new Date());
        note.setAuthor(user);
        noteService.createNote(note);
        System.out.println("add");
        Notification notification = new Notification();
        notification.setNote(note);
        notification.setDateTime(new Date());
        notificationService.createNotification(notification);

    }

    @Test
    public void testDeleteNotification() throws Exception {
        User user = new User();
        user.setName("jon");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
        System.out.println(user.getId());
        Note note = new Note();
        note.setTopic("jump");
        note.setText("exxxxyyyy");
        note.setDateTime(new Date());
        note.setAuthor(user);
        noteService.createNote(note);
        System.out.println("add");
        Notification notification = new Notification();
        notification.setNote(note);
        notification.setDateTime(new Date());
        notificationService.createNotification(notification);
        notificationService.deleteNotification(notification.getId());

    }

    @Test
    public void testUpdateNotification() throws Exception {
        User user = new User();
        user.setName("jon");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
        System.out.println(user.getId());
        Note note = new Note();
        note.setTopic("jump");
        note.setText("exxxxyyyy");
        note.setDateTime(new Date());
        note.setAuthor(user);
        noteService.createNote(note);
        System.out.println("add");
        Notification notification = new Notification();
        notification.setNote(note);
        notification.setDateTime(new Date());
        notificationService.createNotification(notification);
        notification.setDateTime(new Date());
        notificationService.updateNotification(notification);
        System.out.println(note.getId());
        Notification updatedNotification = notificationService.getNotification(notification.getId());
        assertEquals(notification.getDateTime(), updatedNotification.getDateTime());

    }

    @Test
    public void testGetNotification() throws Exception {
        User user = new User();
        user.setName("jon");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
        System.out.println(user.getId());
        Note note = new Note();
        note.setTopic("jump");
        note.setText("exxxxyyyy");
        note.setDateTime(new Date());
        note.setAuthor(user);
        noteService.createNote(note);
        System.out.println("add");
        Notification notification = new Notification();
        notification.setNote(note);
        notification.setDateTime(new Date());
        notificationService.createNotification(notification);
        Notification createNotification = notificationService.getNotification(notification.getId());
        System.out.println(notification.getId());
        assertEquals(notification.getId(), createNotification.getId());
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals("Size should be equal zero", 4, userService.getAll().size());

    }

    @Test
    public void testGetAll2() throws Exception {
        assertEquals("Size should be equal zero", 6, userService.getAll().size());

    }

}