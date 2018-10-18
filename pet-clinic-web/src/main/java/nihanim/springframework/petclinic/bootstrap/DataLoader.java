package nihanim.springframework.petclinic.bootstrap;

import nihanim.springframework.petclinic.model.Owner;
import nihanim.springframework.petclinic.model.Vet;
import nihanim.springframework.petclinic.service.OwnerService;
import nihanim.springframework.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Nihan");
        owner1.setLastName("Guner");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Caglar");
        owner2.setLastName("Guner");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Busra");
        vetService.save(vet1);
        vet1.setLastName("Secrin");

        Vet vet2 = new Vet();
        vet2.setFirstName("Onur");
        vet2.setLastName("Gursoy");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
