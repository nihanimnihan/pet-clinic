package nihanim.springframework.petclinic.service;

import nihanim.springframework.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitService extends CrudRepository<Visit, Long> {
}
