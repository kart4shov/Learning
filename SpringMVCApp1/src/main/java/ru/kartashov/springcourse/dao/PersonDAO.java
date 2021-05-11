package ru.kartashov.springcourse.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.kartashov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(1, "Dima"));
        personList.add(new Person(2, "Roma"));
        personList.add(new Person(3, "Vitya"));
    }

    public List<Person> showAll() {
        return personList;
    }

    public Person index(int index) {
        return personList.get(index);
    }
}
