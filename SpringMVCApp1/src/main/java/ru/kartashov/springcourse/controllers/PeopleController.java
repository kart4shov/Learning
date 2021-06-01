package ru.kartashov.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kartashov.springcourse.dao.PersonDAO;
import ru.kartashov.springcourse.models.Person;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class PeopleController {

    PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("personList", personDAO.showAll());
        return "people/show";
    }


    @GetMapping("/{id}")
    public String showCertainPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.index(id));
        return "people/person";
    }


    @GetMapping("/new")
    public String showCreateForm(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping("/addingPersonToList")
    public String createPerson(@ModelAttribute("person") @Valid Person newPerson,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";
        personDAO.save(newPerson);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.index(id));
        return "people/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }
        personDAO.update(id, person);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/";
    }
}


