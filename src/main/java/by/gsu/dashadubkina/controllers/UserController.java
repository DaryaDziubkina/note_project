package by.gsu.dashadubkina.controllers;

import by.gsu.dashadubkina.objects.User;
import by.gsu.dashadubkina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/main")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "user/userPage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("userAttribute", new User());
        return "user/userAdd";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user, Model model) {
        userService.createUser(user);
        model.addAttribute("users", userService.getAll());
        return "user/userPage";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("id", id);
        model.addAttribute("users", userService.getAll());
        return "user/userPage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) long id, Model model) {
        model.addAttribute("userAttribute", userService.getUser(id));
        return "user/userEdit";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") User user,
                           @RequestParam(value = "id", required = true) long id, Model model) {
        user.setId(id);
//        User storedUser = userService.getUser(id);
//        storedUser.setName(user.getName());
//        userService.updateUser(storedUser);
        //TODO
        userService.updateUser(user);
        model.addAttribute("users", userService.getAll());
        return "user/userPage";
    }
}
