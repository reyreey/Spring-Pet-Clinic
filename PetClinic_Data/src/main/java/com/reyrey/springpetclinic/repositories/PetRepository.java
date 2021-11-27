package com.reyrey.springpetclinic.repositories;

import com.reyrey.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
