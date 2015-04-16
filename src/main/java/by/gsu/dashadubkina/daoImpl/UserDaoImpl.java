package by.gsu.dashadubkina.daoImpl;

import by.gsu.dashadubkina.dao.UserDao;
import by.gsu.dashadubkina.objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {

    private Session session;

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
        super();
    }

    public UserDaoImpl(Session session) {
        this.session = session;
    }

    private Session getSession() {
       return sessionFactory.getCurrentSession();
    }

    public long createUser(User user) {
        getSession().save(user);
        return user.getId();
    }

    public User getUser(long id) {
        return (User) getSession().get(User.class, id);
    }

    public void deleteUser(long id) {
        User user = (User) getSession().get(User.class, id);
        getSession().delete(user);

    }

    public void updateUser(User user) {
        getSession().saveOrUpdate(user);
    }

    public List<User> getAll() {
        return getSession().createQuery("FROM User ").list();
    }

}
