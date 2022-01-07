package com.reyrey.springpetclinic.controllers;

import com.reyrey.springpetclinic.model.Owner;
import com.reyrey.springpetclinic.model.PetType;
import com.reyrey.springpetclinic.services.OwnerService;
import com.reyrey.springpetclinic.services.PetService;
import com.reyrey.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private static final String VIEWS_PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }
    @ModelAttribute("owners")
    public Owner findOwners(@PathVariable("ownerId") Long ownerId){
        return ownerService.findById(ownerId);
    }
    @ModelAttribute("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
}
