package by.gsu.dashadubkina.service;

import by.gsu.dashadubkina.dao.NotificationDao;
import by.gsu.dashadubkina.objects.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    public NotificationService() {
        super();
    }

    public void createNotification(Notification notification) {
        notificationDao.createNotification(notification);
    }

    public void deleteNotification(long id) {
        notificationDao.deleteNotification(id);
    }

    public void updateNotification(Notification notification) {
        notificationDao.updateNotification(notification);
    }

    public Notification getNotification(long id) {
        return notificationDao.getNotification(id);

    }

    public List<Notification> getAll() {
        return notificationDao.getAll();
    }

}

