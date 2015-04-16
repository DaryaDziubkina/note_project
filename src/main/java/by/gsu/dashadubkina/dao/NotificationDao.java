package by.gsu.dashadubkina.dao;


import by.gsu.dashadubkina.objects.Notification;

import java.util.List;

public interface NotificationDao {

    long createNotification(Notification notification);

    Notification getNotification(long id);

    void deleteNotification(long id);

    void updateNotification(Notification notification);

    List<Notification> getAll();

}
