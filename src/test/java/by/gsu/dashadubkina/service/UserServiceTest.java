package by.gsu.dashadubkina.service;

import by.gsu.dashadubkina.objects.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private static UserService userService;

    @BeforeClass
    public static void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("userService");
    }

//    @Test
//    public void testGetAll() throws Exception {
//        assertEquals("Size should be equal zero", 4, userService.getAll().size());
//    }
//
//    @Test
//    public void testGetAll2() throws Exception {
//        assertEquals("Size should be equal zero", 0, userService.getAll().size());
//    }

    @Test
    public void testCreate() throws Exception {
        User user = new User();
        user.setName("jon");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User();
        user.setName("myxa");
        user.setEmail("goni@gmail.com");
        user.setPassword("london452");
        userService.createUser(user);
        System.out.println(user.getId());
        userService.deleteUser(user.getId());

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setName("mark");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
        System.out.println(user.getId());
        user.setName("pashka");
        userService.updateUser(user);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = new User();
        user.setName("mishka");
        user.setEmail("goni@gmail.com");
        user.setPassword("room452");
        userService.createUser(user);
        User createUser = userService.getUser(user.getId());
        System.out.println(user.getId());
        assertEquals(user.getId(), createUser.getId());
    }
}