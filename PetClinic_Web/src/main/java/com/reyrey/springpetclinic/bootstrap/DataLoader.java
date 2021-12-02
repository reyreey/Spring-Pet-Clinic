package com.reyrey.springpetclinic.bootstrap;

import com.reyrey.springpetclinic.model.*;
import com.reyrey.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService
            , SpecialtyService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findAll().size();
        if(count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology=new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology =specialityService.save(radiology);

        Specialty surgery=new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery =specialityService.save(surgery);

        Specialty dentistry=new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry =specialityService.save(dentistry);

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

        Visit catVisit=new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("sneezy kitty");
        visitService.save(catVisit);

        Vet vet1=new Vet();
        vet1.setFirstName("momo");
        vet1.setLastName("LN1");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("coco");
        vet2.setLastName("LN2");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
