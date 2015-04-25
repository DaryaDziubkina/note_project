package by.gsu.dashadubkina.daoImpl;


import by.gsu.dashadubkina.dao.NotificationDao;
import by.gsu.dashadubkina.objects.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("NotificationDao")
public class NotificationDaoImpl implements NotificationDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public long createNotification(Notification notification) {
        getSession().save(notification);
        return notification.getId();
    }

    public Notification getNotification(long id) {
        return (Notification) getSession().get(Notification.class, id);
    }

    public void deleteNotification(long id) {
        Notification notification = (Notification) getSession().get(Notification.class, id);
        getSession().delete(notification);

    }

    public void updateNotification(Notification notification) {
        getSession().saveOrUpdate(notification);
    }

    public List<Notification> getAll() {
        return getSession().createQuery("FROM Notification").list();
    }
}
