package code;

import code.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Person> persons;

    public PersonService() {
        this.persons = Arrays.asList(
                Person.builder()
                        .name("Mihai")
                        .age(23)
                        .jobTitle("Student")
                        .build(),
                Person.builder()
                        .name("Ioana")
                        .age(32)
                        .jobTitle("Teacher")
                        .build(),
                Person.builder()
                        .name("Mirela")
                        .age(23)
                        .jobTitle("Human resources")
                        .build()
        );
    }

    public Optional<Person> getPersonByNameWithOptional(String name) {
        String notNullName = Optional.ofNullable(name)
                .orElse("");
        for (Person person : persons) {
            if (notNullName.equals(person.getName())) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    public Person getPersonByNameWithoutOptional(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}
