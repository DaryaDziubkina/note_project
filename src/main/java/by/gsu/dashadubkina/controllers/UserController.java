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
        return "userspage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("personAttribute", new User());
        return "addpage";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user) {
        userService.createUser(user);
        return "addedpage";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("id", id);
        return "deletedpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) long id, Model model) {
        model.addAttribute("userAttribute", userService.getUser(id));
        return "editpage";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("usersAttribute") User user,
                           @RequestParam(value = "id", required = true) long id, Model model) {
        user.setId(id);
        userService.updateUser(user);
        model.addAttribute("id", id);
        return "editedpage";
    }
}
