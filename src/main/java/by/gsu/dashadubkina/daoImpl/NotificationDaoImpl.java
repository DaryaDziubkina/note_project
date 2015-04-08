package by.gsu.dashadubkina.daoImpl;


import by.gsu.dashadubkina.dao.NotificationDao;
import by.gsu.dashadubkina.objects.Notification;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class NotificationDaoImpl implements NotificationDao {
    private Session session;

    public NotificationDaoImpl(Session session) {
        this.session = session;
    }

    public long createNotification(Notification notification) {
        notification.setDateTime(new Date());
        session.save(notification);
        return notification.getId();
    }

    public void changeNotification(Notification notification) {

    }

    public void deleteNotification(Notification notification) {

    }

    public void updateNotification(Notification notification) {

    }
}
