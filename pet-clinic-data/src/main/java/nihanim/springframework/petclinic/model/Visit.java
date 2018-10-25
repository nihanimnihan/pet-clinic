package nihanim.springframework.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Visit extends BaseEntity {

    @Column
    private LocalDate localDate;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
