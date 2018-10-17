package nihanim.springframework.petclinic.service.map;

import nihanim.springframework.petclinic.model.Person;
import nihanim.springframework.petclinic.service.CrudService;

import java.util.Set;

public class PersonServiceMap extends AbstractMapService<Person, Long> implements CrudService<Person, Long> {

    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Person save(Person person) {
        return super.save(person.getId(), person);
    }

    @Override
    public void delete(Person person) {
        super.delete(person);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
