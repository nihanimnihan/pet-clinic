package nihanim.springframework.petclinic.bootstrap;

import nihanim.springframework.petclinic.model.*;
import nihanim.springframework.petclinic.service.OwnerService;
import nihanim.springframework.petclinic.service.PetTypeService;
import nihanim.springframework.petclinic.service.SpecialityService;
import nihanim.springframework.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded petTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Nihan");
        owner1.setLastName("Guner");
        owner1.setAddress("Nihan's address");
        owner1.setCity("Antalya");
        owner1.setTelephone("5309556120");
        Pet nihansPet = new Pet();
        nihansPet.setPetType(savedCatPetType);
        nihansPet.setBirthDate(LocalDate.now());
        nihansPet.setOwner(owner1);
        nihansPet.setName("Sahika");
        owner1.getPets().add(nihansPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Caglar");
        owner2.setLastName("Guner");
        owner2.setAddress("Caglar's address");
        owner2.setCity("Antalya");
        owner2.setTelephone("5309556120");
        Pet caglarsPet = new Pet();
        caglarsPet.setPetType(savedDogPetType);
        caglarsPet.setBirthDate(LocalDate.now());
        caglarsPet.setOwner(owner2);
        caglarsPet.setName("Sahika");
        owner2.getPets().add(caglarsPet);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Speciality radiology = new Speciality();
        radiology.setDesription("radiology");
        Speciality savedRadilogy = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDesription("surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDesription("dentistry");
        Speciality savedDentistry= specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Busra");
        vet1.setLastName("Secrin");
        vet1.getSpecialities().add(savedSurgery);
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Onur");
        vet2.setLastName("Gursoy");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
