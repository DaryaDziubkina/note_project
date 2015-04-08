package by.gsu.dashadubkina.dao;


import by.gsu.dashadubkina.objects.User;

public interface UserDao {

    long createUser(User user);

    void changeUser(User user);

    void deleteUser(User user);

    void updateUser(User user);


}
