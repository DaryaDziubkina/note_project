package by.gsu.dashadubkina.daoImpl;

import by.gsu.dashadubkina.dao.UserDao;
import by.gsu.dashadubkina.objects.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {


    private Session session;

    public UserDaoImpl(Session session){
         this.session = session;
    }

    public long createUser(User user) {
        user.setName("Max");
        user.setEmail("maxim@gamil.com");
        user.setPassword("564128l");
        session.save(user);
        return user.getId();
    }

    public void changeUser(User user) {

    }

    public void deleteUser(User user){
    }

    public void updateUser(User user) {


    }
}
