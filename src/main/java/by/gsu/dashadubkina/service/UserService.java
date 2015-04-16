package by.gsu.dashadubkina.service;


import by.gsu.dashadubkina.dao.UserDao;
import by.gsu.dashadubkina.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService() {
        super();
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}


