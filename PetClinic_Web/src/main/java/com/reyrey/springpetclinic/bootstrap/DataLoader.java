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
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialityService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialityService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("reyhaneh");
        owner1.setLastName("dehghan");
        owner1.setAddress("address1");
        owner1.setCity("tehran");
        owner1.setTelephone("1231298734");

        Pet reysDog = new Pet();
        reysDog.setPetType(savedDogPetType);
        reysDog.setOwner(owner1);
        reysDog.setBirthDate(LocalDate.now());
        reysDog.setName("hapoo");
        owner1.getPets().add(reysDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("fatemeh");
        owner2.setLastName("dehghan manshadi");
        owner2.setAddress("address2");
        owner2.setCity("rasht");
        owner2.setTelephone("1231231234");

        Pet fatsCat = new Pet();
        fatsCat.setName("pishi");
        fatsCat.setOwner(owner2);
        fatsCat.setBirthDate(LocalDate.now());
        fatsCat.setPetType(savedCatPetType);
        owner2.getPets().add(fatsCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fatsCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("sam");
        vet1.setLastName("akbari");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("pari");
        vet2.setLastName("ahmadi");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
