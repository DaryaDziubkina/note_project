package by.gsu.dashadubkina.dao;


import by.gsu.dashadubkina.objects.Notification;

public interface NotificationDao {

    long createNotification(Notification notification);
    void changeNotification(Notification notification);
    void deleteNotification(Notification notification);
    void updateNotification(Notification notification);

}
