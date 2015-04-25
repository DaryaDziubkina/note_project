package by.gsu.dashadubkina.controllers;

import by.gsu.dashadubkina.objects.Notification;
import by.gsu.dashadubkina.service.NoteService;
import by.gsu.dashadubkina.service.NotificationService;
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
public class NotificationController {

    @Autowired
    NoteService noteService;
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/notifications", method = RequestMethod.GET)
    public String getNotes(Model model) {
        List<Notification> notifications = notificationService.getAll();
        model.addAttribute("notifications", notifications);
        return "notification/notificationPage";
    }

    @RequestMapping(value = "/notifications/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("notificationAttribute", new Notification());
        model.addAttribute("noteList", noteService.getAll());
        return "notification/notificationAdd";
    }

    @RequestMapping(value = "/notifications/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("notificationAttribute") Notification notification) {
        notificationService.createNotification(notification);
        return "redirect:/main/notifications";
    }

    @RequestMapping(value = "/notifications/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) long id, Model model) {
        notificationService.deleteNotification(id);
        model.addAttribute("id", id);
        model.addAttribute("notifications", notificationService.getAll());
        return "notification/notificationPage";
    }

    @RequestMapping(value = "/notifications/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) long id, Model model) {

        model.addAttribute("notificationAttribute", notificationService.getNotification(id));
        model.addAttribute("noteList", noteService.getAll());
        return "notification/notificationEdit";
    }

    @RequestMapping(value = "/notifications/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("notificationAttribute") Notification notification,
                           @RequestParam(value = "id", required = true) long id) {

        //посмотреть будет ли без сета
        notification.setId(id);
//        notification.setDateTime(new Date());
        notificationService.updateNotification(notification);
        return "redirect:/main/notifications";
    }


}
