package com.reyrey.springpetclinic.repositories;

import com.reyrey.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
