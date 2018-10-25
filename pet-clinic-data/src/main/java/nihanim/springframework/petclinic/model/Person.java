package nihanim.springframework.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {

    @Column
    @NotEmpty
    private String firstName;
    @Column
    @NotEmpty
    private String lastName;

}
