package ru.kartashov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kartashov.app.models.Film;
import ru.kartashov.app.services.FilmService;

import java.util.List;

@Controller
public class FilmController {

/*
    private static Film film;

    static{
        film = new Film();
        film.setTitle("Inception");
        film.setGenre("sci-fi");
        film.setYear(2010);
        film.setWatched(true);

    }
*/

    FilmService filmService;
    private int page;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    //@GetMapping
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAllFilmsPage(@RequestParam (defaultValue = "1") int page) {
        this.page = page;
        List<Film> filmList = filmService.showAllFilms(page);
        int filmsCount = filmService.filmsCount();
        int pagesCount = (int)((filmsCount + 9) * 0.1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmList", filmList);
        modelAndView.addObject("page", page);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("filmsCount", filmsCount);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView showEditFilPage(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("film", filmService.getById(id));
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page);
        filmService.edit(film);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddingPage(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("film", film);
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        filmService.add(film);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete")
    public ModelAndView deleteFilm(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.delete(filmService.getById(id));
        return modelAndView;
    }
}
