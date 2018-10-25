package nihanim.springframework.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PetType extends BaseEntity {

    @Column
    private String name;

}
