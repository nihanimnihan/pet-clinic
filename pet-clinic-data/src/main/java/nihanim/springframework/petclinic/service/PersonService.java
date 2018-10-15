package nihanim.springframework.petclinic.service;

import nihanim.springframework.petclinic.model.Person;

import java.util.Set;

public interface PersonService {

    Person findById(Long id);

    Person save(Person person);

    Set<Person> findAll();
}
