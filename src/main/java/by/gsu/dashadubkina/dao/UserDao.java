package by.gsu.dashadubkina.dao;


import by.gsu.dashadubkina.objects.User;

import java.util.List;

public interface UserDao {

    long createUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getAll();


}
