package by.gsu.dashadubkina.userService;


import by.gsu.dashadubkina.objects.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {



    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM  User");
        return query.list();

    }

    public User getUser( long id ) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        User user = (User) session.get(User.class, id);

        return user;
    }


    public void addUers(User user) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(user);
    }

    public void deleteUser(Integer id) {


        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        User user = (User) session.get(User.class, id);

        // Delete
        session.delete(user);
    }

    public void edit(User user) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person via id
        User existingUser = (User) session.get(User.class, user.getId());

        // Assign updated values to this person
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        // Save updates
        session.save(existingUser);
    }
}


