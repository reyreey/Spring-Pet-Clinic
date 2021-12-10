package com.reyrey.springpetclinic.services.springdatajpa;

import com.reyrey.springpetclinic.model.Owner;
import com.reyrey.springpetclinic.repositories.OwnerRepository;
import com.reyrey.springpetclinic.repositories.PetRepository;
import com.reyrey.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;
    final String lastName="smith";
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners=new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners=service.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner=service.findById(1L);

        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner=service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave=Owner.builder().id(1L).lastName(lastName).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner=service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        //default is 1 time.
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner returnOwner=Owner.builder().id(1L).lastName(lastName).build();

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith=service.findByLastName(lastName);

        assertEquals(lastName,smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}