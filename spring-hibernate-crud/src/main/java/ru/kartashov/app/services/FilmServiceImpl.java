package ru.kartashov.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kartashov.app.dao.FilmDAO;
import ru.kartashov.app.models.Film;

import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService{


    private FilmDAO filmDAO;

    @Autowired
    public void setFilmDAO(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Override
    public List<Film> showAllFilms(int page) {
        return filmDAO.showAllFilms(page);
    }

    @Override
    public void add(Film film) {
        filmDAO.add(film);
    }

    @Override
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Override
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Override
    public Film getById(int id) {
        return filmDAO.getById(id);
    }

    @Override
    public int filmsCount() {
        return filmDAO.filmsCount();
    }
}
