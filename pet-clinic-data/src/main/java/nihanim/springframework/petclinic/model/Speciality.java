package nihanim.springframework.petclinic.model;

public class Speciality extends BaseEntity {

    private String desription;

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}
