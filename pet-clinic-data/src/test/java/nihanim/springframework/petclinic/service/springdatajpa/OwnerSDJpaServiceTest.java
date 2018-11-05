package nihanim.springframework.petclinic.service.springdatajpa;

import nihanim.springframework.petclinic.model.Owner;
import nihanim.springframework.petclinic.repositories.OwnerRepository;
import nihanim.springframework.petclinic.repositories.PetRepository;
import nihanim.springframework.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Guner";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnedOwner;


    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        Mockito.when(ownerRepository.findByLastName(ArgumentMatchers.any())).thenReturn(returnedOwner);
        Owner guner = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, guner.getLastName());
        Mockito.verify(ownerRepository).findByLastName(ArgumentMatchers.any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());
        Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {

        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = service.findById(1l);
        assertNotNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1l).build();
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnedOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        service.delete(returnedOwner);
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnedOwner.getId());
        Mockito.verify(ownerRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }
}