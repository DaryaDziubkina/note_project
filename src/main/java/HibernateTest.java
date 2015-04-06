import objects.Note;
import objects.Notification;
import objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = new User();
        user.setName("Darya");
        user.setEmail("dasha.dubkina@gmail.com");
        user.setPassword("scroll3804");
        session.save(user);

        long idUser = user.getIdUser();

        Note note = new Note();
        note.setDateTime(new Date());
        note.setAuthor(user);
        note.setTopic("hi");
//        note.setNotifications();
        session.save(note);

        long idNote = note.getIdNote();

        Notification notification = new Notification();
        notification.setDateTime(new Date());
        notification.setNote(note);

        session.save(notification);

        long idNotification = notification.getIdNotification();


        session.getTransaction().commit();

        User loadUser = (User) session.load(User.class, idUser);
        System.out.println(loadUser.getIdUser());
        Note loadNote = (Note) session.load(Note.class, idNote);
        Notification loadNotification = (Notification) session.load(Notification.class, idNotification );
        System.out.println(loadNote.getIdNote());
        System.out.println(loadNotification.getIdNotification());
        System.out.println("Done");
    }
}

