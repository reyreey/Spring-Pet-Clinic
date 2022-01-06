package com.reyrey.springpetclinic.repositories;

import com.reyrey.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Owner findByLastName(String LastName);
    List<Owner> findAllByLastNameLike(String lastName);

}
