package ru.kartashov.springcourse.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.kartashov.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLECOUNT;
    private final List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(++PEOPLECOUNT, "Dima"));
        personList.add(new Person(++PEOPLECOUNT, "Roma"));
        personList.add(new Person(++PEOPLECOUNT, "Vitya"));
    }

    public List<Person> showAll() {
        return personList;
    }

    //returning one person with specified id
    public Person index(int id) {
        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void create(Person person) {
        person.setId(++PEOPLECOUNT);
        personList.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = index(id);
        personToBeUpdated.setName(person.getName());
    }

    public void delete(int id) {
        personList.removeIf(p -> p.getId() == id);
    }
}
