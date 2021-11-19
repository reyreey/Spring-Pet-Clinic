package com.reyrey.springpetclinic.services;

import com.reyrey.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
