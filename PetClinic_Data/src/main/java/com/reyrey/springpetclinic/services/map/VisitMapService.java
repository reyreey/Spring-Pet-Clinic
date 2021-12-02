package com.reyrey.springpetclinic.services.map;

import com.reyrey.springpetclinic.model.Visit;
import com.reyrey.springpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    private final VisitService visitService;

    public VisitMapService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet()==null||object.getPet().getOwner()==null||object.getPet().getId()==null||object.getPet().getOwner().getId()==null){
            throw new RuntimeException("invalid visit!");
        }
        return super.save(object);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
