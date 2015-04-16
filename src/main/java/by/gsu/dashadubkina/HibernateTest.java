//package by.gsu.dashadubkina;
//
//import by.gsu.dashadubkina.dao.NoteDao;
//import by.gsu.dashadubkina.dao.NotificationDao;
//import by.gsu.dashadubkina.dao.UserDao;
//import by.gsu.dashadubkina.daoImpl.NoteDaoImpl;
//import by.gsu.dashadubkina.daoImpl.NotificationDaoImpl;
//import by.gsu.dashadubkina.daoImpl.UserDaoImpl;
//import by.gsu.dashadubkina.objects.Note;
//import by.gsu.dashadubkina.objects.Notification;
//import by.gsu.dashadubkina.objects.User;
//import by.gsu.dashadubkina.service.UserService;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.Date;
//
//public class HibernateTest {
//
//    public static void main(String[] args) {
//
////        ApplicationContext ctx = new ClassPathXmlApplicationContext( "applicationContext.xml");
////
////        UserService userService = (UserService) ctx.getBean("userService");
////        userService.getAll();
//
////        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
////        Session session = sessionFactory.openSession();
////        testHibernate(session);
////        testDAO(session);
////        testService(sessionFactory);
//
//    }
//
//    private static void testHibernate(Session session) {
//
//        session.beginTransaction();
//
//        User user = new User();
//        user.setName("Darya");
//        user.setEmail("dasha.dubkina@gmail.com");
//        user.setPassword("scl375892");
//        session.save(user);
//
//        long idUser = user.getId();
//
//        Note note = new Note();
//        note.setDateTime(new Date());
//        note.setAuthor(user);
//        note.setTopic("hi");
//        session.save(note);
//
//        long idNote = note.getId();
//
//        Notification notification = new Notification();
//        notification.setDateTime(new Date());
//        notification.setNote(note);
//
//        session.save(notification);
//
//        long idNotification = notification.getId();
//
//        session.getTransaction().commit();
//
//        User loadUser = (User) session.load(User.class, idUser);
//        System.out.println(loadUser.getId());
//        Note loadNote = (Note) session.load(Note.class, idNote);
//        System.out.println(loadNote.getId());
//        Notification loadNotification = (Notification) session.load(Notification.class, idNotification);
//        System.out.println(loadNotification.getId());
//        System.out.println("Done");
//    }
//
//    private static void testDAO(Session session) {
//        session.beginTransaction();
//
//        User user = new User();
//        UserDao userDao = new UserDaoImpl(session);
//        userDao.createUser(user);
//
//        long userId = user.getId();
//
//        Note note = new Note();
//        NoteDao noteDao = new NoteDaoImpl(session);
//        note.setAuthor(user);
//        noteDao.createNote(note);
//
//        long noteId = note.getId();
//
//        Notification notification = new Notification();
//        NotificationDao notificationDao = new NotificationDaoImpl(session);
//        notification.setNote(note);
//        notificationDao.createNotification(notification);
//
//        long notificationId = notification.getId();
//
//        session.getTransaction().commit();
//
//        User loadUser = (User) session.load(User.class, userId);
//        System.out.println(loadUser.getId());
//
//        Note loadNote = (Note) session.load(Note.class, noteId);
//        System.out.println(loadNote.getId());
//
//        Notification loadNotification = (Notification) session.load(Notification.class, notificationId);
//        System.out.println(loadNotification.getId());
//
//        System.out.println("Done");
//    }
//
//    private static void testService(SessionFactory sessionFactory) {
//        Session session = sessionFactory.openSession();
//        UserService userService = new UserService();
//
//        User user = new User();
//
//        // Assign updated values to this person
//        user.setName("Fomachka");
//        user.setEmail("foma@gmail.com");
//        user.setPassword("sfsd45254");
//        userService.createUser(user);
//        session.flush();
//        System.out.println("User added.");
//        printUsers(userService);
////        userService.deleteUser(user.getId());
//        System.out.println("User deleted.");
//        session.flush();
//        printUsers(userService);
//        System.out.println("Done");
//    }
//
//    private static void printUsers(UserService userService) {
//        for (User user1 : userService.getAll()) {
//            System.out.println(user1.getId());
//        }
//    }
//}

