package com.reyrey.springpetclinic.repositories;

import com.reyrey.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
