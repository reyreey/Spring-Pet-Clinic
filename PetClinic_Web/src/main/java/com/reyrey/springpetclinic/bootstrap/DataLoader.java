package com.reyrey.springpetclinic.bootstrap;

import com.reyrey.springpetclinic.model.Owner;
import com.reyrey.springpetclinic.model.Vet;
import com.reyrey.springpetclinic.services.OwnerService;
import com.reyrey.springpetclinic.services.VetService;
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
        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("reyrey");
        owner1.setLastName("dh");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("fat");
        owner2.setLastName("dh");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("momo");
        vet1.setLastName("LN1");
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("coco");
        vet2.setLastName("LN2");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
