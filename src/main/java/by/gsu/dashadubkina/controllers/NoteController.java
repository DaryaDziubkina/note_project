package by.gsu.dashadubkina.controllers;

import by.gsu.dashadubkina.objects.Note;
import by.gsu.dashadubkina.service.NoteService;
import by.gsu.dashadubkina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main")
public class NoteController {

    @Autowired
        NoteService noteService;
        @Autowired
        UserService userService;

        @RequestMapping(value = "/notes", method = RequestMethod.GET)
        public String getNotes(Model model) {
            List<Note> notes = noteService.getAll();
            model.addAttribute("notes", notes);
            return "note/notePage";
        }

        @RequestMapping(value = "/notes/add", method = RequestMethod.GET)
        public String getAdd(Model model) {
            model.addAttribute("noteAttribute", new Note());

            model.addAttribute("userList", userService.getAll());
            return "note/noteAdd";
    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("noteAttribute") Note note) {
        note.setDateTime(new Date());
        noteService.createNote(note);
        return "redirect:/main/notes";
    }

    @RequestMapping(value = "/notes/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id", required = true) long id, Model model) {
        noteService.deleteNote(id);
        model.addAttribute("id", id);
        model.addAttribute("notes", noteService.getAll());
        return "note/notePage";
    }

    @RequestMapping(value = "/notes/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value = "id", required = true) long id, Model model) {

        model.addAttribute("noteAttribute", noteService.getNote(id));
        model.addAttribute("userList", userService.getAll());
        return "note/noteEdit";
    }

    @RequestMapping(value = "/notes/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") Note note,
                           @RequestParam(value = "id", required = true) long id) {

        //посмотреть будет ли без сета
        note.setId(id);
        note.setDateTime(new Date());
        noteService.updateNote(note);
        return "redirect:/main/notes";
    }

}
