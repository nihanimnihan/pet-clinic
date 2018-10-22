package nihanim.springframework.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PetType extends BaseEntity {

    @Column
    private String name;

    public PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
