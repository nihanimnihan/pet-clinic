package nihanim.springframework.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pet extends BaseEntity{

    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @Column
    private LocalDate birthDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
