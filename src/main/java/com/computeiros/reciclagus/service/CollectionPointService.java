package com.computeiros.reciclagus.service;

import com.computeiros.reciclagus.dto.CollectionPointRegistrationDto;
import com.computeiros.reciclagus.models.CollectionPoint;
import com.computeiros.reciclagus.repositories.CollectionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionPointService {
    @Autowired
    CollectionPointRepository collPointRepo;

    public List<CollectionPointRegistrationDto> findAll() {
        var list = new ArrayList<CollectionPointRegistrationDto>();
        for(CollectionPoint cp : collPointRepo.findAll()){
            list.add(collectionDtoFrom(cp));
        }
        return list;
    }

    private CollectionPointRegistrationDto collectionDtoFrom(CollectionPoint colle) {
        var dto = new CollectionPointRegistrationDto();
        dto.setCity(colle.getAddress().getCity());
        dto.setComplement(colle.getAddress().getComplement());
        dto.setNeighborhood(colle.getAddress().getNeighborhood());
        dto.setNumber(colle.getAddress().getNumber());
        dto.setState(colle.getAddress().getState());
        dto.setStreet(colle.getAddress().getStreet());
        dto.setId(colle.getId());
        return dto;
    }

    public CollectionPoint save(CollectionPointRegistrationDto newCollPoint){
        var collPoint = new CollectionPoint();
        collPoint.getAddress().setCity(newCollPoint.getCity());
        collPoint.getAddress().setComplement(newCollPoint.getComplement());
        collPoint.getAddress().setNumber(newCollPoint.getNumber());
        collPoint.getAddress().setState(newCollPoint.getState());
        collPoint.getAddress().setStreet(newCollPoint.getStreet());
        collPoint.getAddress().setNeighborhood(newCollPoint.getNeighborhood());
        return collPointRepo.save(collPoint);
    }

}
