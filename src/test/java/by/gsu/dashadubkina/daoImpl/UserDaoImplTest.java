package by.gsu.dashadubkina.daoImpl;

import by.gsu.dashadubkina.dao.UserDao;
import by.gsu.dashadubkina.objects.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoImplTest {
    private static UserDao userDaoImpl;

    @BeforeClass
    public static void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        userDaoImpl = (UserDao) context.getBean("UserDao");
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setName("misha");
        user.setEmail("misha@mail.ru");
        user.setPassword("4521kill");
        userDaoImpl.createUser(user);
        System.out.println(user.getId());

    }

}