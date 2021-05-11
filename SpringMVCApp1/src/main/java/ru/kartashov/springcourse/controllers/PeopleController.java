package ru.kartashov.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kartashov.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PersonDAO personDAO;

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("personList", personDAO.showAll());
        return "people/show";
    }
}
