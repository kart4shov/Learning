package ru.kartashov.app.dao;

import ru.kartashov.app.models.Film;

import java.util.List;

public interface FilmDAO {
    List<Film> showAllFilms(int page);
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
    int filmsCount();
}
