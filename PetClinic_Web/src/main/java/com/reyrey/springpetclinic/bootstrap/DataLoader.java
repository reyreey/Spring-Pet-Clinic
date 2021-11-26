package com.reyrey.springpetclinic.bootstrap;

import com.reyrey.springpetclinic.model.Owner;
import com.reyrey.springpetclinic.model.Pet;
import com.reyrey.springpetclinic.model.PetType;
import com.reyrey.springpetclinic.model.Vet;
import com.reyrey.springpetclinic.services.OwnerService;
import com.reyrey.springpetclinic.services.PetTypeService;
import com.reyrey.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("reyrey");
        owner1.setLastName("dh");
        owner1.setAddress("address1");
        owner1.setCity("teh");
        owner1.setTelephone("02145375885");

        Pet pet1=new Pet();
        pet1.setName("alex");
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("fat");
        owner2.setLastName("dh");
        owner2.setAddress("address2");
        owner2.setCity("yazd");
        owner2.setTelephone("06445375385");

        Pet pet2=new Pet();
        pet2.setName("pishi");
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1=new Vet();
        vet1.setFirstName("momo");
        vet1.setLastName("LN1");
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("coco");
        vet2.setLastName("LN2");
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
