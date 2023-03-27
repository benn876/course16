package code.optional;

import code.model.Person;
import code.PersonService;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        PersonService service = new PersonService();
//        Person foundPerson = service.getPersonByNameWithoutOptional("Jojo");
//        System.out.println(foundPerson.getName());
        Optional<Person> foundPerson = service.getPersonByNameWithOptional("Jojo");
        if (foundPerson.isPresent()) {
            Person person = foundPerson.get();
            System.out.println(person.getName());
        } else {
            System.out.println("No person was found");
        }

        Person person = foundPerson.orElse(new Person("Default User", 33, "Default User"));

        System.out.println(person.getName());

        foundPerson.isEmpty();
        Optional<String> just_the_name = foundPerson.map(personFound -> {
            System.out.println("Just the name");
            return personFound.getName();
        });

        // foundPerson.orElseThrow(() -> new RuntimeException());

        foundPerson.ifPresent(personF -> {
            System.out.println(personF.getAge());
        });

        System.out.println(foundPerson.map(pers -> pers.getJobTitle())
                .orElse("No job"));

        service.getPersonByNameWithOptional(null);
    }
}
