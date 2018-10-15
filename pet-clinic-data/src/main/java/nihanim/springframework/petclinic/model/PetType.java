package nihanim.springframework.petclinic.model;

public class PetType extends BaseEntity {

    private String name;

    public PetType(String name) {
        this.name = name;
    }
}
