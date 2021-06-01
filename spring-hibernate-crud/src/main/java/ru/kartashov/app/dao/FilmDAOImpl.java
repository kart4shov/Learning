package ru.kartashov.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kartashov.app.models.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public FilmDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Film> showAllFilms(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Film").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    @Override
    public int filmsCount() {
        return sessionFactory.getCurrentSession().createQuery("SELECT count(*) FROM Film", Number.class)
                .getSingleResult()
                .intValue();
    }




    /*
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Film> films = new HashMap<>();

    static {
        Film film_1 = new Film();
        film_1.setId(AUTO_ID.getAndIncrement());
        film_1.setTitle("Inception");
        film_1.setYear(2010);
        film_1.setGenre("sci-fi");
        film_1.setWatched(true);
        films.put(film_1.getId(), film_1);
    }

    static {
        Film film_2 = new Film();
        film_2.setId(AUTO_ID.getAndIncrement());
        film_2.setTitle("The Lord of the Rings");
        film_2.setYear(2001);
        film_2.setGenre("fantasy");
        film_2.setWatched(true);
        films.put(film_2.getId(), film_2);
    }

    @Override
    public List<Film> ShowAllFilms() {
        return new ArrayList<>(films.values());
    }

    @Override
    public void add(Film film) {
        film.setId(AUTO_ID.getAndIncrement());
        films.put(film.getId(), film);
    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());
    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(), film);
    }

    @Override
    public Film getById(int id) {
        return films.get(id);
    }
*/
}
